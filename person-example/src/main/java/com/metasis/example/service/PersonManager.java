package com.metasis.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metasis.example.dao.PersonDao;
import com.metasis.example.entity.Person;

@Service
public class PersonManager implements PersonService {

	@Autowired
	private PersonDao personDao;
	
	@Override
	public List<Person>  getAll() {
		List<Person> list = personDao.findAll();
		return list;
		
	}

	@Override
	public String add(Person person) {
		Optional<Person> isRecorded = personDao.findById(person.getId());
		if (!isRecorded.isPresent()) {
			personDao.save(person);
			return "Save successfully";
		}
		return "Person is already in database";
	}

	@Override
	public String updatePerson(Person person) {
	personDao.deleteById(person.getId());
	personDao.save(person);
	return "Updated successfully";
	}

	@Override
	public Person getByPersonId(int id) {
		return personDao.findById(id).get();
	}

	@Override
	public void delete(int id) {
		personDao.deleteById(id);
	}

}