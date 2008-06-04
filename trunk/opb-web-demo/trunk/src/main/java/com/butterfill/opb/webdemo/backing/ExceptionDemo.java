package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.session.OpbSessionHelper;
import java.util.logging.Logger;

/**
 * Backing bean for the exception demo page.
 * This bean should be scoped as either session or request as it has state that
 * propbably should not be shared between sessions.
 */
public class ExceptionDemo {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = 
            ExceptionDemo.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /** 
     * Creates a new instance of ExceptionDemo.
     */
    public ExceptionDemo() {
        logger.entering(CLASS_NAME, "ExceptionDemo()");
    }

    /**
     * Returns an ExceptionDemo data object for the current session.
     * Not really a big deal but this method shows how to cope when classes share names.
     * @return An ExceptionDemo data object for the current session.
     */
    public com.butterfill.opb.webdemo.data.ExceptionDemo getExceptionDemo() {
        return OpbSessionHelper.getInstance(
                com.butterfill.opb.webdemo.data.ExceptionDemo.class, CLASS_NAME);
    }
    
    /**
     * The message to be used when throwException throws an exception.
     */
    private String exceptionMessage;

    /**
     * Returns the message to be used when throwException throws an exception.
     * @return The message to be used when throwException throws an exception.
     */
    public String getExceptionMessage() {
        return exceptionMessage;
    }

    /**
     * Sets the message to be used when throwException throws an exception.
     * @param exceptionMessage
     *   The message to be used when throwException throws an exception.
     */
    public void setExceptionMessage(final String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
    
    /**
     * Throws a RuntimeException using the message set by setExceptionMessage(String).
     * @return nothing as an exception is always thrown.
     * @see #setExceptionMessage(java.lang.String) 
     */
    public String throwException() {
        throw new RuntimeException(exceptionMessage);
    }
    
} // End of class ExceptionDemo
