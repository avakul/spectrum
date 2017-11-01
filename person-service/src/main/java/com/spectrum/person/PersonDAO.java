package com.spectrum.person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spectrum.personservice.domain.Person;

@Configuration
public class PersonDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	 
	public PersonDAO(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final Logger log = LoggerFactory.getLogger(PersonDAO.class);

	List<Person> getPatients() {

		log.info("Creating tables");

		List<Person> persons = new ArrayList<>();

		jdbcTemplate.execute("if exists (select 1 from sys.tables where name = 'persons') \r\n" + 
				"drop table persons");
		jdbcTemplate.execute("CREATE TABLE persons(id int identity, first_name VARCHAR(255), last_name VARCHAR(255))");

		// Split up the array of whole names into an array of first/last names
		List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
				.map(name -> name.split(" ")).collect(Collectors.toList());

		// Use a Java 8 stream to print out each tuple of the list
		splitUpNames.forEach(name -> log.info(String.format("Inserting patient record for %s %s", name[0], name[1])));

		// Uses JdbcTemplate's batchUpdate operation to bulk load data
		jdbcTemplate.batchUpdate("INSERT INTO persons(first_name, last_name) VALUES (?,?)", splitUpNames);

		log.info("Querying for all records from Persons");
		jdbcTemplate.query("SELECT id, first_name, last_name FROM persons",
				(rs, rowNum) -> new Person(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
				.forEach(person -> persons.add(person));

		return persons;
	}
}
