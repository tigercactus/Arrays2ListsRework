package pro.sky.demo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import pro.sky.demo.Employee;
import pro.sky.demo.Services.DepartmentsService;

import java.util.List;

@RestController

@RequestMapping("/departments")
public class DepartmentsController {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        return ResponseEntity.badRequest().body(" Параметры не должны быть пустыми, укажите "  + ex.getParameterName());
    }

    private final DepartmentsService departmentsService;

    public DepartmentsController(DepartmentsService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalaryOfDepartment(@RequestParam(value = "department") int department) {
        Employee max = departmentsService.maxSalaryOfDepartment(department);
        return max;

    }

    @GetMapping("/min-salary")

    public Employee minSalaryOfDepartment(@RequestParam(value = "department") int department) {
        Employee min = departmentsService.minSalaryOfDepartment(department);
        return min;
    }

    @GetMapping("/all/department")
    public List<Employee> allEmployeesOfDepartment(@RequestParam(value = "department") int department) {
        return departmentsService.allEmployeesOfDepartment(department);
    }

    @GetMapping("/all")
    public List<Employee> allEmployeesSortedByDepartments() {
        return departmentsService.allEmployeesSortedByDepartments();
    }
}
