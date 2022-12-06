package com.repairsystem.service.Impl;

import com.repairsystem.service.EmailService;
import com.repairsystem.utils.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author CheungChingYin
 * @date 2018/11/18
 * @time 14:52
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String acceptOrderMail(String userName, String userEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(ConstantUtils.Mail.FROM_MAIL);
        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("【维修中】感谢您反馈机房报修问题");
        simpleMailMessage.setText("亲爱的" + userName + "先生/女生，您提交的报修工单机房管理员已确实收到，感谢您的反馈。机房管理员正在快马加鞭地解决您提交问题，维修完成后将会通过邮件通知您。");
        simpleMailMessage.setSentDate(new Date());
        mailSender.send(simpleMailMessage);
        return "OK";
    }

    @Override
    public String completeOrderMail(String userName, String userEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(ConstantUtils.Mail.FROM_MAIL);
        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("【维修完成】感谢您反馈机房报修问题已完成");
        simpleMailMessage.setText("亲爱的" + userName + "先生/女生，您提交的报修机房工单已维修完成，感谢您的反馈,让我们的机房环境变得更好！");
        simpleMailMessage.setSentDate(new Date());
        mailSender.send(simpleMailMessage);
        return "OK";
    }
}
