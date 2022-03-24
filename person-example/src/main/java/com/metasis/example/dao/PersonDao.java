package com.metasis.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.metasis.example.entity.Person;


@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {
	
	List<Person> findAll();

}
