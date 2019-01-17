package Chapter07_Sort;

public class QuickSelect<T extends Comparable<? super T>> {

  private final static int CUTOFF = 10;

  public void select(T[] a, int left, int right, int k) {
    if (left + CUTOFF <= right) {
      T pivot = QuickSort.median3(a, left, right);
      int i = left;
      int j = right - 1;
      for (;;) {
        while (a[++i].compareTo(pivot) < 0) {
        }
        while (a[--j].compareTo(pivot) > 0) {
        }
        if (i < j) {
          QuickSort.swapReferences(a, i, j);
        } else {
          break;
        }
      }
      QuickSort.swapReferences(a, i, right - 1);
      if (k <= i)
        select(a, left, i - 1, k);
      else if (k > i + 1)
        select(a, i + 1, right, k);

    } else {
      InsertionSort insertionSort = new InsertionSort();
      insertionSort.sort(a, left, right);
    }

  }

}
