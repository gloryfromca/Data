package Chapter12_AdvancedDataStructuresAndImplementation;

import java.util.Arrays;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class PairingHeapTest {

  Random random = new Random();
  PairingHeap<Integer> pairingHeap = new PairingHeap<>();

  @Test
  public void insert() {
    pairingHeap.insert(4);
    Assert.assertEquals((int) pairingHeap.findMin(), 4);
  }

  @Test
  public void decreaseKey() {
    int[] x = new int[] {4, 6, 78, 34, 10, 6, 8, 34, 7, 1, 6, 23};
    for (int item : x) {
      pairingHeap.insert(item + 1);
    }
    PairingHeap.Position<Integer> pairNode = pairingHeap.insert(100);
    pairingHeap.decreaseKey(pairNode, 1);
    Assert.assertEquals((int) pairingHeap.findMin(), 1);
  }

  @Test
  public void deleteMin() {
    int[] x = new int[] {4, 56, 52, 61, 52, 8, 12};
    for (int item : x) {
      pairingHeap.insert(item);
    }
    int[] xWithOrder = Arrays.copyOf(x, x.length);
    Arrays.sort(xWithOrder);
    for (int item : xWithOrder) {
      Assert.assertEquals((int) pairingHeap.deleteMin(), item);
    }
  }

  @Test
  public void findMin() {
    int min = 1;
    pairingHeap.insert(min);
    for (int i = 0; i < 100; i++) {
      pairingHeap.insert(random.nextInt(100) + 1);
    }
    Assert.assertEquals((int) pairingHeap.findMin(), min);
  }

  @Test
  public void makeEmpty() {
    pairingHeap.insert(4);
    Assert.assertTrue(!pairingHeap.isEmpty());
    pairingHeap.makeEmpty();
    Assert.assertTrue(pairingHeap.isEmpty());
  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(pairingHeap.isEmpty());
    pairingHeap.insert(4);
    Assert.assertTrue(!pairingHeap.isEmpty());
  }
}
