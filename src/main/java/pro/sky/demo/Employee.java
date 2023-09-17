package pro.sky.demo;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int Salary;
    private int Department;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        Salary = salary;
        Department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Salary == employee.Salary && Department == employee.Department && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, Salary, Department);
    }

    public String getFullName(){return firstName+ " " + lastName;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getDepartment() {
        return Department;
    }

    public void setDepartment(int department) {
        Department = department;
    }
}


