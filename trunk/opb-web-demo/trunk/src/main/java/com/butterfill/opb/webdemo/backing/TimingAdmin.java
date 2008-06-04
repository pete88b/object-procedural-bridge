
package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.timing.OpbBasicTimingEventListener;
import com.butterfill.opb.timing.OpbEventTimer;
import com.butterfill.opb.timing.OpbTimingEventAggregate;
import com.butterfill.opb.timing.OpbTimingEventAggregateHelper;
import com.butterfill.opb.webdemo.JsfHelper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author butterp
 */
public class TimingAdmin {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = TimingAdmin.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    /**
     * The timing listener to be used by this instance.
     */
    private final OpbBasicTimingEventListener listener =
            new OpbBasicTimingEventListener();
    
    /**
     * The timing aggregate helper to be used by this instance.
     */
    private OpbTimingEventAggregateHelper aggregateHelper =
            new OpbTimingEventAggregateHelper();
    
    private Boolean timingEnabled;
    
    private OpbEventTimer timer;
    
    private String contextName;
    
    private String contextDescription;

    /** 
     * Creates a new instance of TimingAdmin 
     */
    public TimingAdmin() {
        logger.entering(CLASS_NAME, "TimingAdmin()");
    }

    public void setOpbEventTimer(final OpbEventTimer timer) {
        this.timer = timer;
    }

    /**
     * @param contextName the contextName to set
     */
    public void setContextName(final String contextName) {
        this.contextName = contextName;
    }

    /**
     * @param contextDescription the contextDescription to set
     */
    public void setContextDescription(final String contextDescription) {
        this.contextDescription = contextDescription;
    }

    public Boolean getTimingEnabled() {
        return timingEnabled;
    }

    public void setTimingEnabled(final Boolean timingEnabled) {
        final String methodName = "setTimingEnabled(Boolean)";

        if (timer == null) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "Cannot setTimingEnabled. timer is null.");
            JsfHelper.facesWarningMessage(
                    "Failed to setTimingEnabled. TimingAdmin incorrectly configured",
                    "Timer is null");
            return;
        }

        this.timingEnabled = timingEnabled;

        if (timingEnabled) {
            timer.addTimingEventListener(listener);

        } else {
            timer.removeTimingEventListener(listener);

        }

    }

    public List<OpbTimingEventAggregate> getAggregates() {
        aggregateHelper.addEvents(listener.getCompletedEvents());
        listener.clearCompletedEvents();
        return aggregateHelper.getAggregates();

    }

    public String clearTimingEvents() {
        listener.clearCompletedEvents();
        aggregateHelper = new OpbTimingEventAggregateHelper();
        return null;

    }

    public String getTableHeader() {
        StringBuilder sb = new StringBuilder(
                "Timed events for context ");
        sb.append(contextName);
        sb.append(" (");
        sb.append(contextDescription);
        sb.append("). All durations in ms");
        return sb.toString();

    }
    
}
