package it.xpeppers.birthday_greetings.domain;

import org.junit.jupiter.api.Test;

import static java.time.LocalDate.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static org.mockito.Mockito.*;

public class BirthdayServiceTest {

    private BirthdayService service;

    private final EmployeePort employeePort = mock(EmployeePort.class);

    private final EmailService emailService = mock(EmailService.class);

    @Test
    void should_send_no_mail_when_no_employee_found() {
        when(employeePort.all()).thenReturn(emptyList());

        service = new BirthdayService(employeePort, emailService);

        service.sendGreetings(of(2020,10,10));

        verify(employeePort).all();
        verifyNoInteractions(emailService);
    }

    @Test
    void should_send_mail_when_employees_found() {
        when(employeePort.all()).thenReturn(singletonList(new Employee()));

        service = new BirthdayService(employeePort, emailService);
        service.sendGreetings(of(2020,10,10));

        verify(emailService).send();
    }

    @Test
    void should_send_email_in_a_list_of_3_employee() {
        when(employeePort.all()).thenReturn(asList(new Employee(),
                                                   new Employee(),
                                                   new Employee()));

        service = new BirthdayService(employeePort, emailService);
        service.sendGreetings(of(2020,10,10));

        verify(emailService, times(3)).send();
    }
}
