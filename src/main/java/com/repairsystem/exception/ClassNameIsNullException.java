package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 12:45
 */
public class ClassNameIsNullException extends RuntimeException {

    public ClassNameIsNullException() {
        super();
    }

    public ClassNameIsNullException(String message) {
        super(message);
    }

    public ClassNameIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassNameIsNullException(Throwable cause) {
        super(cause);
    }

    protected ClassNameIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
