package Chapter05_Hash;

public interface Hashable {
  boolean equals(Object rhs);

  int hashCode();

  String toString();
}


class Employee implements Hashable {

  private String name;
  private Integer age;
  private Double salary;

  public Employee(String name) {
    this.name = name;
  }

  public Employee(String name, Integer age, Double salary) {
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Employee && name.equals(((Employee) obj).name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  @Override
  public String toString() {
    return String.format("name: %s age: %d salary: %f", name, age, salary);
  }
}
