package pro.sky.java.course2.webmap;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class EmployeeBookService {
    Map<Integer, Employee> employeesMap = new HashMap<>();

    public Employee getEmployee(Integer personNumberEmployee) {
        if (!employeesMap.containsKey(personNumberEmployee)) {
            throw new RuntimeException("Сотрудника с таким номером нет в списке");
        }
        return employeesMap.get(personNumberEmployee);
    }

    public Employee putEmployee(Integer personNumberEmployee, String nameEmployee, String surnameEmployee) {
        Employee employee = new Employee(nameEmployee, surnameEmployee);
        if (employeesMap.containsKey(personNumberEmployee)) {
            throw new RuntimeException("Сотрудник с номером " + personNumberEmployee + " уже есть");
        }
        employeesMap.put(personNumberEmployee, employee);

        return employee;
    }

    public Employee removeEmployee(Integer personNumberEmployee) {
        if (!employeesMap.containsKey(personNumberEmployee)) {
            throw new RuntimeException("Сотрудника с таким номером нет в списке");
        }
        return employeesMap.remove(personNumberEmployee);
    }

    public Map<Integer, Employee> getAll() {
        return new HashMap<>(employeesMap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBookService that = (EmployeeBookService) o;
        return Objects.equals(employeesMap, that.employeesMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeesMap);
    }

}



