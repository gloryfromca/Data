package Chapter04_Tree;

public class BinarySearchTree<T extends Comparable<? super T>> {
  private static class BinaryNode<T> {
    T val;
    BinaryNode<T> left;
    BinaryNode<T> right;

    public BinaryNode(T val) {
      /**
       * use `this` to call another constructor.
       */
      this(val, null, null);
    }

    public BinaryNode(T val, BinaryNode<T> left, BinaryNode<T> right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

  }

  private BinaryNode<T> root;

  public boolean contains(T val) {
    return contains(val, root);

  }

  public boolean contains(T val, BinaryNode<T> binaryNode) {
    if (binaryNode == null) {
      return false;
    }
    int compareResult = val.compareTo(binaryNode.val);
    if (compareResult > 0) {
      return contains(val, binaryNode.right);
    } else if (compareResult < 0) {
      return contains(val, binaryNode.left);
    }
    return true;
  }

  public BinarySearchTree() {
    /**
     * if BST is null, then root Node is null. Node must have val.
     */
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void makeEmpty() {
    root = null;
  }

  public void insert(T val) {
    root = insert(val, root);

  }

  public void remove(T val) {
    root = remove(val, root);

  }

  public T findMax() {
    if (isEmpty()) {
      return null;
    }
    return findMax(root).val;
  }

  public T findMin() {
    if (isEmpty()) {
      return null;
    }
    return findMin(root).val;
  }

  public BinaryNode<T> findMax(BinaryNode<T> binaryNode) {
    if (binaryNode == null) {
      return null;
    }
    while (binaryNode.right != null) {
      binaryNode = binaryNode.right;
    }
    return binaryNode;
  }

  public BinaryNode<T> findMin(BinaryNode<T> binaryNode) {
    if (binaryNode == null) {
      return null;
    } else if (binaryNode.left == null) {
      return binaryNode;
    } else {
      return findMin(binaryNode.left);
    }
  }

  public BinaryNode<T> insert(T val, BinaryNode<T> binaryNode) {
    /**
     * return new root of subtree.
     */
    if (binaryNode == null)
      return new BinaryNode<>(val);
    int compareResult = val.compareTo(binaryNode.val);
    if (compareResult > 0) {
      binaryNode.right = insert(val, binaryNode.right);
    } else if (compareResult < 0) {
      binaryNode.left = insert(val, binaryNode.left);
    }
    return binaryNode;
  }

  public BinaryNode<T> remove(T val, BinaryNode<T> binaryNode) {
    if (binaryNode == null) {
      /**
       * binaryNode means that parent node's left node or right node is null, nothing to do.
       */
      return null;
    }
    int compareResult = val.compareTo(binaryNode.val);
    if (compareResult > 0) {
      binaryNode.right = remove(val, binaryNode.right);
    } else if (compareResult < 0) {
      binaryNode.left = remove(val, binaryNode.left);
    } else {
      if (binaryNode.left != null && binaryNode.right != null) {
        binaryNode.val = findMin(binaryNode.right).val;
        binaryNode.right = remove(val, binaryNode.right);

      } else if (binaryNode.left != null) {
        return binaryNode.left;
      } else {
        return binaryNode.right;
      }

    }
    /**
     * compareResult != 0 need to return left node or right node.
     */
    return binaryNode;

  }



}
