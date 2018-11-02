package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 9:30
 */
public class OrderIdIsNullException extends RuntimeException {

    public OrderIdIsNullException() {
        super();
    }

    public OrderIdIsNullException(String message) {
        super(message);
    }

    public OrderIdIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderIdIsNullException(Throwable cause) {
        super(cause);
    }

    protected OrderIdIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
