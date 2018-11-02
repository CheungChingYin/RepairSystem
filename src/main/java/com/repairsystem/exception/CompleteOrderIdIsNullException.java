package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/10/30
 * @time 22:22
 */
public class CompleteOrderIdIsNullException extends RuntimeException {

    public CompleteOrderIdIsNullException() {
        super();
    }

    public CompleteOrderIdIsNullException(String message) {
        super(message);
    }

    public CompleteOrderIdIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompleteOrderIdIsNullException(Throwable cause) {
        super(cause);
    }

    protected CompleteOrderIdIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
