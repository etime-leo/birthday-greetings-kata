package it.xpeppers.birthday_greetings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class BirthdayServiceTest {


    @Test
    void name() {
        MailSender mailSender = new MailSenderMock();
        List<Employee> employees = new ArrayList<Employee>();
        BirthdayService birthdayService = new BirthdayService(mailSender);
        GregorianCalendar date = new GregorianCalendar();
        date.set(2022, GregorianCalendar.FEBRUARY, 2);
        birthdayService.sendGreetings(employees, date);
    }

}