package pro.sky.java.course2.webmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeBookController {
    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping("/get")
    public String getEmployee(@RequestParam("number") Integer personNumberEmployee) {
        return "в списке есть сотрудник " + employeeBookService.getEmployee(personNumberEmployee) + "с персональным номером " + personNumberEmployee;
    }

    @GetMapping("/put")
    public String putEmployee(@RequestParam("number") Integer personNumberEmployee,
                              @RequestParam("name") String nameEmployee,
                              @RequestParam("surname") String surnameEmployee) {
        return "в список добавлен сотрудник " + employeeBookService.putEmployee(personNumberEmployee, nameEmployee, surnameEmployee) +
                ",  персональный номер - " + personNumberEmployee;
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam("number") Integer personNumberEmployee) {
        return "из списка удален сотрудник " + employeeBookService.removeEmployee(personNumberEmployee) + "с персональным номером " + personNumberEmployee;
    }

    @GetMapping("/getAll")
    public Map<Integer, Employee> getAll() {
        return employeeBookService.getAll();
    }

}
