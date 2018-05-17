package us.ihmc.idl;

import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import us.ihmc.commons.Assertions;
import us.ihmc.commons.RandomNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static org.junit.Assert.*;

public class RecyclingCappedArrayListTest
{
   @Test(timeout = 30000)
   public void testConstructor()
   {
      RecyclingArrayListPubSub<Object> list = new RecyclingArrayListPubSub<>(Object.class, Object::new, 10);
      assertTrue(list.isEmpty());
      assertTrue(list.size() == 0);
      assertTrue(list.getLast() == null);

      int maxSize = 10;
      list = new RecyclingArrayListPubSub<>(Object.class, Object::new, maxSize);
      assertTrue(list.isEmpty());
      assertTrue(list.size() == 0);
      assertTrue(list.capacity() == 2);
      assertTrue(list.getMaxSize() == 10);

      list.clear();
      assertTrue(list.isEmpty());
      assertTrue(list.size() == 0);
      assertTrue(list.getLast() == null);
   }

   @Test(timeout = 30000)
   public void testAddAndGet()
   {
      RecyclingArrayListPubSub<Object> list = new RecyclingArrayListPubSub<>(Object.class, Object::new, 20);
      ArrayList<Object> expectedList = new ArrayList<>();

      int finalSize = 10;
      for (int i = 0; i < finalSize; i++)
      {
         Object lastObject = list.add();
         expectedList.add(lastObject);
      }

      assertFalse(list.isEmpty());
      assertTrue(list.size() == finalSize);
      for (int i = 0; i < finalSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      assertTrue(list.getLast() == expectedList.get(finalSize - 1));

      try
      {
         list.get(finalSize);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }

      list.clear();
      expectedList.clear();
      assertTrue(list.getLast() == null);

      finalSize = 8;
      for (int i = 0; i < finalSize; i++)
      {
         Object lastObject = list.add();
         expectedList.add(lastObject);
      }

      assertFalse(list.isEmpty());
      assertTrue(list.size() == finalSize);
      for (int i = 0; i < finalSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      assertTrue(list.getLast() == expectedList.get(finalSize - 1));

      list.clear();
      expectedList.clear();
      assertTrue(list.getLast() == null);

      finalSize = 20;
      for (int i = 0; i < finalSize; i++)
      {
         Object lastObject = list.add();
         expectedList.add(lastObject);
      }

      assertFalse(list.isEmpty());
      assertTrue(list.size() == finalSize);
      for (int i = 0; i < finalSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      assertTrue(list.getLast() == expectedList.get(finalSize - 1));
   }

   public class DoubleHolder
   {
      public double value;
   }

   @Test(timeout = 30000)
   public void testMaxSizeIsEnforced()
   {
      RecyclingArrayListPubSub<Object> list = new RecyclingArrayListPubSub<>(Object.class, Object::new, 10);
      Assertions.assertExceptionThrown(RuntimeException.class, () -> {
         for (int i = 0; i < 11; i++)
         {
            list.add();
         }
      });

      RecyclingArrayListPubSub<MutableInt> smallerList = new RecyclingArrayListPubSub<>(MutableInt.class, MutableInt::new, 10);
      RecyclingArrayListPubSub<MutableInt> biggerList = new RecyclingArrayListPubSub<>(MutableInt.class, MutableInt::new, 20);

      for (int i = 0; i < 10; i++)
         smallerList.add();

      for (int i = 0; i < 20; i++)
         biggerList.add();

      Assertions.assertExceptionThrown(RuntimeException.class, () -> {
         smallerList.clear();
         for (int i = 0; i < biggerList.size(); i++)
         {
            smallerList.add().setValue(biggerList.get(i));
         }
      });
   }

   @Test(timeout = 30000)
   public void testGetAndGrowIfNeeded()
   {
      RecyclingArrayListPubSub<Object> list = new RecyclingArrayListPubSub<>(Object.class, Object::new, 120);

      assertTrue(list.isEmpty());
      assertTrue(list.size() == 0);

      int newSize = 10;
      Object lastObject = list.getAndGrowIfNeeded(newSize - 1);

      assertFalse(list.isEmpty());
      assertTrue(list.size() == newSize);

      for (int i = 0; i < newSize; i++)
      {
         assertTrue(list.get(i) != null);
         assertTrue(list.get(i) instanceof Object);
      }

      assertTrue(list.get(newSize - 1) == lastObject);
      assertTrue(list.getLast() == lastObject);

      int previousSize = newSize;
      newSize = 3;
      lastObject = list.getAndGrowIfNeeded(newSize - 1);

      assertFalse(list.isEmpty());
      assertTrue(list.size() == previousSize);

      for (int i = 0; i < newSize; i++)
      {
         assertTrue(list.get(i) != null);
         assertTrue(list.get(i) instanceof Object);
      }

      assertTrue(list.get(newSize - 1) == lastObject);
      assertTrue(list.getLast() == list.get(previousSize - 1));

      newSize = 13;
      lastObject = list.getAndGrowIfNeeded(newSize - 1);

      assertFalse(list.isEmpty());
      assertTrue(list.size() == newSize);

      for (int i = 0; i < newSize; i++)
      {
         assertTrue(list.get(i) != null);
         assertTrue(list.get(i) instanceof Object);
      }

      assertTrue(list.get(newSize - 1) == lastObject);
      assertTrue(list.getLast() == lastObject);
   }

   @Test(timeout = 30000)
   public void growByOne()
   {
      RecyclingArrayListPubSub<Object> list = new RecyclingArrayListPubSub<>(Object.class, Object::new, 10);
      assertTrue(list.isEmpty());

      int maxSize = 0;
      assertTrue(list.size() == maxSize);

      list.growByOne();
      maxSize++;
      assertTrue(list.size() == maxSize);

      list.growByOne();
      maxSize++;
      assertTrue(list.size() == maxSize);

      for (int i = 0; i < maxSize; i++)
      {
         assertTrue(list.get(i) != null);
         assertTrue(list.get(i) instanceof Object);
      }
   }

   @Test(timeout = 30000)
   public void growByN()
   {
      RecyclingArrayListPubSub<Object> list = new RecyclingArrayListPubSub<>(Object.class, Object::new, 50);
      assertTrue(list.isEmpty());

      int maxSize = 0;
      assertTrue(list.size() == maxSize);

      list.growByN(15);
      maxSize += 15;
      assertTrue(list.size() == maxSize);

      list.growByN(1);
      maxSize += 1;
      assertTrue(list.size() == maxSize);

      for (int i = 0; i < maxSize; i++)
      {
         assertTrue(list.get(i) != null);
         assertTrue(list.get(i) instanceof Object);
      }

      try
      {
         list.growByN(-1);
         fail();
      }
      catch (RuntimeException e)
      {
         // Good
      }
   }

   @Test(timeout = 30000)
   public void testFastRemove()
   {
      int maxSize = 10;
      RecyclingArrayListPubSub<Object> list = new RecyclingArrayListPubSub<>(Object.class, Object::new, maxSize);
      assertTrue(list.size() == 0);

      ArrayList<Object> savedList = new ArrayList<>();
      for (int i = 0; i < maxSize; i++)
      {
         list.add();
         savedList.add(list.get(i));
      }

      int indexOfRemovedOject = 3;
      list.fastRemove(indexOfRemovedOject);
      maxSize--;
      assertTrue(list.size() == maxSize);

      for (int i = 0; i < maxSize; i++)
      {
         if (i == indexOfRemovedOject)
            assertTrue(list.get(i) == savedList.get(savedList.size() - 1));
         else
            assertTrue(list.get(i) == savedList.get(i));
      }

      try
      {
         list.fastRemove(maxSize);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }
   }

   @Test(timeout = 30000)
   public void testRemove()
   {
      int maxSize = 10;
      RecyclingArrayListPubSub<MutableInt> list = new RecyclingArrayListPubSub<>(MutableInt.class, MutableInt::new, maxSize);
      for (int i = 0; i < maxSize; i++)
      {
         list.add();
         list.get(i).setValue(10 + i);
      }
      assertTrue(list.size() == maxSize);

      ArrayList<MutableInt> expectedList = new ArrayList<>();
      for (int i = 0; i < maxSize; i++)
         expectedList.add(list.get(i));

      int indexOfRemovedOject = 3;
      list.remove(indexOfRemovedOject);
      expectedList.remove(indexOfRemovedOject);
      maxSize--;
      assertTrue(list.size() == maxSize);

      for (int i = 0; i < maxSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      indexOfRemovedOject = maxSize - 1;
      list.remove(indexOfRemovedOject);
      expectedList.remove(indexOfRemovedOject);
      maxSize--;
      assertTrue(list.size() == maxSize);

      for (int i = 0; i < maxSize; i++)
      {
         assertTrue(list.get(i) == expectedList.get(i));
      }

      try
      {
         list.remove(maxSize);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }
   }

   @Test(timeout = 30000)
   public void testSwap()
   {
      Random rand = new Random(541964L);
      int maxSize = 10;
      RecyclingArrayListPubSub<MutableInt> list = new RecyclingArrayListPubSub<>(MutableInt.class, MutableInt::new, maxSize);
      for (int i = 0; i < maxSize; i++)
      {
         list.add();
         list.get(i).setValue(10 + i);
      }
      assertTrue(list.size() == maxSize);

      ArrayList<MutableInt> expectedList = new ArrayList<>();
      for (int i = 0; i < maxSize; i++)
         expectedList.add(list.get(i));

      for (int k = 0; k < 20; k++)
      {
         int indexA = RandomNumbers.nextInt(rand, 0, maxSize - 1);
         int indexB = RandomNumbers.nextInt(rand, 0, maxSize - 1);
         list.swap(indexA, indexB);
         Collections.swap(expectedList, indexA, indexB);
         assertTrue(list.size() == maxSize);

         for (int i = 0; i < maxSize; i++)
         {
            assertTrue(list.get(i) == expectedList.get(i));
         }
      }

      try
      {
         list.swap(0, maxSize);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }

      try
      {
         list.swap(maxSize, 0);
         fail();
      }
      catch (IndexOutOfBoundsException e)
      {
         // Good
      }
   }

//   @Test(timeout = 30000)
//   public void testInsertAtIndex()
//   {
//      Random rand = new Random(541964L);
//      int maxSize = 100;
//      RecyclingArrayListPubSub<MutableInt> list = new RecyclingArrayListPubSub<>(MutableInt.class, MutableInt::new, 101);
//      for (int i = 0; i < maxSize; i++)
//      {
//         list.add();
//         list.get(i).setValue(10 + i);
//      }
//      assertTrue(list.size() == maxSize);
//
//      ArrayList<MutableInt> expectedList = new ArrayList<>();
//      for (int i = 0; i < maxSize; i++)
//         expectedList.add(list.get(i));
//
//      for (int k = 0; k < 20; k++)
//      {
//         int randomIndex = RandomNumbers.nextInt(rand, 0, maxSize);
//         if (k == 5)
//            randomIndex = maxSize;
//         int newRandomValue = RandomNumbers.nextInt(rand, 0, maxSize);
//         MutableInt newObject = list.insertAtIndex(randomIndex % 100);
//         newObject.setValue(newRandomValue);
//         expectedList.add(randomIndex, newObject);
////         maxSize++;
//         assertTrue(list.size() == maxSize);
//
//         for (int i = 0; i < maxSize; i++)
//            assertTrue(list.get(i) == expectedList.get(i));
//      }
//
//      try
//      {
//         list.insertAtIndex(maxSize + 1);
//         fail();
//      }
//      catch (IndexOutOfBoundsException e)
//      {
//         // Good
//      }
//   }

   @Test(timeout = 30000)
   public void testShuffle()
   {
      Random random = new Random(541964L);
      int maxSize = 100;
      RecyclingArrayListPubSub<MutableInt> list = new RecyclingArrayListPubSub<>(MutableInt.class, MutableInt::new, maxSize);

      for (int i = 0; i < maxSize; i++)
      {
         list.add();
         list.get(i).setValue(10 + i);
      }

      assertTrue(list.size() == maxSize);

      int sumBefore = 0;
      for (int i = 0; i < list.size(); i++)
      {
         MutableInt value = list.get(i);
         sumBefore = sumBefore + value.intValue();
      }
      assertTrue(sumBefore > 0);

      list.shuffle(random);
      assertTrue(list.size() == maxSize);

      int sumAfter = 0;
      for (int i = 0; i < list.size(); i++)
      {
         MutableInt value = list.get(i);
         sumAfter = sumAfter + value.intValue();
      }

      assertEquals(sumBefore, sumAfter);
   }
}
