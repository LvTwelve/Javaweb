package servlet;

import service.EmailService;
import service.impl.EmailServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmailServlet")
public class EmailServlet extends BaseServlet{
    private EmailService emailService = new EmailServiceImpl();

    protected void sendEmail(HttpServletRequest request, HttpServletResponse response){

    }
}
