package com.fet.crm.smarthome.generic.util;

/**
 * DOCUMENT ME!
 * 
 * @author $author$
 * @version $Revision$
 */
public class HttpConnectionException extends BusinessException {
    /**
     *
     */
    private static final long serialVersionUID = -800875115907859749L;

    public HttpConnectionException() {
        super();
    }

    public HttpConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public HttpConnectionException(final String message) {
        super(message);
    }

    public HttpConnectionException(final Throwable cause) {
        super(cause);
    }
}
