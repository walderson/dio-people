package one.digitalinnovation.personapi;

import one.digitalinnovation.personapi.dto.request.PersonDto;
import one.digitalinnovation.personapi.dto.request.PhoneDto;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.entity.Phone;
import one.digitalinnovation.personapi.mapper.PersonMapper;
import one.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDtoThenReturnPersonEntity() {
        PersonDto PersonDto = PersonUtils.createFakeDto();
        Person person = personMapper.toModel(PersonDto);

        assertEquals(PersonDto.getFirstName(), person.getFirstName());
        assertEquals(PersonDto.getLastName(), person.getLastName());
        assertEquals(PersonDto.getCpf(), person.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDto PhoneDto = PersonDto.getPhones().get(0);

        assertEquals(PhoneDto.getType(), phone.getType());
        assertEquals(PhoneDto.getNumber(), phone.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDto() {
        Person person = PersonUtils.createFakeEntity();
        PersonDto PersonDto = personMapper.toDto(person);

        assertEquals(person.getFirstName(), PersonDto.getFirstName());
        assertEquals(person.getLastName(), PersonDto.getLastName());
        assertEquals(person.getCpf(), PersonDto.getCpf());

        Phone phone = person.getPhones().get(0);
        PhoneDto PhoneDto = PersonDto.getPhones().get(0);

        assertEquals(phone.getType(), PhoneDto.getType());
        assertEquals(phone.getNumber(), PhoneDto.getNumber());
    }
}