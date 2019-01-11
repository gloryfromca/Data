package Chapter01_Java;

class Father<T> {
  T value;

  public Father(T x) {
    value = x;
  }

  @Override
  public String toString() {
    return "Father:" + value.toString();
  }

  public T getValue() {
    return value;
  }

}


class Son<T> extends Father<T> {

  public Son(T x) {
    super(x);
  }

  @Override
  public String toString() {
    return "Son:" + value.toString();
  }

  public T getValue() {
    return value;
  }

}



public class GenericDemo<T> {
  T[] a;
  Object[] objectA;
  T[] ints;

  public GenericDemo() {
    a = (T[]) new Object[10];

    objectA = a;
    Integer n = 100;
    objectA[0] = n;
    String s = "abc";
    objectA[1] = s;

    ints = (T[]) new Integer[100];
  }

  public T get(int index) {
    return a[index];
  }

}


