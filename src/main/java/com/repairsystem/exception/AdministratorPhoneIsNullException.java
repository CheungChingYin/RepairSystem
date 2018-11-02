package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/10/30
 * @time 21:55
 */
public class AdministratorPhoneIsNullException extends RuntimeException {

    public AdministratorPhoneIsNullException() {
        super();
    }

    public AdministratorPhoneIsNullException(String message) {
        super(message);
    }

    public AdministratorPhoneIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdministratorPhoneIsNullException(Throwable cause) {
        super(cause);
    }

    protected AdministratorPhoneIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
