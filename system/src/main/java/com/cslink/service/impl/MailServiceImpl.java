package com.cslink.service.impl;

import com.cslink.service.IMailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender mailer;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public boolean sendMail(String to, String subject, String content) {
        Map mailInfo = new HashMap<String,Object>();
        mailInfo.put("project","demo");
        mailInfo.put("author","cslink");
        mailInfo.put("code",content);

        MimeMessage message = mailer.createMimeMessage();
        MimeMessageHelper mailHelper = null;
        try {
            mailHelper = new MimeMessageHelper(message,true);
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(mailInfo.toString());
            mailer.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
