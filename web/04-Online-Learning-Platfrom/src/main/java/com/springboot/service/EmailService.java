package com.springboot.service;

import com.springboot.entity.EmailLog;
import com.springboot.repository.EmailLogRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private EmailLogRepository emailLogRepository;

    public void sendVerificationEmail(String email) {
        sendEmail(email, "Email Verification", "Please verify your email address by clicking on the link provided.");
    }

    public void sendApprovalNotification(String email, String courseTitle) {
        sendEmail(email, "Course Approved", "Your course titled '" + courseTitle + "' has been approved.");
    }

    public void sendRejectionNotification(String email, String courseTitle, String feedback) {
        sendEmail(email, "Course Rejected", "Your course titled '" + courseTitle + "' has been rejected. Feedback: " + feedback);
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        // Send the email
        mailSender.send(message);

        // Log the email
        EmailLog log = new EmailLog(to, subject, text, LocalDateTime.now());
        emailLogRepository.save(log);
    }
}