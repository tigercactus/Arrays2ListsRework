package pro.sky.demo.Services;

import pro.sky.demo.Employee;

import java.util.List;

public interface DepartmentsService {
    Employee maxSalaryOfDepartment(int department);

    Employee minSalaryOfDepartment(int department );
    List<Employee> allEmployeesOfDepartment(int department);
    List<Employee>  allEmployeesSortedByDepartments();
}
