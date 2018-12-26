package Chapter06_Heap;

import java.util.Arrays;
import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LeftistHeapTest {
  LeftistHeap<Integer> leftistHeap;
  Random random = new Random();

  @Before
  public void setUp() {
    leftistHeap = new LeftistHeap<>();
  }

  @After
  public void tearDown() {}

  @Test
  public void isEmpty() {
    Assert.assertEquals(true, leftistHeap.isEmpty());
    leftistHeap.insert(1);
    Assert.assertEquals(false, leftistHeap.isEmpty());
  }

  @Test
  public void makeEmpty() {
    leftistHeap.insert(1);
    Assert.assertEquals(false, leftistHeap.isEmpty());
    leftistHeap.makeEmpty();
    Assert.assertEquals(true, leftistHeap.isEmpty());
  }

  @Test
  public void insert() {
    leftistHeap.insert(12);
    Assert.assertEquals(true, leftistHeap.findMin() == 12);
  }

  @Test
  public void findMin() {
    for (int i = 0; i < 100; i++) {
      leftistHeap.insert(random.nextInt(1000));
    }
    leftistHeap.insert(-101);
    Assert.assertEquals(true, leftistHeap.findMin() == -101);

  }

  @Test
  public void findMin1() {
    for (int i = 0; i < 1000; i++) {
      leftistHeap.insert(random.nextInt(1000));
    }

    int tmp = -10000;
    int min;
    for (int i = 0; i < 1000; i++) {
      min = leftistHeap.findMin();
      Assert.assertEquals(true, tmp <= min);
      tmp = min;
      leftistHeap.deleteMin();
    }
  }

  @Test
  public void deleteMin() {
    Integer[] elements = {-234, -20, -1, 3, 6, 10, 20, 56, 100, 101};
    for (Integer element : elements) {
      leftistHeap.insert(element);
    }
    for (Integer element : elements) {
      Assert.assertEquals(element, leftistHeap.findMin());
      leftistHeap.deleteMin();
    }
  }

  @Test
  public void merge() {
    LeftistHeap<Integer> otherHeap = new LeftistHeap<>();
    for (int i = 0; i < 100; i++) {
      otherHeap.insert(random.nextInt(1000));
    }
    leftistHeap.merge(otherHeap);
  }

  @Test
  public void merge1() {
    LeftistHeap<Integer> otherHeap = new LeftistHeap<>();
    int[] elements = {-16, 18, 20, 67, 120};
    int[] otherElements = {-11, 10, 30, 100};
    int elementsLength = elements.length;
    for (int element : elements) {
      leftistHeap.insert(element);
    }
    for (int element : otherElements) {
      otherHeap.insert(element);
    }
    elements = Arrays.copyOf(elements, elements.length + otherElements.length);
    System.arraycopy(otherElements, 0, elements, elementsLength, otherElements.length);
    Arrays.sort(elements);
    for (Integer element : elements) {
      System.out.println(element);
    }
    leftistHeap.merge(otherHeap);

    for (int i = 0; i < elements.length; i++) {
      Assert.assertEquals(true, leftistHeap.findMin() == elements[i]);
      leftistHeap.deleteMin();

    }
  }

}
