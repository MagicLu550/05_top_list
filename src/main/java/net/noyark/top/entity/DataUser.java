package net.noyark.top.entity;

//
//password_sha256 text,               -- 加密的密码
//        salt text,
public class DataUser extends BaseEntity {



    private String salt;

    private String passwordMd5;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordSha256) {
        this.passwordMd5 = passwordSha256;
    }
}
