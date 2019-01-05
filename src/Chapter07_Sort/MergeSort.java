package Chapter07_Sort;

public class MergeSort<T extends Comparable<? super T>> implements SortBase<T> {
  @Override
  public void sort(T[] a) {
    T[] tmpArray = (T[]) new Comparable[a.length];
    mergeSort(a, tmpArray, 0, a.length - 1);
  }

  public void mergeSort(T[] a, T[] tmpArray, int left, int right) {
    if (left < right) {
      int center = (left + right) / 2;
      mergeSort(a, tmpArray, left, center);
      mergeSort(a, tmpArray, center + 1, right);
      merge(a, tmpArray, left, center, right);
    }
  }

  public void merge(T[] a, T[] tmpArray, int leftPos, int leftEnd, int rightEnd) {
    int rightPos = leftEnd + 1;
    int elementNums = rightEnd - leftPos + 1;
    int tmpPos = leftPos;
    while (leftPos <= leftEnd && rightPos <= rightEnd) {
      if (a[leftPos].compareTo(a[rightPos]) <= 0) {
        tmpArray[tmpPos++] = a[leftPos++];
      } else {
        tmpArray[tmpPos++] = a[rightPos++];
      }
    }
    while (leftPos <= leftEnd) {
      tmpArray[tmpPos++] = a[leftPos++];
    }
    while (rightPos <= rightEnd) {
      tmpArray[tmpPos++] = a[rightPos++];
    }

    for (int i = rightEnd; i > rightEnd - elementNums; i--) {
      a[i] = tmpArray[i];
    }

  }

}
