package Chapter05_Hash;

import java.util.Random;

public class CuckooHashTable<T> {
  private final Random random = new Random();
  private final HashFamily<? super T> hashFamily;
  private final static int DEFAULT_TABLE_SIZE = 101;
  private final double MAX_LOAD = 0.4;
  private final int ALLOWED_REHASHES = 1;
  private int rehashes = 0;
  private int currentSize;
  private T[] array;


  public CuckooHashTable(HashFamily<? super T> hashFamily) {
    this(hashFamily, DEFAULT_TABLE_SIZE);
  }

  CuckooHashTable(HashFamily<? super T> hashFamily, int size) {
    this.hashFamily = hashFamily;
    allocateArray(size);
  }

  private void allocateArray(int size) {
    array = (T[]) new Object[nextPrime(size)];
  }

  public boolean insert(T x) {
    if (contains(x)) {
      return false;
    }
    if (currentSize >= array.length * MAX_LOAD) {
      expand();
    }
    return insertHelper(x);

  }

  private boolean insertHelper(T x) {
    final int COUNT_LIMIT = 100;
    while (true) {
      int lastPos = -1;
      for (int i = 0; i < COUNT_LIMIT; i++) {
        for (int which = 0; which < hashFamily.getNumberOfFunctions(); which++) {
          int hashVal = myHash(x, which);
          if (array[hashVal] == null) {
            array[hashVal] = x;
            currentSize++;
            return true;
          }
        }

        int pos;
        int getPosCount = 0;
        do {
          pos = myHash(x, random.nextInt(hashFamily.getNumberOfFunctions()));
        } while (pos == lastPos && getPosCount++ < 5);
        lastPos = pos;
        T tmp = array[pos];
        array[pos] = x;
        x = tmp;
      }
      if (++rehashes > ALLOWED_REHASHES) {
        expand();
        rehashes = 0;
      } else {
        reHash();
      }
    }

  }

  public boolean remove(T x) {

    int pos = findPos(x);
    if (pos != -1) {
      array[pos] = null;
      currentSize--;
    }
    return pos != -1;
  }

  public boolean contains(T x) {
    int pos = findPos(x);
    return pos != -1;
  }

  private int myHash(T x, int which) {
    int hashVal = hashFamily.hash(x, which);
    hashVal = hashVal % array.length;
    if (hashVal < 0) {
      hashVal += array.length;
    }
    return hashVal;
  }

  private void expand() {
    reHash((int) (array.length / MAX_LOAD));
  }

  private void reHash() {
    hashFamily.generateNewFunctions();
    reHash(array.length);
  }

  private void reHash(int size) {
    T[] oldArray = array;
    allocateArray(nextPrime(size));
    currentSize = 0;

    for (T x : oldArray) {
      if (x != null)
        insert(x);
    }

  }


  public int findPos(T x) {
    for (int i = 0; i < hashFamily.getNumberOfFunctions(); i++) {
      int hashVal = myHash(x, i);
      if (array[hashVal] != null && array[hashVal].equals(x)) {
        return hashVal;
      }
    }
    return -1;
  }

  public T get(T x) {
    int index = findPos(x);
    if (index < 0)
      return null;
    return array[index];
  }

  public T[] getArray() {
    return array;
  }

  public boolean isEmpty() {
    for (T x : array) {
      if (x != null) {
        return false;
      }
    }
    return true;
  }

  public void makeEmpty() {
    doClear();
  }

  public T getElementOfArray(Integer index) {
    if (index >= 0 && index < array.length) {
      return array[index];
    }
    return null;
  }

  public void printHashTable() {
    for (int i = 0; i < array.length; i++) {
      System.out.println(String.format("[%d]:", i + 1));
      if (array[i] != null)
        System.out.println(array[i].toString());
    }

  }

  public int getCurrentSize() {
    return currentSize;
  }

  public int[] getMULTIPLIERS() {
    return hashFamily.getMULTIPLIERS();

  }

  public Integer getArrayLength() {
    return array.length;
  }

  public void doClear() {
    currentSize = 0;
    for (int i = 0; i < array.length; i++) {
      array[i] = null;
    }
  }


  public static Boolean isPrime(int n) {
    if (n == 2 || n == 3)
      return true;

    if (n == 1 || n % 2 == 0)
      return false;

    for (int i = 3; i * i <= n; i += 2)
      if (n % i == 0)
        return false;

    return true;
  }

  public static int nextPrime(int n) {
    if (n % 2 == 0)
      n++;

    for (; !isPrime(n); n += 2);

    return n;
  }



}
