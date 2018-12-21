package Chapter06_Heap;

import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinaryHeapTest {

  BinaryHeap<Integer> array;

  @Before
  public void setUp() {
    array = new BinaryHeap();
  }

  @Test
  public void insert() {
    array.insert(12);
    Integer minNum = array.findMin();
    Assert.assertEquals(true, minNum == 12);
    Assert.assertEquals(false, array.isEmpty());
    minNum = array.deleteMin();
    Assert.assertEquals(true, minNum == 12);
    Assert.assertEquals(true, array.isEmpty());
  }

  @Test
  public void insertMany() {
    Random random = new Random();
    for (int i = 0; i < 1000; i++) {
      array.insert(random.nextInt(10000));
    }
    array.insert(-10001);
    Assert.assertEquals(true, array.findMin() == -10001);
  }

  @Test
  public void insertDuplicate() {
    for (int i = 0; i < 1000; i++) {
      array.insert(1000);
    }
  }

  @Test
  public void deleteMin() {
    array.insert(12);
    array.insert(11);
    array.insert(1);
    Assert.assertEquals(true, array.findMin() == 1);
  }

  @Test
  public void buildHeap() {
    Integer[] listOfNum = new Integer[] {1, 21, 10, -1, 100, 34, 56, 4567, 65};
    array = new BinaryHeap(listOfNum);
    Integer min = -100000;
    Integer tmp;
    for (int i = 0; i < listOfNum.length; i++) {
      tmp = array.deleteMin();
      Assert.assertEquals(true, tmp > min);
      min = tmp;
    }
    Assert.assertEquals(true, array.isEmpty());

  }

  @Test
  public void enlargeArray() {
    for (int i = 0; i < 11; i++) {
      array.insert(i);
    }
    Assert.assertEquals(true, array.getArrayLength() == 23);
  }

  @Test
  public void isEmpty() {
    Assert.assertEquals(true, array.isEmpty());
    array.insert(1);
    Assert.assertEquals(false, array.isEmpty());
  }

  @Test
  public void makeEmpty() {
    array.insert(1);
    Assert.assertEquals(false, array.isEmpty());
    array.makeEmpty();
    Assert.assertEquals(true, array.isEmpty());

  }
}
