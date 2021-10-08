package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.request.PersonDto;
import one.digitalinnovation.personapi.dto.response.MessageResponseDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundExeption;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<PersonDto> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public PersonDto findById(@PathVariable Long id) throws PersonNotFoundExeption {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundExeption {
        service.delete(id);
    }
}
