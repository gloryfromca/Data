package Chapter01_Java;

import org.junit.Assert;
import org.junit.Test;

public class PolymorphismTest {

  @Test
  public void polymorphism() {
    Father1 a1 = new Child1();
    Assert.assertEquals(true, a1.str == "Father1");
    Assert.assertEquals(true, ((Child1) a1).str == "Child2");
  }

  @Test
  public void overload() {
    A ab = new B();
    B b = new B();
    C c = new C();
    D d = new D();
    Assert.assertEquals(true, ab.show(b) == "B and A");
    Assert.assertEquals(true, ab.show(c) == "B and A");
    Assert.assertEquals(true, ab.show(d) == "A and D");

  }

}
