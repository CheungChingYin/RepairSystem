package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/10/30
 * @time 22:15
 */
public class AdministratorPasswordIsNullException extends RuntimeException {

    public AdministratorPasswordIsNullException() {
        super();
    }

    public AdministratorPasswordIsNullException(String message) {
        super(message);
    }

    public AdministratorPasswordIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdministratorPasswordIsNullException(Throwable cause) {
        super(cause);
    }

    protected AdministratorPasswordIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
