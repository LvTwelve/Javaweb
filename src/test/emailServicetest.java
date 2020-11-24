package test;

import org.junit.Test;
import service.EmailService;
import service.impl.EmailServiceImpl;

import javax.mail.internet.AddressException;

public class emailServicetest {
    private EmailService emailService = new EmailServiceImpl();

    @Test
    public void addEmail() throws AddressException {
        System.out.println(emailService.SendEmail("594042493@qq.com","1234","17:36"));
    }
}
