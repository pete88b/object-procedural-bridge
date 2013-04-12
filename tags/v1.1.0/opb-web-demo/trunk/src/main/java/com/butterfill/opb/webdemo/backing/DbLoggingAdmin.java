
package com.butterfill.opb.webdemo.backing;

import com.butterfill.opb.data.OpbDynamicDataView;
import com.butterfill.opb.session.OpbSessionHelper;
import com.butterfill.opb.webdemo.data.LoggerAdmin;
import com.butterfill.opb.webdemo.data.LoggerFlag;
import java.util.logging.Logger;
import org.apache.myfaces.trinidad.event.DisclosureEvent;

/**
 *
 * @author butterp
 */
public class DbLoggingAdmin {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = DbLoggingAdmin.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Creates a new instance of a DbLoggingAdmin.
     */
    public DbLoggingAdmin() {
        logger.entering(CLASS_NAME, "DbLoggingAdmin()");
    }
    
    public boolean isRenderErrorBacktrace() {
        Object result = OpbSessionHelper.getAttribute(
                CLASS_NAME + "renderErrorBacktrace");
        return (result == null) ? false : (Boolean)result;
    }

    public void setRenderErrorBacktrace(boolean renderErrorBacktrace) {
        OpbSessionHelper.putAttribute(
                CLASS_NAME + "renderErrorBacktrace", renderErrorBacktrace);
    }

    public boolean isRenderCallStack() {
        Object result = OpbSessionHelper.getAttribute(
                CLASS_NAME + "renderCallStack");
        return (result == null) ? false : (Boolean)result;
    }

    public void setRenderCallStack(boolean renderCallStack) {
        OpbSessionHelper.putAttribute(
                CLASS_NAME + "renderCallStack", renderCallStack);
    }

    public LoggerAdmin getLoggingAdmin() {
        return OpbSessionHelper.getInstance(LoggerAdmin.class, CLASS_NAME);
    }

    public LoggerFlag getNewLoggerFlag() {
        return OpbSessionHelper.getInstance(LoggerFlag.class, CLASS_NAME);
    }

    public LoggerFlag[] getNewLoggerFlagAsArray() {
        return new LoggerFlag[]{getNewLoggerFlag()};
    }
    
    public String getDateFormatPattern() {
        String result = (String) OpbSessionHelper.getAttribute(
                "DbLoggingAdmin:DateFormatPattern");
        return (result != null) ? result : "HH:mm:ss";
    }

    public void setDateFormatPattern(String pattern) {
        OpbSessionHelper.putAttribute(
                "DbLoggingAdmin:DateFormatPattern", pattern);
    }

    /**
     * This method should be registered as the disclosureListener for all tabs.
     */
    public void tabDisclosed(DisclosureEvent event) {
        OpbSessionHelper.getDataObjectSource().clearCached(
                OpbDynamicDataView.class);
    }

}
