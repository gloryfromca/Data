package Chapter06_Heap;

public class BinaryHeap<T extends Comparable<? super T>> {
  private int currentSize;
  private T[] array;

  private static final int DEFAULT_CAPACITY = 10;

  public BinaryHeap() {
    this(DEFAULT_CAPACITY);
  }

  public BinaryHeap(int capacity) {
    array = (T[]) new Comparable[capacity + 1];
  }

  public BinaryHeap(T[] items) {
    currentSize = items.length;
    array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];
    int i = 1;
    for (T x : items) {
      array[i++] = x;
    }
    buildHeap();
  }


  public void insert(T x) {
    if (currentSize == array.length - 1) {
      enlargeArray(array.length * 2 + 1);
    }
    int hole = ++currentSize;
    for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
      array[hole] = array[hole / 2];
    }
    array[hole] = x;
  }

  public T deleteMin() {
    if (isEmpty()) {
      return null;
    }
    T minItem = findMin();
    array[1] = array[currentSize--];
    percolateDown(1);
    return minItem;
  }

  public void percolateDown(int hole) {
    int child;
    T tmp = array[hole];
    for (; hole * 2 <= currentSize; hole = child) {
      child = hole * 2;
      if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) {
        child++;
      }
      if (array[child].compareTo(tmp) < 0) {
        array[hole] = array[child];
      } else {
        break;
      }
    }
    array[hole] = tmp;

  }

  public void buildHeap() {
    for (int i = currentSize / 2; i > 0; i--) {
      percolateDown(i);
    }

  }

  public T findMin() {
    return array[1];
  }

  public void enlargeArray(int length) {
    T[] new_array = (T[]) new Comparable[length];
    for (int i = 0; i < array.length; i++) {
      new_array[i] = array[i];
    }
    array = new_array;
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public void makeEmpty() {
    currentSize = 0;
    array = (T[]) new Comparable[DEFAULT_CAPACITY];
  }

  public int getCurrentSize() {
    return currentSize;
  }

  public int getArrayLength() {
    return array.length;
  }
}
