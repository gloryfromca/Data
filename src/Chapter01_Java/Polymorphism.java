package Chapter01_Java;

class Father1 {
  String str = "Father";

  public Father1() {
    this.str = "Father1";
    this.setstr();
  }

  public void setstr() {
    str = "Father2";
  }
}


class Child1 extends Father1 {

  String str;

  public Child1() {

  }

  public void setstr() {
    str = "Child2";
  }

}


class A {
  public String show(D obj) {
    return ("A and D");
  }

  public String show(A obj) {
    return ("A and A");
  }
}


class B extends A {
  public String show(A obj) {
    return ("B and A");
  }

  public String show(B obj) {
    return ("B and B");
  }
}


class C extends B {
}


class D extends B {
}


