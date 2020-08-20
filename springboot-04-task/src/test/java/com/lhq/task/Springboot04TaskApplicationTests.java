package com.lhq.task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@SpringBootTest
class Springboot04TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知-下午不去学");
        message.setText("今晚7：00上完课");
        message.setTo("2283356490@qq.com");
        message.setFrom("2233655584@qq.com");
        javaMailSender.send(message);
    }
    @Test
    public void test02() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("通知-下午不去学");
        helper.setText("<b style='color:red'>今晚7：00上完课</b>",true);
        helper.addAttachment("1.jpg",new File("C:\\Users\\李浩琦\\Desktop\\Screenshot_2020-03-13-11-50-13-788_com.alibaba.android.rimet.jpg"));
        helper.setTo("13014701572@163.com");
        helper.setFrom("2233655584@qq.com");
        javaMailSender.send(mimeMessage);
    }
}
