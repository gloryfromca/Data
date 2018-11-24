package Chapter04_Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class BinarySearchTreeTest {

  private Class theTreeClass;
  private BinarySearchTree<Integer> theTree;
  private int[] arrayList;


  @Parameterized.Parameters
  public static Collection<Object[]> differentClass() {
    Collection<Object[]> params = new ArrayList() {};
    params.add(new Object[] {BinarySearchTree.class});
    params.add(new Object[] {AvlTree.class});
    return params;
  }

  public BinarySearchTreeTest(Class theTreeClass) {
    /**
     * the constructor of class can't be decorated by `void`.
     */
    this.theTreeClass = theTreeClass;
    this.arrayList = null;
    this.theTree = null;
  }

  @Before
  public void setUp() throws Exception {
    if (this.theTreeClass == BinarySearchTree.class) {

      theTree = (BinarySearchTree<Integer>) this.theTreeClass.newInstance();
    } else {
      theTree = (AvlTree<Integer>) this.theTreeClass.newInstance();
    }
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

  @Test
  public void checkBalance() {
    Random random = new Random();
    if (this.theTreeClass == BinarySearchTree.class) {
      // System.out.println("1 BinarySearchTree is not balanced");
    } else {
      AvlTree<Integer> theTree = (AvlTree<Integer>) this.theTree;
      // System.out.println("check AvlTree start...");
      Boolean randBalanceResult;

      for (int x = 0; x < 1000; x++) {
        Boolean isRemove = random.nextBoolean();
        Integer randomInt = random.nextInt(150);
        // System.out.println(String.format("isRemove:%s randomInt:%d", isRemove, randomInt));
        if (isRemove) {
          theTree.remove(randomInt);
        } else {
          theTree.insert(randomInt);
        }
        randBalanceResult = theTree.checkBalance();
        Assert.assertEquals(randBalanceResult, true);

      }
    }
  }

  @Test
  public void checkBalance2() {
    Random random = new Random();
    if (this.theTreeClass == BinarySearchTree.class) {
      // System.out.println("2 BinarySearchTree is not balanced");
    } else {
      AvlTree<Integer> theTree = (AvlTree<Integer>) this.theTree;
      // System.out.println("2 check AvlTree start...");
      Boolean randBalanceResult;

      for (int x = 0; x < 1000; x++) {
        Integer randomInt = random.nextInt(300);
        theTree.insert(randomInt);
        randBalanceResult = theTree.checkBalance();
        Assert.assertEquals(randBalanceResult, true);

      }
    }
  }

  @Test
  public void checkBalance3() {
    Random random = new Random();
    if (this.theTreeClass == BinarySearchTree.class) {
      // System.out.println("3 BinarySearchTree is not balanced");
    } else {
      AvlTree<Integer> theTree = (AvlTree<Integer>) this.theTree;
      // System.out.println("3 check AvlTree start...");
      Boolean randBalanceResult;
      for (int x = 0; x < 1000; x++) {
        Integer randomInt = random.nextInt(300);
        theTree.insert(randomInt);
      }
      for (int x = 0; x < 1000; x++) {
        Integer randomInt = random.nextInt(300);
        theTree.remove(randomInt);
        randBalanceResult = theTree.checkBalance();
        Assert.assertEquals(randBalanceResult, true);

      }
    }
  }

  @Test
  public void printTree() {
    Random random = new Random();
    for (int x = 0; x < 200; x++) {
      Integer randomInt = random.nextInt(400);
      theTree.insert(randomInt);
    }
    theTree.printTree();
  }

}
