package Chapter07_Sort;

public class InsertionSort<T extends Comparable<? super T>> implements SortBase<T> {
  public void sort(T[] a) {
    int p;
    for (int i = 1; i < a.length; i++) {
      T tmp = a[i];
      for (p = i; p > 0; p--) {
        if (tmp.compareTo(a[p - 1]) < 0) {
          a[p] = a[p - 1];
        } else {
          break;
        }
      }
      a[p] = tmp;

    }

  }

}
