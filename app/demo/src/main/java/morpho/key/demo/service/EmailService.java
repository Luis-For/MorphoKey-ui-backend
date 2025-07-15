package morpho.key.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendRecoveryEmail(String toEmail, String token) {
        String subject = "Recuperación de contraseña";
        String recoveryUrl = "http://localhost:8080/reset-password?token=" + token;
        String message = "Haz clic en el siguiente enlace para restablecer tu contraseña:\n" + recoveryUrl;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(toEmail);
        email.setSubject(subject);
        email.setText(message);
        email.setFrom("morphokey@gmail.com");

        mailSender.send(email);
    }
}
