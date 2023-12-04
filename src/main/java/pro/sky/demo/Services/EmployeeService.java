package pro.sky.demo.Services;

import pro.sky.demo.Employee;

import java.util.Map;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName, int salary, int department);

    public Employee deleteEmployee(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);

    public Map<String, Employee> printAll();
    void dataBase();
}
