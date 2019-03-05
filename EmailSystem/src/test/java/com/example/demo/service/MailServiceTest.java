package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @author : Julian
 * @date : 2019/3/5 11:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMailTest() {
        mailService.sendSimpleMail("244901948@qq.com", "来自julian163邮箱的邮件", "Hello world,这是我的第一份邮件");
    }

    @Test
    public void sendSimpleHtmlMailTest() throws MessagingException {
        String content = "<html>\n"+
                "<body>\n"+
                "<h3> Hello 这是一封html邮件</h3>"+
                "</body>\n"+
                "</html>";
        mailService.sendHtmlMail("244901948@qq.com", "来自julian163邮箱的HTML邮件", content);
    }

    @Test
    public void sendAttachmentsMailTest() throws MessagingException {
        String filePath = "G:\\BaiduNetdiskDownload\\Shadowsocks\\-win-2.3.1\\gui-config.json";
        mailService.sendAttachmentsMail("244901948@qq.com", "来自julian163邮箱的附件邮件", "这是一封带附件的邮件", filePath);
    }

    @Test
    public void sendInlineResourceMailTest() throws MessagingException {
        String imgPath = "C:\\Users\\Administrator\\Pictures\\spring.png";
        String rscId = "png001";
        String content = "<html>\n"+
                "<body>\n"+
                "<h3> Hello 这是一封带有图片的html邮件</h3>"+
                "<img src=\'cid:" + rscId + "\' />" +
                "</body>\n"+
                "</html>";
        mailService.sendInlineResourceMail("244901948@qq.com", "来自julian163邮箱的图片html邮件", content, imgPath, rscId);
    }

    @Test
    public void templateMailTest() throws MessagingException {
        Context context = new Context();
        context.setVariable("id", "006");

        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("244901948@qq.com", "来自julian163邮箱的HTML模板邮件", emailContent);
    }
}
