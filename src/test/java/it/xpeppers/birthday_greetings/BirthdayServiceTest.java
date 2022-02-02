package it.xpeppers.birthday_greetings;

import it.xpeppers.birthday_greetings.employeeReader.EmployeeReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class BirthdayServiceTest {


	EmployeeReader employeeReader = mock(EmployeeReader.class);

	MailSender mailSender = mock(MailSender.class);

    @Test
    void sendGreetings() {
        BirthdayService birthdayService = new BirthdayService(employeeReader, mailSender);
        GregorianCalendar date = new GregorianCalendar();
        date.set(2022, GregorianCalendar.FEBRUARY, 2);

	    Employee employee = new Employee("Doe", "John", date, "john.doe@foobar.com");

	    List<Employee> employees = Arrays.asList(employee);
	    when(employeeReader.returnListEmployees()).thenReturn(employees);


        birthdayService.sendGreetings(date);


		verify(mailSender).sendMail(employee);
    }

}