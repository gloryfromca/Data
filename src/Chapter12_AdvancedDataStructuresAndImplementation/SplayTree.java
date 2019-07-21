package Chapter12_AdvancedDataStructuresAndImplementation;

public class SplayTree<T extends Comparable<? super T>> {
  private static class BinaryNode<T> {
    BinaryNode<T> left;
    BinaryNode<T> right;
    T element;

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
      this.element = element;
      this.left = left;
      this.right = right;
    }

    public BinaryNode(T element) {
      this(element, null, null);
    }

  }

  private BinaryNode<T> root;
  private BinaryNode<T> header = new BinaryNode<>(null);
  private BinaryNode<T> nullNode = new BinaryNode<>(null);

  public SplayTree() {
    nullNode.left = nullNode.right = nullNode;
    root = nullNode;

  }


  private BinaryNode<T> splay(T x, BinaryNode<T> t) {
    BinaryNode<T> leftTreeMax, rightTreeMin;
    header.left = header.right = nullNode;
    leftTreeMax = rightTreeMin = header;

    for (;;)
      if (x.compareTo(t.element) < 0) {
        if (t.left != nullNode && x.compareTo(t.left.element) < 0) {
          t = rotateWithLeftChild(t);
        }
        if (t.left == nullNode) {
          break;
        }
        rightTreeMin.left = t;
        rightTreeMin = t;
        t = t.left;
      } else if (x.compareTo(t.element) > 0) {
        if (t.right != nullNode && x.compareTo(t.right.element) > 0) {
          t = rotateWithRightChild(t);
        }
        if (t.right == nullNode) {
          break;
        }
        leftTreeMax.right = t;
        leftTreeMax = t;
        t = t.right;

      } else {

        break;
      }

    leftTreeMax.right = t.left;
    rightTreeMin.left = t.right;
    t.right = header.left;
    t.left = header.right;

    return t;
  }


  private static <T> BinaryNode<T> rotateWithLeftChild(BinaryNode<T> k2) {
    BinaryNode<T> k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;
    return k1;
  }

  private static <T> BinaryNode<T> rotateWithRightChild(BinaryNode<T> k1) {
    BinaryNode<T> k2 = k1.right;
    k1.right = k2.left;
    k2.left = k1;
    return k2;
  }

  public void insert(T x) {
    BinaryNode<T> newNode = new BinaryNode<>(x);

    if (root == nullNode) {
      newNode.left = newNode.right = nullNode;
      root = newNode;
    } else {
      root = splay(x, root);
      if (x.compareTo(root.element) > 0) {
        newNode.right = root.right;
        newNode.left = root;
        root.right = nullNode;
        root = newNode;
      } else if (x.compareTo(root.element) < 0) {
        newNode.left = root.left;
        newNode.right = root;
        root.left = nullNode;
        root = newNode;
      } else {
        return;
      }
    }
  }

  public void remove(T x) {
    if (!contains(x)) {
      return;
    }
    BinaryNode<T> newTree;
    if (root.left == nullNode) {
      newTree = root.right;
    } else {
      newTree = root.left;
      newTree = splay(x, newTree);
      newTree.right = root.right;
    }
    root = newTree;

  }

  public boolean contains(T x) {
    if (isEmpty())
      return false;

    root = splay(x, root);

    return root.element.compareTo(x) == 0;
  }

  public T findMin() {
    if (isEmpty())
      return null;

    BinaryNode<T> ptr = root;

    while (ptr.left != nullNode)
      ptr = ptr.left;

    root = splay(ptr.element, root);
    return ptr.element;
  }

  public T findMax() {
    if (isEmpty())
      return null;

    BinaryNode<T> ptr = root;

    while (ptr.right != nullNode)
      ptr = ptr.right;

    root = splay(ptr.element, root);
    return ptr.element;
  }


  public void makeEmpty() {
    root = nullNode;
  }

  public boolean isEmpty() {
    return root == nullNode;
  }
}
