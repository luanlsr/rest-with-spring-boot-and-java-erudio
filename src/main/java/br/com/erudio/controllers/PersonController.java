package br.com.erudio.controllers;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired // faz a instanciação em tempo de execução
    private PersonServices service;
//    private PersonServices service = new PersonServices();

    @RequestMapping(value = "/all", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAll() throws Exception {
        return service.getAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) throws Exception {
        return service.getById(id);
    }
}
