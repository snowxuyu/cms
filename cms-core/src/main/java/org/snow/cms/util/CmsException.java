package org.snow.cms.util;

public class CmsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CmsException() {
    }

    public CmsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CmsException(String message, Throwable cause) {
        super(message, cause);
    }

    public CmsException(String message) {
        super(message);
    }

    public CmsException(Throwable cause) {
        super(cause);
    }
}