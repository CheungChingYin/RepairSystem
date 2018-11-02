package com.repairsystem.exception;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 9:46
 */
public class BuildingNameIdIsNullException extends RuntimeException {

    public BuildingNameIdIsNullException() {
        super();
    }

    public BuildingNameIdIsNullException(String message) {
        super(message);
    }

    public BuildingNameIdIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public BuildingNameIdIsNullException(Throwable cause) {
        super(cause);
    }

    protected BuildingNameIdIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
