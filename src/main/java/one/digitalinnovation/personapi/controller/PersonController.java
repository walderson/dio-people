package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PersonDto;
import one.digitalinnovation.personapi.dto.response.MessageResponseDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto) {
        return service.createPerson(personDto);
    }
}
