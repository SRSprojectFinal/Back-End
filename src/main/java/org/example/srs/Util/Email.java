package org.example.srs.Util;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    private static final String FROM_EMAIL = "srs.academy.noreply@gmail.com";
    private static final String FROM_PASSWORD = "yowa bggk hnxg ddrf";

    public static boolean sendWelcomeEmail(String personalEmail, String educationalEmail, String professorName) {
        try {

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");


            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, FROM_PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(personalEmail));
            message.setSubject("Welcome to SRS - Your Educational Email");

            String emailBody = String.format(
                    "Dear %s,\n\n" +
                            "Welcome to the SRS (Student Registration System)!\n\n" +
                            "Your account has been successfully created. Here are your login credentials:\n\n" +
                            "Educational Email: %s\n" +
                            "This educational email will be used for all system communications and student interactions. " +
                            "Please use this email to log into the SRS platform.\n\n" +
                            "If you have any questions or need assistance, please don't hesitate to contact the system administrator.\n\n" +
                            "Best regards,\n" +
                            "SRS Team",
                    professorName, educationalEmail
            );

            message.setText(emailBody);
            Transport.send(message);

            System.out.println("Welcome email sent successfully to: " + personalEmail);
            return true;

        } catch (MessagingException e) {
            System.err.println("Error sending welcome email: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean testEmailConnection() {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(FROM_EMAIL, FROM_PASSWORD);
                }
            });

            Transport transport = session.getTransport("smtp");
            transport.connect();
            transport.close();

            System.out.println("Email connection test successful!");
            return true;

        } catch (jakarta.mail.NoSuchProviderException e) {
            System.err.println("Error testing email connection: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (jakarta.mail.MessagingException e) {
            System.err.println("Error testing email connection: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}