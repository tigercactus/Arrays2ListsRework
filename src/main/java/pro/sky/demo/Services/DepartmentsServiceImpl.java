package pro.sky.demo.Services;

import org.springframework.stereotype.Service;
import pro.sky.demo.Employee;
import pro.sky.demo.Exceptions.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Service

public class DepartmentsServiceImpl implements DepartmentsService{
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentsServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee maxSalaryOfDepartment(int department) {
        return employeeServiceImpl
                .getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary)).orElseThrow(RuntimeException::new);
    }

    @Override
    public Employee minSalaryOfDepartment(int department) {
        return employeeServiceImpl.getAll()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary)).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Employee> allEmployeesOfDepartment(int department) {
        return employeeServiceImpl.getAll()
                .stream()
                .filter(employee -> employee.getDepartment()==department)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee>  allEmployeesSortedByDepartments( ) {
        return employeeServiceImpl.getAll()
                .stream()
                .sorted((e1,e2)-> e1.getDepartment() - e2.getDepartment())
                .collect(Collectors.toList());
    }
}
