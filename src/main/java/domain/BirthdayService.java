package domain;


import java.time.LocalDate;
import java.util.List;

public class BirthdayService {

    private final EmployeePort employees;
    private final EmailService service;

    public BirthdayService(EmployeePort employees, EmailService service) {
        this.employees = employees;
        this.service = service;
    }

    public void sendGreetings(LocalDate birthdayDate) {
        List<Employee> employeeList = employees.all();

        if (!employeeList.isEmpty()) {
            service.send();
        }
    }
}