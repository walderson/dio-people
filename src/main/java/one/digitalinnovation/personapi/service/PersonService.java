package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDto;
import one.digitalinnovation.personapi.dto.response.MessageResponseDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.PersonNotFoundExeption;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository repository;
    private final PersonMapper mapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public MessageResponseDto createPerson(PersonDto personDto) {
        Person personToSave = mapper.toModel(personDto);
        Person savedPerson = repository.save(personToSave);
        return MessageResponseDto
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDto> listAll() {
        List<Person> all = repository.findAll();
        return all.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public PersonDto findById(Long id) throws PersonNotFoundExeption {
        Person person = verifyIfExists(id);
        return mapper.toDto(person);
    }

    public void delete(Long id) throws PersonNotFoundExeption {
        Person person = verifyIfExists(id);
        repository.deleteById(id);
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundExeption {
        return repository.findById(id).orElseThrow(() -> new PersonNotFoundExeption(id));
    }
}
