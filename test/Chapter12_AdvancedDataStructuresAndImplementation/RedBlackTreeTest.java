package Chapter12_AdvancedDataStructuresAndImplementation;

import org.junit.Assert;
import org.junit.Test;

public class RedBlackTreeTest {

  RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();


  @Test
  public void insert() {
    redBlackTree.insert(2);
    redBlackTree.insert(10);
    redBlackTree.insert(3);
    Assert.assertTrue(redBlackTree.contains(10));
    Assert.assertTrue(redBlackTree.contains(2));
    Assert.assertTrue(redBlackTree.contains(3));

  }

  @Test
  public void findMinAndMax() {
    redBlackTree.insert(2);
    redBlackTree.insert(10);
    redBlackTree.insert(23);
    redBlackTree.insert(45);
    redBlackTree.insert(3);
    Assert.assertEquals(redBlackTree.findMax(), new Integer(45));
    Assert.assertEquals(redBlackTree.findMin(), new Integer(2));
    redBlackTree.insert(56);
    Assert.assertEquals(redBlackTree.findMax(), new Integer(56));
    redBlackTree.insert(1);
    Assert.assertEquals(redBlackTree.findMin(), new Integer(1));
  }

  @Test
  public void contains() {
    redBlackTree.insert(23);
    redBlackTree.insert(45);
    Assert.assertTrue(redBlackTree.contains(23));
    Assert.assertTrue(redBlackTree.contains(45));
    Assert.assertTrue(!redBlackTree.contains(2));
    Assert.assertTrue(!redBlackTree.contains(10));
  }

  @Test
  public void testEmpty() {
    Assert.assertTrue(redBlackTree.isEmpty());
    redBlackTree.insert(23);
    redBlackTree.insert(45);
    Assert.assertTrue(!redBlackTree.isEmpty());
    redBlackTree.makeEmpty();
    Assert.assertTrue(redBlackTree.isEmpty());
  }
}

