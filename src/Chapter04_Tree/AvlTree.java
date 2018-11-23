package Chapter04_Tree;

public class AvlTree<T extends Comparable<? super T>> extends BinarySearchTree<T> {
  /**
   * `T extends Comparable<? super T>` defines AvlTree generic's restriction, and it meets the
   * demand of extending super class.
   */
  public static class AvlNode<T> extends BinarySearchTree.BinaryNode<T> {
    AvlNode<T> left;
    AvlNode<T> right;

    public AvlNode(T val, int height) {
      this(val, null, null, height);
    }

    public AvlNode(T val, AvlNode<T> left, AvlNode<T> right, int height) {
      /**
       * if super class don't have constructor without vars, you must call super() explicitly.
       */
      super(val, left, right, height);
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

  }

  private AvlNode<T> root;

  public AvlNode<T> rotate(AvlNode<T> avlNode) {
    if (avlNode == null) {
      return null;
    }

    int leftHeight = avlNode.getLeftHeight();
    int rightHeight = avlNode.getRightHeight();
    AvlNode<T> centerNode = avlNode;
    AvlNode<T> badSon;
    if (rightHeight - leftHeight > 1) {
      badSon = avlNode.right;
      if (badSon.getLeftHeight() - badSon.getRightHeight() > 0) {
        centerNode = badSon.left;

        badSon.left = centerNode.right;
        centerNode.right = badSon;
        avlNode.right = centerNode.left;
        centerNode.left = avlNode;

        centerNode.left.setHeight();
        centerNode.right.setHeight();
      } else {
        centerNode = avlNode.right;

        avlNode.right = centerNode.left;
        centerNode.left = avlNode;
      }

    } else if (leftHeight - rightHeight > 1) {
      badSon = avlNode.left;
      if (badSon.getLeftHeight() - badSon.getRightHeight() < 0) {
        centerNode = badSon.right;

        badSon.right = centerNode.left;
        centerNode.left = badSon;
        avlNode.left = centerNode.right;
        centerNode.right = avlNode;

        centerNode.left.setHeight();
        centerNode.right.setHeight();
      } else {
        centerNode = avlNode.left;

        avlNode.left = centerNode.right;
        /**
         * you must be very careful to code these data structure modification logic, or you will
         * encounter very strange bug which has unstable behavior.
         */
        centerNode.right = avlNode;
      }

    }
    centerNode.setHeight();

    return centerNode;
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

  public BinaryNode<T> findMax(AvlNode<T> avlNode) {
    if (avlNode == null) {
      return null;
    }
    while (avlNode.right != null) {
      avlNode = avlNode.right;
    }
    return avlNode;
  }

  public AvlNode<T> findMin(AvlNode<T> avlNode) {
    if (avlNode == null) {
      return null;
    } else if (avlNode.left == null) {
      return avlNode;
    } else {
      return findMin(avlNode.left);
    }
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


  public AvlNode<T> insert(T val, AvlNode<T> avlNode) {
    if (avlNode == null) {
      return new AvlNode<>(val, 1);
    }
    int compareResult = avlNode.val.compareTo(val);
    if (compareResult > 0) {
      avlNode.left = insert(val, avlNode.left);
    } else if (compareResult < 0) {
      avlNode.right = insert(val, avlNode.right);
    }
    return rotate(avlNode);
  }

  public AvlNode<T> remove(T val, AvlNode<T> avlNode) {
    if (avlNode == null) {
      return null;
    }

    AvlNode<T> centerNode = avlNode;
    int compareResult = val.compareTo(avlNode.val);
    if (compareResult > 0) {
      avlNode.right = remove(val, avlNode.right);
    } else if (compareResult < 0) {
      avlNode.left = remove(val, avlNode.left);
    } else {
      if (avlNode.left != null && avlNode.right != null) {
        AvlNode<T> right = findMin(avlNode.right);
        avlNode.val = right.val;
        avlNode.right = remove(val, avlNode.right);

      } else if (avlNode.left != null) {

        centerNode = avlNode.left;
      } else {
        centerNode = avlNode.right;
      }

    }
    return rotate(centerNode);

  }

  public boolean contains(T val) {
    return contains(val, root);
  }

  public boolean contains(T val, AvlNode<T> avlNode) {
    if (avlNode == null) {
      return false;
    }
    int compareResult = val.compareTo(avlNode.val);
    if (compareResult > 0) {
      return contains(val, avlNode.right);
    } else if (compareResult < 0) {
      return contains(val, avlNode.left);
    }
    return true;
  }

  public Boolean checkBalance() {
    return checkBalance(root);
  }

  public Boolean checkBalance(AvlNode<T> root) {
    if (root == null) {
      return true;
    }
    Integer leftHeight = root.getLeftHeight();
    Integer rightHeight = root.getRightHeight();

    if (Math.abs(leftHeight - rightHeight) <= 1) {
      return checkBalance(root.left) && checkBalance(root.right);
    }
    return false;
  }

}
