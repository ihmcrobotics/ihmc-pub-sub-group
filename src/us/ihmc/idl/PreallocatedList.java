package us.ihmc.idl;

import java.lang.reflect.Array;

/**
 * Preallocated list of Objects or Enums.
 * 
 * This object preallocates the maximum number of instances. 
 * No setter is provided, use add(), remove() and get(i) to add, remove or get elements and change them in place. 
 * 
 * @author Jesper Smith
 *
 * @param <T>
 */
public class PreallocatedList<T>
{
   private final T[] values;
   private int pos = -1;

   @SuppressWarnings("rawtypes")
   private final Enum[] constants;
   private final boolean isEnum;

   @SuppressWarnings("unchecked")
   public PreallocatedList(Class<T> clazz, ListAllocator<T> allocator, int maxSize)
   {
      this.values = (T[]) Array.newInstance(clazz, maxSize);
      this.isEnum = false;
      this.constants = null;
      for (int i = 0; i < maxSize; i++)
      {
         values[i] = allocator.createInstance();
      }
   }

   @SuppressWarnings({"unchecked", "rawtypes"})
   public PreallocatedList(Class<T> clazz, Enum[] constants, int maxSize)
   {
      this.values = (T[]) Array.newInstance(clazz, maxSize);
      this.isEnum = true;
      this.constants = constants;
   }

   public interface ListAllocator<T>
   {
      T createInstance();
   }
   
   /**
    * 
    * @return true if this is a List of enums
    */
   public boolean isEnum()
   {
      return isEnum;
   }

   /**
    * 
    * @return the enum constants of the underlying enum
    * @throws RuntimeException if isEnum() is false
    */
   @SuppressWarnings("rawtypes")
   public Enum[] getEnumConstants()
   {
      if(!isEnum)
      {
         throw new RuntimeException("This list is not filled with Enums");
      }
      return constants;
   }
   
   /**
    * Clears the list. 
    * 
    * This function just resets the size to 0. The underlying data objects are not emptied or removed.
    */

   public void resetQuick()
   {
      pos = -1;
   }

   /**
    * Add a value and return a handle to the object.
    * 
    * Do not use for Enum sequences.
    * 
    * @return value at the last position. This object can still hold data.
    */
   public T add()
   {
      if (isEnum)
      {
         throw new RuntimeException("Cannot add() enum to enum sequences. Use add(T) instead.");
      }
      if (pos + 1 >= this.values.length)
      {
         throw new ArrayIndexOutOfBoundsException("Cannot add element to sequence, max size is violated");
      }
      return values[++pos];
   }

   /**
    * Add an enum value.
    * 
    * Use for enum sequences 
    * 
    * @param Enum value
    */
   public void add(T value)
   {
      if (!isEnum)
      {
         throw new RuntimeException("Cannot add(T value) to object sequences. Use T add() instead");
      }
      if (pos + 1 >= this.values.length)
      {
         throw new ArrayIndexOutOfBoundsException("Cannot add element to sequence, max size is violated");
      }
      values[++pos] = value;
   }

   /**
    * Removes the last element in the list. The underlying data object is not emptied or removed
    */
   public void remove()
   {
      if (pos < 0)
      {
         throw new ArrayIndexOutOfBoundsException("List is empty");
      }
      --pos;
   }

   /**
    * Get the element at position i. To change the element, use get() and 
    * 
    * @param i Position to get element at
    * @return Element at position i.
    */
   public T get(int i)
   {
      if (i < 0 || i > pos)
      {
         throw new ArrayIndexOutOfBoundsException("Position is not valid in the list, size is " + size() + ", requested element is " + i);
      }
      return values[i];
   }

   /**
    * Set the Enum value at position i. 
    * 
    * @param i
    * @param value
    */
   public void setEnum(int i, T value)
   {
      if (!isEnum)
      {
         throw new RuntimeException("Cannot set() object sequences. Use T get(int i) instead");
      }
      if (i < 0 || i > pos)
      {
         throw new ArrayIndexOutOfBoundsException("Position is not valid in the list, size is " + size() + ", requested element is " + i);
      }
      values[i] = value;
   }

   /**
    * Clears the list
    */
   public void clear()
   {
      resetQuick();
   }

   /**
    * Returns the number of active elements in this list
    */
   public int size()
   {
      return pos + 1;
   }

}
