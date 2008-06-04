
package com.butterfill.opb.web.faces;

import com.butterfill.opb.plsql.messages.OpbMessage;
import com.butterfill.opb.plsql.messages.OpbMessages;
import com.butterfill.opb.session.OpbSessionHelper;
import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Provides methods to help when working with Opb and JSF messages.
 */
public class OpbMessageHelper {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbMessageHelper.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Creates a new instance of OpbMessageHelper.
     */
    public OpbMessageHelper() {
        logger.entering(CLASS_NAME, "OpbMessageHelper()");
    }
    
    /**
     * Adds all opb messages for the current session to the current faces context.
     */
    public void addOpbMessagesToFacesContext() {
        final String methodName = "addOpbMessagesToFacesContext()";
        
        logger.entering(CLASS_NAME, methodName);
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "facesContext", facesContext,
                "You need to be in a faces context to use this method");
        
        for (Object msg : getFacesMessagesAttribute()) {
            if (msg instanceof FacesMessage) {
                facesContext.addMessage(null, (FacesMessage) msg);
                
            } else {
                logger.logp(Level.WARNING, CLASS_NAME, methodName, 
                        "non-FacesMessage {0} found in facesMessages attribute", msg);
                
            }
            
        }

        OpbSessionHelper.getSession().getAttributes().remove("facesMessages");
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName, 
                    "removed the Opb session attribute \"facesMessages\"");
            
        try {
            OpbMessages messages = OpbSessionHelper.getInstance(
                    OpbMessages.class, CLASS_NAME);
            
            for (OpbMessage msg : messages.getSessionMessages()) {
                
                FacesMessage facesMsg = new FacesMessage();
                
                facesMsg.setDetail(msg.getMessageDetail());
                facesMsg.setSummary(msg.getMessageSummary());
                
                String level = msg.getMessageLevel();
                
                if (logger.isLoggable(Level.FINEST)) {
                    logger.logp(Level.FINEST, CLASS_NAME, methodName,
                            "Found message: level={0}, detail={1}, summary={2}",
                            new Object[]{level, msg.getMessageDetail(), 
                            msg.getMessageSummary()});
                }
                
                if (OpbMessages.MESSAGE_LEVEL_DEBUG.equals(level)) {
                    facesMsg.setSeverity(FacesMessage.SEVERITY_INFO);
                    facesMsg.setSummary("DEBUG: " + msg.getMessageSummary());
                        
                } else if (OpbMessages.MESSAGE_LEVEL_ERROR.equals(level)) {
                    facesMsg.setSeverity(FacesMessage.SEVERITY_ERROR);
                        
                } else if (OpbMessages.MESSAGE_LEVEL_FATAL.equals(level)) {
                    facesMsg.setSeverity(FacesMessage.SEVERITY_FATAL);
                    
                } else if (OpbMessages.MESSAGE_LEVEL_INFO.equals(level)) {
                    facesMsg.setSeverity(FacesMessage.SEVERITY_INFO);
                        
                } else if (OpbMessages.MESSAGE_LEVEL_WARNING.equals(level)) {
                    facesMsg.setSeverity(FacesMessage.SEVERITY_WARN);
                    
                } else {
                    logger.logp(Level.SEVERE, CLASS_NAME, methodName, 
                            "Failed to get session messages. Unknown level '{0}'", level);
                    facesMsg.setSeverity(FacesMessage.SEVERITY_ERROR);
                    
                }
                
                facesContext.addMessage(null, facesMsg);
                
            }
            
        } catch (RuntimeException ex) {
            throw ex;
            
        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new RuntimeException("Failed to get session messages", ex),
                    logger, CLASS_NAME, methodName);
            
        }
        
    } // End of addOpbMessagesToFacesContext()

    /**
     * Save a faces error message in the Opb session.
     * 
     * @param detail The detailed message string.
     * @param summary The summarised message string.
     */
    @SuppressWarnings(value = "unchecked")
    public void saveErrorMessage(final String detail, final String summary) {
        final String methodName = "saveErrorMessage(String, String)";
        
        logger.entering(CLASS_NAME, methodName);
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName, 
                "detail={0}, summary={1}", new Object[]{detail, summary});
            
        // this causes a compiler warning - which can be safely ignored
        getFacesMessagesAttribute().add(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, detail, summary));
        
    }
    
    /**
     * Returns the Opb session attribute "facesMessages" wich should be a list of 
     * faces messages.
     * @return The Opb session attribute "facesMessages".
     */
    private List getFacesMessagesAttribute() {
        final String methodName = "getFacesMessagesAttribute()";
        
        logger.entering(CLASS_NAME, methodName);
        
        List result = null;
        
        try {
            result = (List) OpbSessionHelper.getAttribute("facesMessages");

        } catch (Exception ex) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName, 
                    "facesMessages attribute was not a List", ex);
            
        }
        
        // if result is null, we need to create a new list and save it in the session
        if (result == null) {            
            logger.logp(Level.FINEST, CLASS_NAME, methodName, 
                    "creating new faces message list");
            result = new ArrayList();
            OpbSessionHelper.putAttribute("facesMessages", result);

        }
        
        return result;
        
    } // End of getFacesMessagesAttribute()
    
}
