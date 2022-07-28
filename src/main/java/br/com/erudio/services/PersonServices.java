package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();


    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person create(Person person){
        logger.info("Creating one person!");

        return person;
    }

    public Person update(Person person, String id){
        logger.info("Updating one person!");

        Person personToUpdate = getById(id);
        personToUpdate = person;
        return personToUpdate;
    }


    public List<Person> getAll(){
        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    public Person getById(String id){
        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Luan");
        person.setLastName("Ramalho");
        person.setAddress("Rio de Janeiro");
        person.setGender("Male");

        return person;
    }

    public void delete(String id){
        logger.info("Deleting one person!");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name" + i);
        person.setLastName("Person lastName" + i);
        person.setAddress("city" + i);
        person.setGender("gender" + i);
        return person;
    }
}
