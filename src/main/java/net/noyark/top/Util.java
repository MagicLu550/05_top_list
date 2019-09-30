package net.noyark.top;


import org.springframework.util.DigestUtils;

/**
 * 工具类
 */
public class Util {

    //密码的加密规则
    //salt+password+salt
    public static String md5Password(String password,String salt){
        try {
            password = salt + password + salt;
            return new String(DigestUtils.md5Digest(password.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    
}
