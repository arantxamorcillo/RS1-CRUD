package com.RS1CRUD.RS1CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CRUD {

    @Autowired
    List<Person> people;

    @PostMapping("/person")
    public String addPerson(@RequestBody Person person){
        people.add(person);
        return person + "added";
    }

    @PutMapping("/person/{id}")
    public String editPerson(@PathVariable int id, @RequestBody Person person) {
        for (Person personInList : people) {
            System.out.println(personInList.getName());

            if (personInList.getId()== id){

                if (person.getName() != null){
                    personInList.setName(person.getName());
                }

                if (person.getAge() != null){
                    personInList.setAge(person.getAge());
                }
                if (person.getCity() != null){
                    personInList.setCity(person.getCity());
                }

                return "List update" + people;
            }
        }
        return "person for name= " + person.getName() + " not found";
    }


    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable int id){

        for (Person person : people) {

            if (person.getId() == id ) {
                return  person.toString();
            }
        }
        return null;
    }

    @GetMapping("/person/name/{name}")
    public String getPerson(@PathVariable String name){

        for (Person person : people) {

            if (person.getName().equals(name)){
                return  person.toString();
            }
        }
        return null;
    }

    @DeleteMapping("/person/{id}")
    public String deletePerson (@PathVariable int id){

        for (Person person : people) {

            if (person.getId() == id ) {
                people.remove(person);
                return  "List update" + people;
            }
        }
        return null;
    }




}
