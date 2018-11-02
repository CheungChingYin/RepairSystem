package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 9:44
 */
public class BuildingIdIsNullException extends RuntimeException {

    public BuildingIdIsNullException() {
        super();
    }

    public BuildingIdIsNullException(String message) {
        super(message);
    }

    public BuildingIdIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildingIdIsNullException(Throwable cause) {
        super(cause);
    }

    protected BuildingIdIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
