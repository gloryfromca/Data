package Chapter12_AdvancedDataStructuresAndImplementation;

import java.util.Random;

public class TreapTree<T extends Comparable<? super T>> {
  private final static int MAX_PRIORITY = 10 * 5;
  private final static Random random = new Random();

  private static class TreapNode<T> {
    TreapNode<T> left;
    TreapNode<T> right;
    T element;
    int priority;

    TreapNode(T element, TreapNode<T> left, TreapNode<T> right) {
      this.element = element;
      this.left = left;
      this.right = right;
      this.priority = random.nextInt(MAX_PRIORITY - 1);
    }

    TreapNode(T element) {
      this(element, null, null);
    }
  }

  private TreapNode<T> nullNode;
  private TreapNode<T> root;

  public TreapTree() {
    nullNode = new TreapNode(null);
    nullNode.left = nullNode.right = nullNode;
    root = nullNode;
  }

  public boolean contains(T x) {
    if (x == null) {
      return false;
    }
    return contains(x, root);
  }

  private boolean contains(T x, TreapNode<T> t) {
    if (t == nullNode) {
      return false;
    }
    int compareResult = x.compareTo(t.element);
    if (compareResult < 0) {
      return contains(x, t.left);
    } else if (compareResult > 0) {
      return contains(x, t.right);
    } else {
      return true;
    }
  }

  public T findMax() {
    TreapNode<T> t = root;
    while (t.right != nullNode) {
      t = t.right;
    }
    return t.element;
  }

  public T findMin() {
    TreapNode<T> t = root;
    while (t.left != nullNode) {
      t = t.left;
    }
    return t.element;
  }

  public boolean isEmpty() {
    return root == nullNode;
  }

  public void makeEmpty() {
    root = nullNode;
  }


  public void insert(T x) {
    root = insert(x, root);
  }

  private TreapNode<T> insert(T x, TreapNode<T> t) {
    if (t == nullNode) {
      return new TreapNode<>(x, nullNode, nullNode);
    }

    int compareResult = x.compareTo(t.element);
    if (compareResult < 0) {

      t.left = insert(x, t.left);
      if (t.left.priority < t.priority) {
        t = rotateWithLeftChild(t);
      }

    } else if (compareResult > 0) {

      t.right = insert(x, t.right);
      if (t.right.priority < t.priority) {
        t = rotateWithRightChild(t);
      }

    }
    return t;
  }

  public void remove(T x) {
    root = remove(x, root);
  }

  private TreapNode<T> remove(T x, TreapNode<T> t) {
    if (t == nullNode) {
      return t;
    }
    int compareResult = x.compareTo(t.element);
    if (compareResult < 0) {
      t.left = remove(x, t.left);
    } else if (compareResult > 0) {
      t.right = remove(x, t.right);
    } else {
      if (t.left.priority < t.right.priority) {
        t = rotateWithLeftChild(t);
      } else {
        t = rotateWithRightChild(t);
      }
      if (t != nullNode) {
        t = remove(x, t);
      } else {
        t.left = nullNode;
      }
    }
    return t;
  }


  private TreapNode<T> rotateWithLeftChild(TreapNode<T> k2) {
    TreapNode<T> k1 = k2.left;
    k2.left = k1.right;
    k1.right = k2;
    return k1;
  }

  private TreapNode<T> rotateWithRightChild(TreapNode<T> k1) {
    TreapNode<T> k2 = k1.right;
    k1.right = k2.left;
    k2.left = k1;
    return k2;
  }



}
