package it.xpeppers.birthday_greetings;

import java.util.GregorianCalendar;

public
class Employee
{
	String            last_name;
	String            first_name;
	GregorianCalendar date_of_birth;
	String email;
	
	public
	Employee(String last_name, String first_name, GregorianCalendar date_of_birth, String email)
	{
		this.last_name = last_name;
		this.first_name = first_name;
		this.date_of_birth = date_of_birth;
		this.email = email;
	}




}
