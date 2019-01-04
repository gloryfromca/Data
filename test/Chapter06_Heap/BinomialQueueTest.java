package Chapter06_Heap;

import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinomialQueueTest {
  BinomialQueue<Integer> theQueue;
  Random random = new Random();

  @Before
  public void setUp() {
    theQueue = new BinomialQueue<>();
  }

  @Test
  public void capacity() {
    Assert.assertEquals(true, theQueue.isEmpty());
    theQueue.insert(1);
    Assert.assertEquals(1, theQueue.capacity());
    theQueue.insert(10);
    Assert.assertEquals(3, theQueue.capacity());
    for (int i = 0; i < 10; i++) {
      theQueue.insert(i);
    }
    Assert.assertEquals(15, theQueue.capacity());

  }

  @Test
  public void expendTheTrees() {
    for (int i = 1; i < 10; i++) {
      theQueue.expendTheTrees(i);
      Assert.assertEquals(true, theQueue.capacity() == (1 << i) - 1);
    }
  }

  @Test
  public void insert() {
    for (int i = 0; i < 1000; i++) {
      theQueue.insert(random.nextInt(2000));
    }
  }

  @Test
  public void merge() {
    BinomialQueue<Integer> otherQueue = new BinomialQueue<>();

    otherQueue.insert(-100);
    for (int i = 0; i < 100; i++) {
      otherQueue.insert(random.nextInt(1000));
    }
    theQueue.merge(otherQueue);
    Assert.assertEquals(true, theQueue.findMin() == -100);
  }


  @Test
  public void isEmpty() {
    Assert.assertEquals(true, theQueue.isEmpty());
    theQueue.insert(10);
    Assert.assertEquals(false, theQueue.isEmpty());
    theQueue.deleteMin();
    Assert.assertEquals(true, theQueue.isEmpty());
  }

  @Test
  public void makeEmpty() {
    theQueue.insert(10);
    theQueue.makeEmpty();
    Assert.assertEquals(true, theQueue.isEmpty());
  }

  @Test
  public void findMinIndex() {
    theQueue.insert(10);
    Assert.assertEquals(true, theQueue.findMinIndex() == 0);
    theQueue.insert(13);
    Assert.assertEquals(true, theQueue.findMinIndex() == 1);
    theQueue.insert(11);
    Assert.assertEquals(true, theQueue.findMinIndex() == 1);
    theQueue.insert(100);
    Assert.assertEquals(true, theQueue.findMinIndex() == 2);

  }

  @Test
  public void findMin() {
    theQueue.insert(10);
    Assert.assertEquals(true, theQueue.findMin() == 10);
    theQueue.insert(100);
    Assert.assertEquals(true, theQueue.findMin() == 10);
    theQueue.insert(1);
    Assert.assertEquals(true, theQueue.findMin() == 1);
  }


  @Test
  public void deleteMin() {
    int[] nums = new int[] {-1, 10, 50, -2, 6, 7, 100, 345, 54, 567, 123, 4};
    for (int element : nums) {
      theQueue.insert(element);
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      Assert.assertEquals(true, theQueue.deleteMin() == nums[i]);
    }

  }
}
