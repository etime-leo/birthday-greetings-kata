package domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.*;

public class BirthdayServiceTest {

    private BirthdayService service;

    private EmployeeRepository employeeRepository = mock(EmployeeRepository.class);

    private EmailService emailService = mock(EmailService.class);


    @Test
    void should_send_no_mail_when_no_employee_found() {
        when(employeeRepository.all()).thenReturn(emptyList());

        service = new BirthdayService(employeeRepository, emailService);
        service.sendGreetings("10/10/2020");

        verifyNoInteractions(emailService);
    }
}
