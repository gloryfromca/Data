package Chapter07_Sort;

public class ShellSort<T extends Comparable<? super T>> implements SortBase<T> {
  @Override
  public void sort(T[] a) {
    for (int gap = a.length / 2; gap > 0; gap /= 2) {
      for (int p = gap; p < a.length; p++) {
        T tmp = a[p];
        int j;
        for (j = p; j >= gap; j -= gap) {
          if (tmp.compareTo(a[j - gap]) < 0) {
            a[j] = a[j - gap];
          } else {
            break;
          }
        }
        a[j] = tmp;
      }
    }
  }
}
