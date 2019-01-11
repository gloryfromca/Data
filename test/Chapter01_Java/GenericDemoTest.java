package Chapter01_Java;

import org.junit.Assert;
import org.junit.Test;

public class GenericDemoTest {

  @Test
  public void covarianceAndContravariance() {
    String[] strArray = new String[20];
    Object[] objArray = strArray;

    try {
      Integer[] nums = (Integer[]) new Object[10];
    } catch (ClassCastException e) {
      System.out.println("downcasting is always allowed in grammar.");
    }

    Son[] sons = new Son[10];
    Father[] fathers = sons;
    // fathers is actually a `son[]`, so downcasting to son [] is ok.
    Son[] sons2 = (Son[]) fathers;

    fathers = new Father[10];
    try {
      sons = (Son[]) fathers;
    } catch (ClassCastException e) {
      System.out
          .println("Covariance is supported by Java, Contravariance is not supported by Java");
    }

  }

  @Test
  public void GenericArray() {
    Father<Integer>[] fathers = (Father<Integer>[]) new Father[100];
    fathers[0] = new Father<Integer>(100);

    Father[] objectFathers = fathers;
    Father<String>[] anotherFathers = (Father<String>[]) objectFathers;
    anotherFathers[1] = new Father<String>("abc");

    Assert.assertEquals(true, fathers.equals(anotherFathers));
    Assert.assertEquals(true, fathers[0].getValue() instanceof Integer);
    Assert.assertEquals(true, (Object) fathers[1].getValue() instanceof String);
    Assert.assertEquals(true, fathers[0].getValue() == 100);
    Assert.assertEquals(true, anotherFathers[1].getValue().compareTo("abc") == 0);

  }

  @Test
  public void GenericDemo1() {
    GenericDemo<Integer> genericDemo;
    genericDemo = new GenericDemo<>();
    Assert.assertEquals(true, genericDemo.a == genericDemo.objectA);

    Integer n = genericDemo.get(0);
    Assert.assertEquals(true, n == 100);

    Object string = genericDemo.get(1);
    Assert.assertEquals(true, string instanceof String);
    String literal = "abc";
    Assert.assertEquals(true, (string).equals(literal));
  }

  @Test
  public void GenericDemo2() {
    GenericDemo<Integer> genericDemo;
    genericDemo = new GenericDemo<>();

    Object[] objects = genericDemo.a;
    try {
      Integer[] nums = genericDemo.a;
    } catch (ClassCastException e) {
      System.out.println("a is actually Object[]");
    }
    Integer[] nums = genericDemo.ints;
    System.out.println("ints is actually Integer[]");


    Object numObject;
    Object stringObject;
    numObject = objects[0];
    try {
      numObject = genericDemo.a[0];
    } catch (ClassCastException e) {
      System.out.println("a is actually Object[], but a's ref is T[] (in this case Integer [])");
    }
    try {
      stringObject = genericDemo.a[1];
    } catch (ClassCastException e) {
      System.out.println(
          "Object[] can't downcast to Integer[], And getting element by index is after downcasting.");
    }

  }

}
