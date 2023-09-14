package pro.sky.demo;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   Map<String, Employee> employees = new HashMap<>();

    public boolean dataBase(){
        employees.put("Hannah Montana", new Employee("Hannah","Montana"));
        employees.put("Hannah Murray", new Employee("Hannah", "Murray"));
return true;
    }
public Map<String, Employee> printAll(){
    return employees;
}

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        } else {
        employees.put(employee.getFullName(), employee);
        return employee;}
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())){
        employees.remove(employee.getFullName());
            return employee;}
        else {throw new EmployeeNotFoundException("Сотрудника не существует в базе данных") ;}

    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employees.containsKey(employee.getFullName())){
        return employee;}
        else{throw new EmployeeNotFoundException("Сотрудника не существует в базе данных");
        }
    }
}
