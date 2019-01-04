package Chapter06_Heap;

public class BinomialQueue<T extends Comparable<? super T>> {
  private int currentSize;
  private Node<T>[] theTrees;
  private final static int DEFAULT_TREES = 1;

  private static class Node<T> {
    T element;
    Node<T> leftChild;
    Node<T> nextSibling;

    public Node(T theElement) {
      this(theElement, null, null);
    }

    public Node(T element, Node<T> leftChild, Node<T> nextSibling) {
      this.element = element;
      this.leftChild = leftChild;
      this.nextSibling = nextSibling;
    }
  }

  public BinomialQueue() {
    theTrees = new Node[DEFAULT_TREES];
    makeEmpty();
  }

  public BinomialQueue(T item) {
    this();
    // using `insert` will cause unstoppable loop.
    // insert(item);
    currentSize = 1;
    theTrees[0] = new Node(item);

  }

  public int capacity() {
    return (1 << theTrees.length) - 1;

  }

  public void expendTheTrees(int newNumTrees) {
    Node<T>[] theNewTrees = new Node[newNumTrees];
    for (int i = 0; i < theTrees.length; i++) {
      theNewTrees[i] = theTrees[i];
    }
    theTrees = theNewTrees;
  }

  private Node<T> combineTrees(Node<T> t1, Node<T> t2) {
    if (t1.element.compareTo(t2.element) > 0) {
      return combineTrees(t2, t1);
    }
    t2.nextSibling = t1.leftChild;
    t1.leftChild = t2;
    return t1;

  }

  public void insert(T x) {
    merge(new BinomialQueue<>(x));
  }


  public void merge(BinomialQueue<T> rhs) {
    if (this == rhs) {
      return;
    }
    currentSize += rhs.currentSize;

    if (currentSize > capacity()) {
      int maxLength = Math.max(theTrees.length, rhs.theTrees.length);
      expendTheTrees(maxLength + 1);
    }
    Node<T> carry = null;

    for (int i = 0, j = 1; j <= currentSize; i++, j *= 2) {
      Node<T> t1 = theTrees[i];
      Node<T> t2 = i < rhs.theTrees.length ? rhs.theTrees[i] : null;
      int whichCase = t1 == null ? 0 : 1;
      whichCase += t2 == null ? 0 : 2;
      whichCase += carry == null ? 0 : 4;
      switch (whichCase) {
        case 0:
        case 1:
          break;
        case 2:
          theTrees[i] = t2;
          rhs.theTrees[i] = null;
          break;
        case 3:
          carry = combineTrees(t1, t2);
          theTrees[i] = rhs.theTrees[i] = null;
          break;
        case 4:
          theTrees[i] = carry;
          carry = null;
          break;
        case 5:
          carry = combineTrees(t1, carry);
          theTrees[i] = null;
          break;
        case 6:
          carry = combineTrees(t2, carry);
          theTrees[i] = null;
          break;
        case 7:
          theTrees[i] = carry;
          carry = combineTrees(t1, t2);
          rhs.theTrees[i] = null;
          break;
      }
    }
    for (int k = 0; k < rhs.theTrees.length; k++) {
      rhs.theTrees[k] = null;
    }
    rhs.currentSize = 0;


  }

  public Boolean isEmpty() {
    return currentSize == 0;
  }

  public void makeEmpty() {
    currentSize = 0;
    for (int i = 0; i < theTrees.length; i++) {
      theTrees[i] = null;
    }
  }

  public int findMinIndex() {
    int minIndex = -1;
    Node<T> currentElement;

    for (int i = 0; i < theTrees.length; i++) {
      currentElement = theTrees[i];
      if (currentElement != null) {
        if (minIndex == -1) {
          minIndex = i;
        } else if (currentElement.element.compareTo(theTrees[minIndex].element) < 0) {
          minIndex = i;
        }
      }
    }

    return minIndex;
  }

  public T findMin() {
    if (isEmpty())
      return null;
    return theTrees[findMinIndex()].element;
  }


  public T deleteMin() {
    if (isEmpty())
      return null;
    int minIndex = findMinIndex();

    T minItem = theTrees[minIndex].element;
    Node<T> deletedTree = theTrees[minIndex].leftChild;
    theTrees[minIndex] = null;

    BinomialQueue<T> deletedQueue = new BinomialQueue<>();
    deletedQueue.expendTheTrees(minIndex + 1);
    deletedQueue.currentSize = (1 << minIndex) - 1;

    for (int j = minIndex - 1; j >= 0; j--) {
      deletedQueue.theTrees[j] = deletedTree;
      deletedTree = deletedTree.nextSibling;
      deletedQueue.theTrees[j].nextSibling = null;
    }
    currentSize -= deletedQueue.currentSize + 1;
    merge(deletedQueue);
    return minItem;

  }

}
