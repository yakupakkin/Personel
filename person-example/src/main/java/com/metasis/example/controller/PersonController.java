package com.metasis.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metasis.example.entity.Person;
import com.metasis.example.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/getall")
	public List<Person> getAll() {

		return personService.getAll();

	}

	@PostMapping("/add")
	public String add(@RequestBody Person person) {
		return personService.add(person);
	}

	@PutMapping("/update")
	public String updatePerson(@RequestBody Person person) {
		return personService.updatePerson(person);
	}

	@GetMapping("/getByPersonId/{id}")
	public Person getByPersonId(@PathVariable("id") int id) {
		return personService.getByPersonId(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		personService.delete(id);
	}

}