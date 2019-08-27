package Chapter12_AdvancedDataStructuresAndImplementation;


public class PairingHeap<T extends Comparable<? super T>> {

  public interface Position<T> {
    T getValue();
  }

  private static class PairNode<T> implements Position<T> {
    public T element;
    public PairNode<T> leftChild;
    public PairNode<T> nextSibling;
    public PairNode<T> prev;

    PairNode(T element) {
      this.element = element;
      leftChild = nextSibling = prev = null;
    }

    public T getValue() {
      return element;
    }

  }

  private PairNode<T> root;
  private int size;
  private PairNode<T>[] treeArray = new PairNode[5];

  private PairNode<T> compareAndLink(PairNode<T> first, PairNode<T> second) {
    if (second == null) {
      return first;
    }

    if (second.element.compareTo(first.element) < 0) {
      second.prev = first.prev;
      first.prev = second;
      first.nextSibling = second.leftChild;
      if (first.nextSibling != null) {
        first.nextSibling.prev = first;
      }
      second.leftChild = first;
      return second;
    } else {
      second.prev = first;
      first.nextSibling = second.nextSibling;
      if (first.nextSibling != null) {
        first.nextSibling.prev = first;
      }
      second.nextSibling = first.leftChild;
      if (second.nextSibling != null) {
        second.nextSibling.prev = second;
      }
      first.leftChild = second;
      return first;
    }
  }

  public Position<T> insert(T x) {
    PairNode<T> node = new PairNode<>(x);
    if (root == null) {
      root = node;
    } else {
      root = compareAndLink(root, node);
    }
    this.size++;
    return node;
  }

  public void decreaseKey(Position<T> pos, T newVal) {
    PairNode<T> p = (PairNode<T>) pos;
    if (p == null || p.element == null || p.element.compareTo(newVal) < 0) {
      throw new IllegalArgumentException();
    }
    p.element = newVal;
    if (p != root) {
      if (p.nextSibling != null) {
        p.nextSibling.prev = p.prev;
      }
      if (p.prev.leftChild == p) {
        p.prev.leftChild = p.leftChild;
      } else {
        p.prev.nextSibling = p.nextSibling;
      }
      p.nextSibling = null;
      root = compareAndLink(root, p);
    }
  }

  public T deleteMin() {
    if (isEmpty())
      throw new UnderflowException();

    T x = findMin();
    root.element = null; // null it out in case used in decreaseKey
    if (root.leftChild == null)
      root = null;
    else
      root = combineSiblings(root.leftChild);

    size--;
    return x;
  }

  public T findMin() {
    if (isEmpty())
      throw new UnderflowException();
    return root.element;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void makeEmpty() {
    root = null;
    size = 0;
  }


  private PairNode<T> combineSiblings(PairNode<T> firstSibling) {
    if (firstSibling.nextSibling == null) {
      return firstSibling;
    }
    int numSiblings = 0;
    for (; firstSibling != null; numSiblings++) {
      treeArray = doubleIfFull(treeArray, numSiblings);
      treeArray[numSiblings] = firstSibling;
      firstSibling.prev.nextSibling = null;
      firstSibling = firstSibling.nextSibling;
    }
    treeArray = doubleIfFull(treeArray, numSiblings);
    treeArray[numSiblings] = null;

    int i = 0;
    for (; i + 1 < numSiblings; i += 2) {
      treeArray[i] = compareAndLink(treeArray[i], treeArray[i + 1]);
    }
    int j = i - 2;
    if (j == numSiblings - 3) {
      treeArray[j] = compareAndLink(treeArray[j], treeArray[j + 2]);
    }

    for (; j >= 2; j -= 2) {
      treeArray[j - 2] = compareAndLink(treeArray[j - 2], treeArray[j]);

    }
    return treeArray[0];
  }

  private PairNode<T>[] doubleIfFull(PairNode[] array, int index) {
    if (index == array.length) {
      PairNode<T>[] oldArray = array;
      array = new PairNode[index * 2];
      for (int i = 0; i < index; i++) {
        array[i] = oldArray[i];
      }
    }
    return array;
  }

}
