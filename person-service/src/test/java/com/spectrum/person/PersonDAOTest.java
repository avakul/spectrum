package com.spectrum.person;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.spectrum.personservice.domain.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonApplication.class)
public class PersonDAOTest {

	@Autowired
	PersonDAO dao;

	@Test
	public void simpleTest() {
		assertNotNull(dao);
		List<Person> persons = dao.getPatients();
		assertNotNull(persons);
	}
}
