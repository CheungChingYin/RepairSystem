package com.repairsystem.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * 邮件服务
 *
 * @author CheungChingYin
 * @date 2018/11/18
 * @time 14:43
 */
public interface EmailService {

    /**
     * 接受工单邮件
     *
     * @param userName  用户名
     * @param userEmail 用户邮箱
     * @return
     */
    String acceptOrderMail(String userName, String userEmail);

    /**
     * 完成工单发送邮件
     *
     * @param userName  用户名
     * @param userEmail 用户邮箱
     * @return 发送成功
     */
    String completeOrderMail(String userName, String userEmail);
}
