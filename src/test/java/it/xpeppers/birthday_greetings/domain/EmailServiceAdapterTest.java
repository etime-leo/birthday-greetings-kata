package it.xpeppers.birthday_greetings.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmailServiceAdapterTest {

    private EmailServiceAdapter emailServiceAdapter;

    @Test
    void should_call_birthDayMessageService_create() {
        BirthDayMessageService birthDayMessageService = mock(BirthDayMessageService.class);
        emailServiceAdapter = new EmailServiceAdapter(birthDayMessageService);

        emailServiceAdapter.send();

        verify(birthDayMessageService).create();
    }
}