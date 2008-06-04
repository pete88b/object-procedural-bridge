// TODO: remove if not used

package com.butterfill.opb.web.faces;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author butterp
 */
public class FacesPhaseHelper implements PhaseListener {
    
    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = 
            FacesPhaseHelper.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    private static ThreadLocal<PhaseId> threadLocal = 
            new ThreadLocal<PhaseId>();
    
    /** 
     * Creates a new instance of FacesPhaseHelper.
     */
    public FacesPhaseHelper() {
        logger.entering(CLASS_NAME, "FacesPhaseHelper()");
    }

    public void afterPhase(PhaseEvent event) {
        final String methodName = "afterPhase(PhaseEvent)";
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName, "{0}", event.getPhaseId());
        
        threadLocal.remove();
    }

    public void beforePhase(PhaseEvent event) {
        final String methodName = "beforePhase(PhaseEvent)";
        
        logger.logp(Level.FINEST, CLASS_NAME, methodName, "{0}", event.getPhaseId());
        
        threadLocal.set(event.getPhaseId());
    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
    public static PhaseId getCurrentPhaseId() {
        return threadLocal.get();
    }

} // End of class FacesPhaseHelper