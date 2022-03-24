package com.metasis.example.service;

import java.util.List;

import com.metasis.example.entity.Person;

public interface PersonService {
	List<Person>  getAll();
	String add(Person person);
	String updatePerson(Person person);
	Person getByPersonId(int id);
	void delete(int id);
	
	
}
