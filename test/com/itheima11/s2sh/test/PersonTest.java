package com.itheima11.s2sh.test;

import org.junit.Test;

import com.itheima11.s2sh.domain.Person;
import com.itheima11.s2sh.service.PersonService;

public class PersonTest extends SpringUtils{
	@Test
	public void testSavePerson(){
		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setName("黄渤");
		personService.savePerson(person);
	}
	
	@Test
	public void testQueryAction(){
		context.getBean("personAction");
	}
}
