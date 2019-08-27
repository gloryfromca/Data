package Chapter12_AdvancedDataStructuresAndImplementation;

import java.util.ArrayList;

public class KdTree<T extends Comparable<? super T>> {

  private static class KdNode<T> {
    public KdNode<T> left;
    public KdNode<T> right;
    T[] data;

    KdNode(T[] x) {
      this.data = x;
    }
  }

  private KdNode<T> root;

  public void insert(T[] x) {
    root = insert(x, root, 0);

  }

  private KdNode<T> insert(T[] x, KdNode<T> t, int level) {
    if (t == null) {
      return new KdNode<>(x);
    } else if (x[level].compareTo(t.data[level]) < 0) {
      t.left = insert(x, t.left, 1 - level);
    } else {
      t.right = insert(x, t.right, 1 - level);
    }
    return t;
  }

  public void findRange(T[] low, T[] high, ArrayList<T[]> result) {
    findRange(low, high, root, result, 0);
  }

  private void findRange(T[] low, T[] high, KdNode<T> t, ArrayList<T[]> result, int level) {
    if (t != null) {
      if (low[0].compareTo(t.data[0]) <= 0 && low[1].compareTo(t.data[1]) <= 0
          && high[0].compareTo(t.data[0]) >= 0 && high[1].compareTo(t.data[1]) >= 0) {
        result.add(t.data);
      }

      if (low[level].compareTo(t.data[level]) <= 0) {
        findRange(low, high, t.left, result, 1 - level);
      }
      if (high[level].compareTo(t.data[level]) >= 0) {
        findRange(low, high, t.right, result, 1 - level);
      }

    }

  }

}
