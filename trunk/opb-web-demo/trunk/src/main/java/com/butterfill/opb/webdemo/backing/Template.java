package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.session.OpbSessionHelper;
import com.butterfill.opb.web.faces.OpbMessageHelper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Backing bean for the page template.
 * <br/>
 * This needs to be a request scoped bean so that we know when 
 * getSessionMessages has been called.
 * 
 * @author butterp
 */
public class Template {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = Template.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The message helper used by this class.
     */
    private final OpbMessageHelper messageHelper;
    
    /**
     * Flag to tell us if getSessionMessages has been called yet.
     */
    private boolean firstGetSessionMessagesCall = true;
    
    /** 
     * Creates a new instance of Template 
     */
    public Template(OpbMessageHelper messageHelper) {
        logger.entering(CLASS_NAME, "Template()");
        
        this.messageHelper = messageHelper;
    }

    public String getSessionMessages() {
        final String methodName = "getSessionMessages()";
        
        logger.entering(CLASS_NAME, methodName);
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName, 
                "firstGetSessionMessagesCall={0}", 
                firstGetSessionMessagesCall);
        
        if (firstGetSessionMessagesCall) {
            // only add messages if this is the first call.
            messageHelper.addOpbMessagesToFacesContext();
            firstGetSessionMessagesCall = false;
            
        }
        
        return null;
        
    } // End of getSessionMessages()
    
    public String clearOpbSessionState() {
        OpbSessionHelper.clearSessionState();
        return null;
    }
    
}
