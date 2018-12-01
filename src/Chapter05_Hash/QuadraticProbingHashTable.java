package Chapter05_Hash;

import java.lang.reflect.Array;

public class QuadraticProbingHashTable<T extends QuadraticHashable>
    extends SeparateChainingHashTable {

  private static final Integer DEFAULT_TABLE_SIZE = 11;
  private T[] array;
  private Class<T> elementType;

  public QuadraticProbingHashTable(Class<T> elementType) {
    this(DEFAULT_TABLE_SIZE, elementType);
  }

  public QuadraticProbingHashTable(Integer size, Class<T> elementType) {
    allocateArray(size, elementType);
    makeEmpty();
    this.elementType = elementType;
  }

  private void allocateArray(int size, Class<T> elementType) {
    array = (T[]) Array.newInstance(elementType, nextPrime(size));
  }

  boolean contains(T x) {
    /**
     * is overload not override.
     */
    int currentPos = findPos(x);

    return isActive(currentPos);
  }

  boolean isActive(Integer currentPos) {
    /**
     * isActive means not null and T.isActive() collection has same method with element, for reason
     * of null case.
     */
    return array[currentPos] != null && array[currentPos].isActive();
  }

  public void insert(T x) {
    int currentPos = findPos(x);
    if (isActive(currentPos))
      return;
    array[currentPos] = x;
    if (++currentSize > array.length / 2) {
      reHash();
    }
  }

  public void remove(T x) {
    int currentPos = findPos(x);
    if (isActive(currentPos))
      array[currentPos].setActive(false);
  }


  private Integer findPos(T x) {
    Integer currentHashCode = myHash(x);
    Integer offset = 1;
    while (array[currentHashCode] != null && !array[currentHashCode].equals(x)) {
      currentHashCode += offset;
      offset += 2;
      currentHashCode = currentHashCode % array.length;
      if (currentHashCode < 0)
        currentHashCode += array.length;
    }
    return currentHashCode;

  }

  private int myHash(T x) {
    Integer originHashValue = x.hashCode();
    originHashValue %= array.length;
    if (originHashValue < 0) {
      originHashValue += array.length;
    }
    return originHashValue;
  }

  @Override
  public void makeEmpty() {
    for (Integer i = 0; i < array.length; i++) {
      array[i] = null;
    }
    currentSize = 0;
  }

  public Integer getHashTableSize() {
    return array.length;
  }

  private void reHash() {
    T[] oldArray = array;

    allocateArray(nextPrime(array.length * 2), elementType);
    currentSize = 0;

    for (int i = 0; i < oldArray.length; i++) {
      if (oldArray[i] != null && oldArray[i].isActive()) {
        /**
         * don't use isActive() of QuadraticProbingHashTable.
         */
        insert(oldArray[i]);
      }
    }

  }

  public void printHashTable() {
    for (int i = 0; i < array.length; i++) {
      System.out.println(String.format("[%d]:", i + 1));
      if (array[i] != null)
        System.out.println(array[i].toString());

    }
  }
}
