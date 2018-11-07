package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/11/7
 * @time 19:08
 */
public class PageIsNullException extends RuntimeException {
    public PageIsNullException() {
        super();
    }

    public PageIsNullException(String message) {
        super(message);
    }

    public PageIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public PageIsNullException(Throwable cause) {
        super(cause);
    }

    protected PageIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
