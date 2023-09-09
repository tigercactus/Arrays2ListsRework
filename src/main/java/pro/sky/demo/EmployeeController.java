package pro.sky.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String welcome() {
        employeeService.dataBase();
        return "Добро пожаловать в базу данных сотрудников";
    }
@GetMapping("/print")
public List<Employee> printEm(){
        return employeeService.printAll();
}
    @GetMapping("/add")
    public String addEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                              @RequestParam(value = "lastName", required = false) String lastName) {
        if (firstName == null || lastName == null || firstName == "" || lastName == "") {
            return "Параметры не должны быть пустыми, укажите имя и фамилию";
        } else {
            try {
                employeeService.addEmployee(firstName, lastName);
                return String.format("Сотрудник %s %s успешно добавлен в базу данных", firstName, lastName);
            } catch (EmployeeAlreadyAddedException e) {
                return "Сотрудник уже есть в базе данных";
            }
        }
    }
@GetMapping("/delete")
    public String deleteEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                                 @RequestParam(value = "lastName",required = false) String lastName ){
        if (firstName == null || lastName == null || firstName =="" || lastName == ""){
            return "Параметры не должны быть пустыми, укажите имя и фамилию";}
        else {
            try{employeeService.deleteEmployee(firstName,lastName);
                return String.format("Сотрудник %s %s успешно удалён из базы",firstName,lastName);}
            catch (EmployeeNotFoundException e){
                return "Сотрудника не существует в базе данных!";
            }
        }
    }
@GetMapping("/find")
    public Employee findEmployee(@RequestParam(value = "firstName", required = false) String firstName,
                               @RequestParam(value = "lastName",required = false) String lastName ){
    if (firstName == null || lastName == null || firstName =="" || lastName == ""){
        throw new RuntimeException("Параметры не должны быть пустыми, укажите имя и фамилию");} //кидается в идею, как кинуть пользователю?
    else{ employeeService.findEmployee(firstName,lastName);
        return new Employee(firstName,lastName);}


    }
}







