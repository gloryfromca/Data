package Chapter05_Hash;

import java.util.LinkedList;

public class SeparateChainingHashTable<T extends Hashable> {
  private static final Integer DEFAULT_TABLE_SIZE = 101;

  private LinkedList<T>[] theLinkedLists;
  private Integer currentSize = 0;

  public SeparateChainingHashTable() {
    this(DEFAULT_TABLE_SIZE);
  }

  public SeparateChainingHashTable(Integer size) {
    theLinkedLists = new LinkedList[size];
    for (int i = 0; i < theLinkedLists.length; i++) {
      theLinkedLists[i] = new LinkedList<>();
    }

  }

  public void insert(T x) {
    Integer hashCode = myHash(x);
    LinkedList<T> thelinkedList = theLinkedLists[hashCode];
    if (!thelinkedList.contains(x)) {
      thelinkedList.add(x);

      if (++currentSize > theLinkedLists.length) {
        reHash();
      }
    }

  }

  public void remove(T x) {
    Integer hashCode = myHash(x);
    LinkedList<T> thelinkedList = theLinkedLists[hashCode];
    if (thelinkedList.contains(x)) {
      thelinkedList.remove(x);
      currentSize--;
    }

  }

  public boolean contains(T x) {
    Integer hashCode = myHash(x);
    LinkedList<T> thelinkedList = theLinkedLists[hashCode];
    return thelinkedList.contains(x);
  }

  public void makeEmpty() {
    for (int i = 0; i < theLinkedLists.length; i++) {
      theLinkedLists[i].clear();
    }
    currentSize = 0;

  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public void printHashTable() {
    for (int i = 0; i < theLinkedLists.length; i++) {

      System.out.println(String.format("[%d]:", i + 1));
      String listString = "";

      for (T x : theLinkedLists[i]) {
        listString = listString + x.toString();
        listString += " ";
      }
      System.out.println(listString);

    }
  }

  private void reHash() {

  }

  private int myHash(T x) {
    Integer originHashValue = x.hashCode();
    originHashValue %= theLinkedLists.length;
    if (originHashValue < 0) {
      originHashValue += theLinkedLists.length;
    }
    return originHashValue;
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
