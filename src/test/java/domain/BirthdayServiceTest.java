package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static java.time.LocalDate.*;
import static java.util.Collections.*;
import static org.mockito.Mockito.*;

public class BirthdayServiceTest {

    private BirthdayService service;

    private EmployeePort employeePort = mock(EmployeePort.class);

    private EmailService emailService = mock(EmailService.class);

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
}
