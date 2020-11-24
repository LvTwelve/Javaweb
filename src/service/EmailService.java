package service;

import javax.mail.internet.AddressException;

public interface EmailService {
    boolean SendEmail(String receiveEmail,String orderId,String orderTime) throws AddressException;
}
