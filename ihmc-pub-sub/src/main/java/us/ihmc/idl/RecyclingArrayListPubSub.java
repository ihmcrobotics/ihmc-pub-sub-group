package us.ihmc.idl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.function.Supplier;

public class RecyclingArrayListPubSub<T> implements List<T>
{
   private final Class<T> clazz;
   private T[] values;
   private int size = 0;
   private Supplier<T> allocator;

   /**
    * Temporarily needed to enable Kryo to serialize DDS messages.
    */
   @Deprecated
   public RecyclingArrayListPubSub()
   {
      clazz = null;
      values = null;
   }

   @SuppressWarnings("unchecked")
   public RecyclingArrayListPubSub(Class<T> clazz, Supplier<T> allocator, int initialSize)
   {
      this.clazz = clazz;
      values = (T[]) new Object[initialSize];
      size = initialSize;
      this.allocator = allocator;

      fillElementDataIfNeeded();
      clear();
   }

   public void shuffle(Random random)
   {
      for (int i = size; i > 1; i--)
      {
         unsafeSwap(i - 1, random.nextInt(i));
      }
   }

   /**
    * Returns the number of elements in this list.
    *
    * @return the number of elements in this list
    */
   @Override
   public int size()
   {
      return size;
   }

   /**
    * Returns <tt>true</tt> if this list contains no elements.
    *
    * @return <tt>true</tt> if this list contains no elements
    */
   @Override
   public boolean isEmpty()
   {
      return size == 0;
   }

   /**
    * Sets the size of the list to 0, but does not change its capacity. This method is meant
    * to recycle a list without allocating new backing arrays.
    */
   @Override
   public void clear()
   {
      size = 0;
   }

   /**
    * Add a new element at the end of this list.
    *
    * @return the new element.
    */
   public T add()
   {
      return getAndGrowIfNeeded(size);
   }

   /**
    * Inserts a new element at the specified position in this
    * list. Shifts the element currently at that position (if any) and
    * any subsequent elements to the right (adds one to their indices).
    *
    * @param index index at which the new element is to be inserted
    * @return the new inserted element
    * @throws IndexOutOfBoundsException if the index is out of range
    * (<tt>index &lt; 0 || index &gt;= size()</tt>)
    */
   public T insertAtIndex(int index)
   {
      rangeCheckForInsert(index);

      // First add new element at last index
      T ret = add();

      // Then go trough the list by swapping elements two by two to reach the desired index
      for (int i = size - 1; i > index; i--)
         unsafeFastSwap(i, i - 1);

      return ret;
   }

   /**
    * Returns the element at the specified position in this list.
    *
    * @param i index of the element to return
    * @return the element at the specified position in this list
    * @throws IndexOutOfBoundsException if the index is out of range
    * (<tt>index &lt; 0 || index &gt;= size()</tt>)
    */
   @Override
   public T get(int i)
   {
      rangeCheck(i);
      return unsafeGet(i);
   }

   /**
    * Returns the first element of this list.
    * If the list is empty, it returns {@code null}.
    *
    * @return the first element of this list
    */
   public T getFirst()
   {
      if (isEmpty())
         return null;
      else
         return unsafeGet(0);
   }

   /**
    * Returns the last element of this list.
    * If the list is empty, it returns {@code null}.
    *
    * @return the last element of this list
    */
   public T getLast()
   {
      if (isEmpty())
         return null;
      else
         return unsafeGet(size - 1);
   }

   protected T unsafeGet(int i)
   {
      return values[i];
   }

   /**
    * Returns the element at the specified position in this list.
    * The list will grow if the given index is greater or equal to
    * the size this list.
    *
    * @param index index of the element to return
    * @return the element at the specified position in this list
    * @throws IndexOutOfBoundsException if the index is negative (<tt>index &lt; 0</tt>)
    */
   public T getAndGrowIfNeeded(int index)
   {
      positiveIndexCheck(index);

      if (index >= size)
      {
         size = index + 1;
         ensureCapacity(size);
      }

      return values[index];
   }

   public void growByOne()
   {
      unsafeGrowByN(1);
   }

   public void growByN(int numberOfElementsToGrow)
   {
      if (numberOfElementsToGrow == 0)
         return;
      else if (numberOfElementsToGrow < 0)
         throw new RuntimeException("Cannot grow the list by a negative number. Given number for growing list:" + numberOfElementsToGrow);
      unsafeGrowByN(numberOfElementsToGrow);
   }

   protected void unsafeGrowByN(int n)
   {
      size += n;
      ensureCapacity(size);
   }

   /**
    * Removes the element at the specified position in this list.
    * This method is faster than {@link us.ihmc.idl.RecyclingArrayListPubSub#remove(int)} but the ith element is swapped with the last element changing the ordering of the list.
    *
    * @param index the index of the element to be removed
    */
   public void fastRemove(int index)
   {
      if (index == size - 1)
      {
         size--;
         return;
      }
      rangeCheck(index);
      unsafeFastSwap(index, --size);
   }

   /**
    * Swap two objects of this list.
    *
    * @param i index of the first object to swap
    * @param j index of the second object to swap
    * @throws IndexOutOfBoundsException if either of the indices is out of range
    * (<tt>i &lt; 0 || i &gt;= size() || j &lt; 0 || j &gt;= size()</tt>)
    */
   public void swap(int i, int j)
   {
      rangeCheck(i);
      rangeCheck(j);

      unsafeSwap(i, j);
   }

   protected void unsafeSwap(int i, int j)
   {
      if (i == j)
         return;

      unsafeFastSwap(i, j);
   }

   private void unsafeFastSwap(int i, int j)
   {
      T t = values[i];
      values[i] = values[j];
      values[j] = t;
   }

   /**
    * Removes the element at the specified position in this list.
    * Shifts any subsequent elements to the left (subtracts one from their
    * indices).
    *
    * @param i the index of the element to be removed
    * @return null.
    */
   @Override
   public T remove(int i)
   {
      if (i == size - 1)
      {
         size--;
         return null;
      }
      rangeCheck(i);

      T t = values[i];

      while (i < size - 1)
      {
         values[i] = values[++i];
      }

      // Do not throw away the removed element, put it at the end of the list instead.
      values[size - 1] = t;
      size--;
      return null;
   }

   /**
    * Removes the first occurrence of the specified element from this list,
    * if it is present.  If the list does not contain the element, it is
    * unchanged.
    *
    * @param object element to be removed from this list, if present
    * @return <tt>true</tt> if this list contained the specified element
    */
   @Override
   public boolean remove(Object object)
   {
      int index = indexOf(object);
      if (index == -1)
         return false;
      else
      {
         remove(index);
         return true;
      }
   }

   private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

   protected void ensureCapacity(int minCapacity)
   {
      if (minCapacity <= values.length)
         return;

      int previousArraySize = values.length;
      int newArraySize = previousArraySize + (previousArraySize >> 1);
      if (newArraySize - minCapacity < 0)
         newArraySize = minCapacity;
      if (newArraySize - MAX_ARRAY_SIZE > 0)
         newArraySize = checkWithMaxCapacity(minCapacity);

      values = Arrays.copyOf(values, newArraySize);

      for (int i = previousArraySize; i < newArraySize; i++)
      {
         values[i] = allocator.get();
      }
   }

   private static int checkWithMaxCapacity(int minCapacity)
   {
      if (minCapacity < 0) // overflow
         throw new OutOfMemoryError();
      return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
   }

   private void fillElementDataIfNeeded()
   {
      for (int i = 0; i < values.length; i++)
      {
         if (values[i] == null)
            values[i] = allocator.get();
      }
   }

   /**
    * Checks if the given index is in range.  If not, throws an appropriate
    * runtime exception.  This method does *not* check if the index is
    * negative: It is always used immediately prior to an array access,
    * which throws an ArrayIndexOutOfBoundsException if index is negative.
    */
   protected void rangeCheck(int index)
   {
      if (index >= size)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      positiveIndexCheck(index);
   }

   protected void rangeCheckForInsert(int index)
   {
      if (index > size)
         throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
      positiveIndexCheck(index);
   }

   protected void positiveIndexCheck(int index)
   {
      if (index < 0)
         throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
   }

   /**
    * Returns <tt>true</tt> if this list contains the specified element.
    *
    * @param object element whose presence in this list is to be tested
    * @return <tt>true</tt> if this list contains the specified element
    */
   @Override
   public boolean contains(Object object)
   {
      return indexOf(object) >= 0;
   }

   /**
    * Returns the index of the first occurrence of the specified element
    * in this list, or -1 if this list does not contain the element.
    */
   @Override
   public int indexOf(Object object)
   {
      if (object != null)
      {
         for (int i = 0; i < size; i++)
         {
            if (object.equals(values[i]))
               return i;
         }
      }
      return -1;
   }

   /**
    * Returns the index of the last occurrence of the specified element
    * in this list, or -1 if this list does not contain the element.
    */
   @Override
   public int lastIndexOf(Object object)
   {
      if (object != null)
      {
         for (int i = size - 1; i >= 0; i--)
         {
            if (object.equals(values[i]))
               return i;
         }
      }
      return -1;
   }

   @Override
   public Object[] toArray()
   {
      return Arrays.copyOf(values, size);
   }

   @SuppressWarnings("unchecked")
   @Override
   public <X> X[] toArray(X[] a)
   {
      if (a.length < size)
         // Make a new array of a's runtime type, but my contents:
         return (X[]) Arrays.copyOf(values, size, a.getClass());
      System.arraycopy(values, 0, a, 0, size);
      if (a.length > size)
         a[size] = null;
      return a;
   }

   @Override
   public boolean equals(Object obj)
   {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      RecyclingArrayListPubSub<?> other = (RecyclingArrayListPubSub<?>) obj;
      if (clazz == null)
      {
         if (other.clazz != null)
            return false;
      }
      else if (!clazz.equals(other.clazz))
         return false;
      if (size != other.size)
         return false;
      for (int i = 0; i < size(); i++)
      {
         if (!values[i].equals(other.values[i]))
            return false;
      }
      return true;
   }

   @Override
   public String toString()
   {
      if (isEmpty())
         return "Empty list";

      String ret = "";

      for (int i = 0; i < size - 1; i++)
         ret += unsafeGet(i).toString() + "\n";
      ret += unsafeGet(size - 1).toString();

      return ret;
   }

   @Override
   public Iterator<T> iterator()
   { // TODO This is needed only for supporting Kryo, needs to be either improved or removed.
      return Arrays.asList(values).subList(0, size).iterator();
   }

   /** Unsupported operation. */
   @Override
   public boolean add(T e)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public boolean containsAll(Collection<?> c)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public boolean addAll(Collection<? extends T> c)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public boolean addAll(int index, Collection<? extends T> c)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public boolean removeAll(Collection<?> c)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public boolean retainAll(Collection<?> c)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public T set(int index, T element)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public void add(int index, T element)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public ListIterator<T> listIterator()
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public ListIterator<T> listIterator(int index)
   {
      throw new UnsupportedOperationException();
   }

   /** Unsupported operation. */
   @Override
   public List<T> subList(int fromIndex, int toIndex)
   {
      throw new UnsupportedOperationException();
   }
}
