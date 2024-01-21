package com.member.service;

import com.member.service.random.RandomCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendVerificationCode(String to) {

        String verificationCode = RandomCodeGenerator.generateRandomCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("이메일 인증 코드");
        message.setText("인증 코드: " + verificationCode);

        javaMailSender.send(message);
    }

    private String generateVerificationCode() {
        return RandomCodeGenerator.generateRandomCode();
    }
}
