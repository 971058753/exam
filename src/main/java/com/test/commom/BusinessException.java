package com.test.commom;

public class BusinessException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 7427031760926895371L;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}