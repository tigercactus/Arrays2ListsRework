package pro.sky.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

    public boolean dataBase(){
        employees.add(new Employee("Hannah","Montana"));
        employees.add(new Employee("Hannah", "Murray"));
return true;
    }
public List<Employee> printAll(){
    return employees;
}

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        } else {
        employees.add(employee);
        return employee;}
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)){
        employees.remove(employee);
            return employee;}
        else {throw new EmployeeNotFoundException("Сотрудника не существует в базе данных") ;}

    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if(employees.contains(employee)){
        return employee;}
        else{throw new EmployeeNotFoundException("Сотрудника не существует в базе данных");
        }
    }
}
