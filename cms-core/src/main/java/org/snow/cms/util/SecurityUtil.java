package org.snow.cms.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {
    public static String md5(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("加密失败!" + e.getMessage());
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }

    public static String md5(String username, String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(username.getBytes());
            md.update(password.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("加密失败!" + e.getMessage());
            e.printStackTrace();
        }
        return new BigInteger(1, md.digest()).toString(16);
    }
}
