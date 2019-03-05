package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author : Julian
 * @date : 2019/3/5 10:37
 */
@Service
public class MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail(String receiver,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);
        message.setFrom(sender);

        mailSender.send(message);
    }

    public void sendHtmlMail(String receiver,String subject,String content) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(receiver);
        helper.setSubject(subject);
        helper.setText(content, true);
        helper.setFrom(sender);

        mailSender.send(mimeMessage);
    }

    public void sendAttachmentsMail(String receiver,String subject,String content, String filePath) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(receiver);
        helper.setText(content, true);
        helper.setSubject(subject);
        helper.setFrom(sender);

        FileSystemResource file = new FileSystemResource(new File(filePath));
        String filename = file.getFilename();
        helper.addAttachment(filename, file);

        mailSender.send(mimeMessage);
    }

    public void sendInlineResourceMail(String receiver,String subject,String content,String rscPath, String rscId) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject(subject);
        helper.setTo(receiver);
        helper.setText(content, true);
        helper.setFrom(sender);

        FileSystemResource resource = new FileSystemResource(new File(rscPath));
        helper.addInline(rscId,resource);
        mailSender.send(mimeMessage);
    }
}
