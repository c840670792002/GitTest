package com.fet.crm.smarthome.generic.util;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class BusinessException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -800875115907859749L;

    public BusinessException() {
        super();
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }
}
