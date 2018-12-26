package Chapter06_Heap;

public class LeftistHeap<T extends Comparable<? super T>> {
  Node<T> root;

  private static class Node<T> {
    T element;
    Node<T> left;
    Node<T> right;
    int npl;

    public Node(T element) {
      this(element, null, null, 0);
    }

    public Node(T element, Node<T> right, Node<T> left, int npl) {
      this.element = element;
      this.left = left;
      this.right = right;
      this.npl = npl;
    }

  }

  public LeftistHeap() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void makeEmpty() {
    root = null;
  }

  public void insert(T element) {
    Node<T> newNode = new Node(element);
    root = merge(root, newNode);
  }

  public T findMin() {
    return root.element;
  }

  public void deleteMin() {
    root = merge(root.left, root.right);
  }

  public void merge(LeftistHeap<T> rhs) {
    if (this == rhs) {
      return;
    }
    root = merge(root, rhs.root);
    rhs.root = null;
  }

  public Node<T> merge(Node<T> h1, Node<T> h2) {
    if (h1 == null) {
      return h2;
    }
    if (h2 == null) {
      return h1;
    }
    if (h1.element.compareTo(h2.element) < 0) {
      return merge1(h1, h2);
    } else {
      return merge1(h2, h1);
    }

  }

  public Node<T> merge1(Node<T> h1, Node<T> h2) {

    if (h1.left == null) {
      h1.left = h2;
    } else {
      h1.right = merge(h1.right, h2);
      if (h1.right.npl > h1.left.npl) {
        swapChildren(h1);
      }
      h1.npl = h1.right.npl + 1;
    }
    return h1;

  }

  public void swapChildren(Node<T> h1) {
    Node<T> left_old = h1.left;
    h1.left = h1.right;
    h1.right = left_old;
  }


}
