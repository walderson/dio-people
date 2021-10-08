package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.response.MessageResponseDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public MessageResponseDto createPerson(Person person) {
        Person savedPerson = repository.save(person);
        return MessageResponseDto
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
