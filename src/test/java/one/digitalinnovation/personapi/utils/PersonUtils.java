package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.dto.request.PersonDto;
import one.digitalinnovation.personapi.entity.Person;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final Long PERSON_ID = 1L;
    private static final String FIRST_NAME = "Machado";
    private static final String LAST_NAME = "de Assis";
    private static final String CPF = "369.333.878-79";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1992, 04, 27);

    public static PersonDto createFakeDto() {
        return PersonDto.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate("27/04/1992")
                .phones(Collections.singletonList(PhoneUtils.createFakeDto()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
