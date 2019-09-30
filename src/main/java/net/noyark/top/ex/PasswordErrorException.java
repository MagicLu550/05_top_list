package net.noyark.top.ex;

//找不到用户和密码错误找到抛出这个异常
public class PasswordErrorException extends ServiceException{

    public PasswordErrorException() {
    }

    public PasswordErrorException(String message) {
        super(message);
    }

    public PasswordErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordErrorException(Throwable cause) {
        super(cause);
    }

    public PasswordErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
