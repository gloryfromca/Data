package Chapter12_AdvancedDataStructuresAndImplementation;

public class RedBlackTree<T extends Comparable<? super T>> {

  private static final int RED = 1;
  private static final int BLACK = 2;

  private static class RedBlackNode<T> {
    RedBlackNode<T> left;
    RedBlackNode<T> right;
    T element;
    int color;

    RedBlackNode(T element, RedBlackNode<T> left, RedBlackNode<T> right) {
      this.element = element;
      this.left = left;
      this.right = right;
      this.color = BLACK;
    }

    RedBlackNode(T element) {
      this(element, null, null);
    }

  }

  private RedBlackNode<T> nullNode;
  private RedBlackNode<T> header;

  RedBlackTree() {
    nullNode = new RedBlackNode<>(null);
    nullNode.left = nullNode.right = nullNode;
    header = new RedBlackNode<>(null);
    header.left = header.right = nullNode;
  }


  private int compare(T item, RedBlackNode<T> RedBlackNode) {
    if (RedBlackNode == header) {
      return 1;
    }
    return item.compareTo(RedBlackNode.element);
  }

  private RedBlackNode<T> current;
  private RedBlackNode<T> parent;
  private RedBlackNode<T> grand;
  private RedBlackNode<T> great;

  public void insert(T item) {
    current = parent = grand = header;
    nullNode.element = item;
    while (compare(item, current) != 0) {
      great = grand;
      grand = parent;
      parent = current;
      current = compare(item, current) < 0 ? current.left : current.right;
      if (current.left.color == RED && current.right.color == RED) {
        handleReorient(item);
      }
    }

    if (current != nullNode) {
      return;
    }
    current = new RedBlackNode<>(item, nullNode, nullNode);
    if (compare(item, parent) < 0) {
      parent.left = current;
    } else {
      parent.right = current;
    }
    handleReorient(item);

  }

  private void handleReorient(T item) {
    current.color = RED;
    current.left.color = BLACK;
    current.right.color = BLACK;
    if (parent.color == RED) {

      grand.color = RED;
      if ((compare(item, grand) < 0) != (compare(item, parent) < 0))
        parent = rotate(item, grand);
      current = rotate(item, great);
      current.color = BLACK;
    }
    header.right.color = BLACK;

  }

  private RedBlackNode<T> rotate(T item, RedBlackNode<T> parent) {
    if (compare(item, parent) < 0)
      return parent.left = compare(item, parent.left) < 0 ? rotateWithLeftChild(parent.left) : // LL
          rotateWithRightChild(parent.left); // LR
    else
      return parent.right = compare(item, parent.right) < 0 ? rotateWithLeftChild(parent.right) : // RL
          rotateWithRightChild(parent.right); // RR
  }

  private RedBlackNode<T> rotateWithLeftChild(RedBlackNode<T> k2) {
    RedBlackNode<T> k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;
    return k1;
  }

  private RedBlackNode<T> rotateWithRightChild(RedBlackNode<T> k1) {
    RedBlackNode<T> k2 = k1.right;
    k1.right = k2.left;
    k2.left = k1;
    return k2;
  }

  public void remove(T x) {
    throw new UnsupportedOperationException();
  }

  public T findMin() {
    if (isEmpty())
      return null;

    RedBlackNode<T> itr = header.right;

    while (itr.left != nullNode)
      itr = itr.left;

    return itr.element;
  }

  public T findMax() {
    if (isEmpty())
      return null;

    RedBlackNode<T> itr = header.right;

    while (itr.right != nullNode)
      itr = itr.right;

    return itr.element;
  }

  public boolean contains(T x) {
    nullNode.element = x;
    current = header.right;

    for (;;) {
      if (x.compareTo(current.element) < 0)
        current = current.left;
      else if (x.compareTo(current.element) > 0)
        current = current.right;
      else if (current != nullNode)
        return true;
      else
        return false;
    }
  }

  public void makeEmpty() {
    header.right = nullNode;
  }

  public boolean isEmpty() {
    return header.right == nullNode;
  }

}
