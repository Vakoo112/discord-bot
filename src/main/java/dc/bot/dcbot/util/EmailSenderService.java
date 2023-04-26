/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dc.bot.dcbot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author vako
 */
@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender ;
    
    public void SendSimpleEmail (String toEmail,
            String body,
            String subject) {
         SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom("vakovako229@gmail.com");
         message.setTo(toEmail);
         message.setText(body);
         message.setSubject(subject);
         
        javaMailSender.send(message);
        System.out.println("message was sent "  );
         
    }

}
