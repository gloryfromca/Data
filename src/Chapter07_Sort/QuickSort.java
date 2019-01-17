package Chapter07_Sort;

public class QuickSort<T extends Comparable<? super T>> implements SortBase<T> {

  private final static int CUTOFF = 10;

  @Override
  public void sort(T[] a) {

    sort(a, 0, a.length - 1);

  }

  private void sort(T[] a, int left, int right) {
    if (left + CUTOFF <= right) {
      T pivot = median3(a, left, right);
      int i = left;
      int j = right - 1;
      for (;;) {
        while (a[++i].compareTo(pivot) < 0) {
        } ;
        while (a[--j].compareTo(pivot) > 0) {
        } ;
        if (i < j) {
          swapReferences(a, i, j);
        } else {
          break;
        }
      }
      swapReferences(a, i, right - 1);
      sort(a, left, i - 1);
      sort(a, i + 1, right);

    } else {

      InsertionSort insertionSort = new InsertionSort();
      insertionSort.sort(a, left, right);
    }

  }

  public static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
    int center = (left + right) / 2;
    if (a[left].compareTo(a[right]) > 0) {
      swapReferences(a, left, right);
    }
    if (a[left].compareTo(a[center]) > 0) {
      swapReferences(a, left, center);
    }
    if (a[center].compareTo(a[right]) > 0) {
      swapReferences(a, center, right);
    }
    swapReferences(a, center, right - 1);
    return a[right - 1];
  }

  public static <T extends Comparable<? super T>> void swapReferences(T[] a, int i, int j) {
    T tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
