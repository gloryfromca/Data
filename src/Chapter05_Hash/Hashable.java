package Chapter05_Hash;

public interface Hashable {
  boolean equals(Object rhs);

  int hashCode();

  String toString();
}


interface QuadraticHashable extends Hashable {
  boolean isActive();

  void setActive(Boolean isActive);
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


class QuadraticEmployee extends Employee implements QuadraticHashable {
  private boolean active = true;

  public QuadraticEmployee(String name) {
    super(name);

  }

  public QuadraticEmployee(String name, Integer age, Double salary) {
    super(name, age, salary);
  }

  @Override
  public boolean isActive() {
    return active;
  }

  @Override
  public void setActive(Boolean isActive) {
    active = isActive;
  }

  public String toString() {
    return String.format("%s isActive: %b", super.toString(), isActive());
  }
}
