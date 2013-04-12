package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.plsql.messages.OpbMessages;
import com.butterfill.opb.session.OpbSessionHelper;
import java.util.logging.Logger;

/**
 *
 * @author butterp
 */
public class DbMessageAdmin {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            DbMessageAdmin.class.getName();
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /** 
     * Creates a new instance of DbMessageAdmin 
     */
    public DbMessageAdmin() {
        logger.entering(CLASS_NAME, "DbMessageAdmin()");
    }

    public OpbMessages getMessages() {
        OpbMessages result = OpbSessionHelper.getInstance(
                OpbMessages.class, CLASS_NAME);
        if (result.getMessageLevel() == null) {
            result.setMessageLevel(OpbMessages.MESSAGE_LEVEL_INFO);
        }
        return result;
    }
    
} // End of class DbMessageAdmin
