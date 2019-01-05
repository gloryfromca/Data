package Chapter07_Sort;

public class HeapSort<T extends Comparable<? super T>> implements SortBase<T> {


  @Override
  public void sort(T[] a) {
    for (int i = a.length / 2 - 1; i >= 0; i--) {
      percDown(a, i, a.length);
    }
    for (int i = a.length - 1; i > 0; i--) {
      swapReferences(a, 0, i);
      percDown(a, 0, i);
    }
  }

  public void swapReferences(T[] a, int index1, int index2) {
    T tmp = a[index1];
    a[index1] = a[index2];
    a[index2] = tmp;
  }

  public int leftChild(int i) {
    return 2 * i + 1;

  }

  public void percDown(T[] a, int i, int n) {
    T tmp;
    int child;

    for (tmp = a[i]; leftChild(i) < n; i = child) {
      // n is current size of heap.
      child = leftChild(i);
      if (child < n - 1 && a[child].compareTo(a[child + 1]) < 0) {
        child++;
      }
      if (tmp.compareTo(a[child]) < 0) {
        a[i] = a[child];
      } else {
        break;
      }
    }
    a[i] = tmp;

  }

}
