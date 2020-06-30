package zma.practice.sprinttest.mybatisTest.entity;

public class Employee {

  private String lastName;
  private String email;
  private String gender;

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Employee(String lastName, String email, String gender) {
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
  }

  public Employee() {
  }
}
