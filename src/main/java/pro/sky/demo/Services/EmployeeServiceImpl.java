package pro.sky.demo.Services;

import org.springframework.stereotype.Service;
import pro.sky.demo.Employee;
import pro.sky.demo.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.demo.Exceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private final ValidationService validationService;

    public EmployeeServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    public void dataBase(){
        employees.put("Hannah Montana", new Employee("Hannah","Montana",123000, 2));
        employees.put("Hannah Murray",  new Employee("Hannah", "Murray",134000, 4));

    }
public Map<String, Employee> printAll(){
    return employees;
}

    public Employee addEmployee(String firstName, String lastName,int salary, int department) {
        Employee employee = new Employee(validationService.validatedName(firstName), validationService.validatedSurname(lastName),salary,department);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        } else {
        employees.put(employee.getFullName(), employee);
        return employee;}
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.containsKey(employee.getFullName())){
        return employees.remove(employee.getFullName());
           }
        else {throw new EmployeeNotFoundException(/*"Сотрудника не существует в базе данных"*/) ;}

    }

    public Employee findEmployee(String firstName, String lastName) {

        String key = firstName+ " "+lastName;
        if(employees.containsKey(key)){
        return employees.get(key);}
        else{throw new EmployeeNotFoundException(/*"Сотрудника не существует в базе данных"*/);
        }
    }
    public List<Employee> getAll(){
        return new ArrayList<>(employees.values());
    }
}
