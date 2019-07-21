package Chapter12_AdvancedDataStructuresAndImplementation;

import org.junit.Assert;
import org.junit.Test;

public class SplayTreeTest {

  SplayTree<Integer> splayTree = new SplayTree<>();

  @Test
  public void insert() {
    splayTree.insert(10);
    Assert.assertTrue(splayTree.contains(10));
  }

  @Test
  public void remove() {
    splayTree.insert(2);
    splayTree.contains(2);
    splayTree.remove(2);
    Assert.assertTrue(!splayTree.contains(2));
  }

  @Test
  public void findMin() {
    splayTree.insert(12);
    splayTree.insert(30);
    splayTree.insert(2);
    splayTree.insert(3);
    splayTree.insert(6);
    Assert.assertEquals(new Integer(2), splayTree.findMin());
    splayTree.remove(30);
    Assert.assertEquals(new Integer(2), splayTree.findMin());
    splayTree.remove(2);
    Assert.assertEquals(new Integer(3), splayTree.findMin());
  }

  @Test
  public void findMax() {
    splayTree.insert(12);
    splayTree.insert(30);
    splayTree.insert(2);
    splayTree.insert(3);
    splayTree.insert(6);
    Assert.assertEquals(new Integer(30), splayTree.findMax());
    splayTree.remove(12);
    Assert.assertEquals(new Integer(30), splayTree.findMax());
    splayTree.remove(30);
    Assert.assertEquals(new Integer(6), splayTree.findMax());

  }

  @Test
  public void makeEmpty() {
    Assert.assertTrue(splayTree.isEmpty());
    splayTree.insert(1);
    splayTree.insert(3);
    splayTree.insert(10);
    Assert.assertTrue(!splayTree.isEmpty());
    splayTree.makeEmpty();
    Assert.assertTrue(splayTree.isEmpty());

  }

  @Test
  public void isEmpty() {
    Assert.assertTrue(splayTree.isEmpty());
    splayTree.insert(10);
    Assert.assertTrue(!splayTree.isEmpty());
    splayTree.remove(10);
    Assert.assertTrue(splayTree.isEmpty());
  }

  @Test
  public void batchOperation() {
    splayTree.insert(6);
    splayTree.insert(6);
    splayTree.insert(30);
    splayTree.insert(22);
    splayTree.insert(1);
    splayTree.insert(2);
    Assert.assertTrue(splayTree.contains(6));
    splayTree.remove(6);
    Assert.assertTrue(!splayTree.contains(6));
    splayTree.remove(30);
    Assert.assertEquals(new Integer(22), splayTree.findMax());
    splayTree.insert(56);
    Assert.assertEquals(new Integer(56), splayTree.findMax());
    splayTree.remove(6);
    splayTree.remove(30);
    splayTree.remove(22);
    splayTree.remove(1);
    splayTree.remove(2);
    Assert.assertEquals(new Integer(56), splayTree.findMax());
    splayTree.remove(56);
    Assert.assertTrue(splayTree.isEmpty());

  }

}
