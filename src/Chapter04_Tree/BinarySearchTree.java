package Chapter04_Tree;

public class BinarySearchTree<T extends Comparable<? super T>> {
  public static class BinaryNode<T> {
    /**
     * public static inner class can be extended by the external class' subclass' inner class.
     */
    T val;
    BinaryNode<T> left;
    BinaryNode<T> right;
    Integer height;

    public BinaryNode(T val) {
      /**
       * use `this` to call another constructor.
       */
      this(val, 1);
    }

    public BinaryNode(T val, int height) {
      /**
       * use `this` to call another constructor.
       */
      this(val, null, null, height);
    }

    public BinaryNode(T val, BinaryNode<T> left, BinaryNode<T> right, int height) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.height = height;
    }

    public Integer getRightHeight() {
      if (right != null)
        return right.height;
      return 0;
    }

    public Integer getLeftHeight() {
      if (left != null)
        return left.height;
      return 0;
    }

    public void setHeight() {
      Integer childrenHeight = getLeftHeight();
      if (getRightHeight() > childrenHeight) {
        childrenHeight = getRightHeight();
      }
      this.height = childrenHeight + 1;

    }
  }

  /**
   * if attribute is private, subclass can have but can't access directly. subclass can only access
   * by getXXX() or setXXX().
   */
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
     * if BST is null, then root TreeNode is null. TreeNode must have val.
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
    } else if (binaryNode.left != null) {
      return findMin(binaryNode.left);
    } else {
      return binaryNode;
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

  public void printTree() {
    if (isEmpty()) {
      System.out.println("Empty Tree");
    }
    printTree(root);
  }

  public void printTree(BinaryNode<T> binaryNode) {
    if (binaryNode != null) {
      printTree(binaryNode.left);
      System.out.println(binaryNode.val);
      printTree(binaryNode.right);
    }
  }


}
