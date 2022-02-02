package it.xpeppers.birthday_greetings;

import it.xpeppers.birthday_greetings.employeeReader.EmployeeReader;

import java.util.GregorianCalendar;
import java.util.List;

public class BirthdayService {

	EmployeeReader employeeReader;
	MailSender mailSender;

	public
	BirthdayService(EmployeeReader employeeReader, MailSender mailSender)
	{
		this.employeeReader = employeeReader;
		this.mailSender = mailSender;
	}

	public
	void sendGreetings(GregorianCalendar date)
	{
		List<Employee> employees = employeeReader.returnListEmployees();

		mailSender.sendMail(employees.get(0));
	}
}
