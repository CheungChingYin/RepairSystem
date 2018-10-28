package com.repairsystem.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author CheungChingYin
 * @date 2018/10/28
 * @time 20:31
 */
public class PasswordEncryptionUtils {

    /**
     * MD5密码加密工具
     * @param password
     * @return
     */
    public static String plainText2MD5Encrypt(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output = md.digest(password.getBytes());
            String ret = Base64.encodeBase64String(output);
            return ret;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }
}
