package Chapter04_Tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeTest {


  private BinarySearchTree<Integer> theTree;
  private int[] arrayList;

  @Before
  public void setUp() throws Exception {
    theTree = new BinarySearchTree<Integer>();
    arrayList = new int[] {1, 24, 3, 49, 8, 52, 6};
    for (int i : arrayList) {
      theTree.insert(i);
    }
  }

  @Test
  public void contains() {
    Assert.assertEquals(true, theTree.contains(24));
    Assert.assertEquals(true, theTree.contains(1));
    Assert.assertEquals(false, theTree.contains(155));
  }


  @Test
  public void isEmpty() {
    Assert.assertEquals(false, theTree.isEmpty());
    theTree = new BinarySearchTree<Integer>();
    Assert.assertEquals(true, theTree.isEmpty());

  }

  @Test
  public void makeEmpty() {
    Assert.assertEquals(false, theTree.isEmpty());
    theTree.makeEmpty();
    Assert.assertEquals(true, theTree.isEmpty());
  }

  @Test
  public void insert() {
    theTree.insert(567);
    Assert.assertEquals(true, theTree.contains(567));
  }

  @Test
  public void remove() {
    theTree.remove(1);
    Assert.assertEquals(false, theTree.contains(1));

  }

  @Test
  public void findMax() {
    theTree.insert(1000);
    /**
     * generic result upperCast to int.
     */
    int max = theTree.findMax();
    Assert.assertEquals(1000, max);
  }

  @Test
  public void findMin() {
    theTree.insert(-1000);
    int min = theTree.findMin();
    Assert.assertEquals(-1000, min);

  }

}
