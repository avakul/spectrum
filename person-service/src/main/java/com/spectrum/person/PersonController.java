package com.spectrum.person;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping(value = "/persons")
    public List<String> available() {
        List<String> persons = new ArrayList<>();
        persons.add("Person1");
        persons.add("Person2");
        return persons;
    }
}