package it.xpeppers.birthday_greetings.domain;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BirthDayMessageServiceTest {

    @Test
    void should_build_a_message() {
        BirthDayMessageService birthDayMessageService = new BirthDayMessageService();

        assertEquals(new BirthDayMessage(), birthDayMessageService.create());
    }
}