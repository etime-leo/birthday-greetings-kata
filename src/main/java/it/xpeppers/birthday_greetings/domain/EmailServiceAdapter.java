package it.xpeppers.birthday_greetings.domain;

public class EmailServiceAdapter implements EmailService {

    private BirthDayMessageService birthDayMessageService;

    public EmailServiceAdapter(BirthDayMessageService birthDayMessageService) {
        this.birthDayMessageService = birthDayMessageService;
    }

    @Override
    public void send() {
        birthDayMessageService.create();
    }
}
