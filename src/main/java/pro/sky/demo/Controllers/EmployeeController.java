package pro.sky.demo.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import pro.sky.demo.Employee;
import pro.sky.demo.Services.EmployeeService;
import pro.sky.demo.Exceptions.EmployeeAlreadyAddedException;
import pro.sky.demo.Exceptions.EmployeeNotFoundException;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<String> employeeAlreadyAddedExceptionHandler() {
        return ResponseEntity.badRequest().body("Сотрудник уже есть в базе данных");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        return ResponseEntity.badRequest().body("Параметры не должны быть пустыми, укажите " + ex.getParameterName());
    }

    @GetMapping
    public String welcome() {
        employeeService.dataBase();
        return "Добро пожаловать в базу данных сотрудников";
    }

    @GetMapping("/print")
    public Map<String, Employee> printEm() {
        return employeeService.printAll();
    }


    @GetMapping("/add")
    public String addEmployee(@RequestParam(value = "firstName") String firstName,
                              @RequestParam(value = "lastName") String lastName,
                              @RequestParam(value = "salary") int salary,
                              @RequestParam(value = "department") int department) {
        employeeService.addEmployee(firstName, lastName, salary, department);
        return String.format("Сотрудник %s %s успешно добавлен в базу данных", firstName, lastName);
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        try {
            employeeService.deleteEmployee(firstName, lastName);
            return String.format("Сотрудник %s %s успешно удалён из базы ", firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.toString();
        }
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam(value = "firstName") String firstName,
                                 @RequestParam(value = "lastName") String lastName) {
        employeeService.findEmployee(firstName, lastName);
        return new Employee(firstName, lastName);
    }
}







