package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.request.PersonDto;
import one.digitalinnovation.personapi.dto.response.MessageResponseDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeDto;
import static one.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository repository;

    @Mock
    private PersonMapper mapper;

    @InjectMocks
    private PersonService service;

    @Test
    void testGivenPersonDtoThenReturnSavedMessage() {
        PersonDto personDto = createFakeDto();
        Person expectedSavedPerson = createFakeEntity();

        //when(mapper.toModel(personDto)).thenReturn(expectedSavedPerson);
        when(repository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDto expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageResponseDto successMessage = service.createPerson(personDto);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDto createExpectedMessageResponse(Long id) {
        return MessageResponseDto
                .builder()
                .message("Created person with ID " + id)
                .build();
    }
}
