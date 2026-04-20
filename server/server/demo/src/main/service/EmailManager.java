package com.example.demo.model;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.stereotype.Service;

@Service
public class EmailManager {

    private final AmazonSimpleEmailService ses =
            AmazonSimpleEmailServiceClientBuilder.standard()
                    .withRegion("ap-south-1")
                    .build();

    public String sendEmail(String toEmail, String subject, String message) {
        try {
            SendEmailRequest request = new SendEmailRequest()
                    .withSource("your-verified-email@domain.com")
                    .withDestination(new Destination().withToAddresses(toEmail))
                    .withMessage(new Message()
                            .withSubject(new Content(subject))
                            .withBody(new Body().withText(new Content(message)))
                    );

            ses.sendEmail(request);
            return "200::Email sent successfully";

        } catch (Exception e) {
            return "500::" + e.getMessage();
        }
    }
}