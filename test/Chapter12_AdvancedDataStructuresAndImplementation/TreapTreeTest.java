package Chapter12_AdvancedDataStructuresAndImplementation;

import org.junit.Assert;
import org.junit.Test;

public class TreapTreeTest {

  TreapTree<Integer> treapTree = new TreapTree<>();

  @Test
  public void findMinAndMax() {
    treapTree.insert(10);
    treapTree.insert(1);
    Assert.assertEquals(new Integer(1), treapTree.findMin());
    Assert.assertEquals(new Integer(10), treapTree.findMax());
  }

  @Test
  public void testEmpty() {
    Assert.assertTrue(treapTree.isEmpty());
    treapTree.insert(1);
    Assert.assertTrue(!treapTree.isEmpty());
    treapTree.remove(1);
    Assert.assertTrue(treapTree.isEmpty());
    treapTree.insert(10);
    treapTree.insert(2);
    Assert.assertTrue(!treapTree.isEmpty());
    treapTree.makeEmpty();
    Assert.assertTrue(treapTree.isEmpty());
  }

  @Test
  public void insertAndRemove() {
    Assert.assertTrue(!treapTree.contains(10));
    treapTree.insert(10);
    treapTree.insert(12);
    treapTree.insert(78);
    treapTree.insert(2);
    treapTree.insert(45);
    Assert.assertTrue(treapTree.contains(10));
    Assert.assertTrue(treapTree.contains(78));
    Assert.assertTrue(!treapTree.contains(122));
    treapTree.remove(2);
    treapTree.remove(45);
    Assert.assertTrue(!treapTree.contains(2));
    Assert.assertTrue(!treapTree.contains(45));
    treapTree.remove(12);
    Assert.assertTrue(!treapTree.contains(12));
    treapTree.insert(45);
    Assert.assertTrue(treapTree.contains(45));
  }
}
