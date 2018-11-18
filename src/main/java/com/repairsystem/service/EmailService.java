package com.repairsystem.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * @author CheungChingYin
 * @date 2018/11/18
 * @time 14:43
 */
public interface EmailService {

    String acceptOrderMail(String userName,String userEmail);

    String completeOrderMail(String userName,String userEmail);
}
