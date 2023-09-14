package pro.sky.demo;

import java.util.Map;

public interface EmployeeService {
    public Employee addEmployee(String firstName, String lastName);

    public Employee deleteEmployee(String firstName, String lastName);
    public Employee findEmployee(String firstName, String lastName);

    public Map<String, Employee> printAll();
    boolean dataBase();
}
