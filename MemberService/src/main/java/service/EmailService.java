package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import service.random.RandomCodeGenerator;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendVerificationCode(String to) {

        String verificationCode = RandomCodeGenerator.generateRandomCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("이메일 인증 코");
        message.setText("인증 코드: " + verificationCode);

        javaMailSender.send(message);
    }
}
