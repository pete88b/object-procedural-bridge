package com.butterfill.opb.webdemo.backing;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import static com.butterfill.opb.webdemo.JsfHelper.*;

/**
 *
 * @author butterp
 */
public class JavaLoggingAdmin {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = JavaLoggingAdmin.class.getName();
    
    /**
     * The logger of this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);
    
    /**
     * All loggers that this instance knows of.
     */
    private final List<LoggerWrapper> knownLoggers =
            new ArrayList<LoggerWrapper>();
    
    /**
     * Name of the current working logger.
     */
    private String workingLoggerName = "";
    
    /**
     * New level for the current working logger.
     */
    private String workingLoggerNewLevel = "";
    
    /**
     * Set of all possible logger levels 
     * (as select items for use in a select one JSF component).
     */
    private final SelectItem[] levels = new SelectItem[10];
    
    
    /** 
     * Creates a new instance of JavaLoggingAdmin.
     */
    public JavaLoggingAdmin() {
        final String methodName = "JavaLoggingAdmin()";
        
        logger.entering(CLASS_NAME, methodName);
        
        // load the array of logger levels
        levels[0] = new SelectItem("");
        levels[1] = new SelectItem("ALL");
        levels[2] = new SelectItem("OFF");
        levels[3] = new SelectItem("SEVERE");
        levels[4] = new SelectItem("WARNING");
        levels[5] = new SelectItem("INFO");
        levels[6] = new SelectItem("CONFIG");
        levels[7] = new SelectItem("FINE");
        levels[8] = new SelectItem("FINER");
        levels[9] = new SelectItem("FINEST");
        
        // add some loggers that we already know about
        knownLoggers.add(
                new LoggerWrapper(Logger.getLogger("")));
        knownLoggers.add(
                new LoggerWrapper(Logger.getLogger("com.butterfill")));
        knownLoggers.add(
                new LoggerWrapper(Logger.getLogger("com.butterfill.opb")));
        knownLoggers.add(
                new LoggerWrapper(Logger.getLogger("com.butterfill.opb.webdemo")));
        
    }
    
    /**
     * Returns all possible levels that could be assigned to a logger.
     * @return All possible levels that could be assigned to a logger.
     */
    public SelectItem[] getLevels() {
        final String methodName = "getLevels()";
        
        logger.entering(CLASS_NAME, methodName);
        
        return levels;
    }

    /**
     * Returns all loggers that this instance knows of.
     * @return All loggers that this instance knows of.
     */
    public List<LoggerWrapper> getKnownLoggers() {
        final String methodName = "getKnownLoggers()";
        
        logger.entering(CLASS_NAME, methodName);
        
        return knownLoggers;
    }

    /**
     * Returns the name of the current working logger.
     * @return The name of the current working logger.
     */
    public String getWorkingLoggerName() {
        return workingLoggerName;
    }

    /**
     * Sets the name of the current working logger.
     * @param workingLoggerName The name of the current working logger.
     */
    public void setWorkingLoggerName(String workingLoggerName) {
        this.workingLoggerName = workingLoggerName;
    }

    /**
     * Returns the level of the current working logger.
     * @return The level of the current working logger.
     */
    public String getWorkingLoggerCurrentLevel() {
        Level level = Logger.getLogger(workingLoggerName).getLevel();
        return (level == null) ? "" : level.getName();
    }

    /**
     * Returns the new level of the current working logger.
     * The level of the working logger will be set to this level when 
     * updateWorkingLoggerLevel() is called.
     * @return The new level of the current working logger.
     */
    public String getWorkingLoggerNewLevel() {
        return workingLoggerNewLevel;
    }

    /**
     * Sets the new level of the current working logger.
     * The level of the working logger will be set to this level when 
     * updateWorkingLoggerLevel() is called.
     * @param workingLoggerNewLevel A new level for the current working logger.
     */
    public void setWorkingLoggerNewLevel(String workingLoggerNewLevel) {
        this.workingLoggerNewLevel = workingLoggerNewLevel;
    }

    /**
     * Sets the level of the current working logger to it's new level.
     * @return null.
     */
    public String updateWorkingLoggerLevel() {
        // get the current working logger
        Logger workingLogger = Logger.getLogger(workingLoggerName);
        // update it's level
        updateLevel(workingLogger, workingLoggerNewLevel);
        // add it to the list of known levels (if it's not already in)
        for (LoggerWrapper wrapper : knownLoggers) {
            if (wrapper.getName().equals(workingLoggerName)) {
                // don't add the logger if it's already in
                return null;
            }
        }
        knownLoggers.add(new LoggerWrapper(workingLogger));
        facesInfoMessage(
                "Logger '" + workingLogger.getName() + 
                "' added to known loggers list", null);
        return null;
    }

    /**
     * Updates the level of this specified logger.
     * @param lggr The logger whos level should be updated.
     * @param level The level to set on the specified logger.
     */
    private static void updateLevel(Logger lggr, String level) {
        if ("".equals(level)) {
            lggr.setLevel(null);
            facesInfoMessage(
                    "Level of '" + lggr.getName() + "' set to null", null);
        } else {
            lggr.setLevel(Level.parse(level));
            facesInfoMessage(
                    "Level of '" + lggr.getName() + "' set to " + level, null);
        }
    }
    
    /**
     * Simple wrapper class for a java.util.logging.Logger which gives JSF
     * access to it's name and level.
     */
    public static class LoggerWrapper {
        /**
         * The logger being wrapped.
         */
        private Logger wrappedLogger;
        
        /**
         * The level of the wrapped logger as a string.
         */
        private String levelAsString = "";

        /**
         * Creates a new wrapper for the specified logger.
         * @param logger The logger to be wrapped.
         */
        public LoggerWrapper(Logger logger) {
            this.wrappedLogger = logger;
        }

        /**
         * Returns the name of the wrapped logger.
         * @return The name of the wrapped logger.
         */
        public String getName() {
            return wrappedLogger.getName();
        }

        /**
         * Returns the level of the wrapped logger as a string.
         * @return The level of the wrapped logger.
         */
        public String getLevel() {
            Level level = wrappedLogger.getLevel();
            levelAsString = (level == null) ? "" : level.getName();
            return levelAsString;
        }

        /**
         * Saves a new level for the wrapped logger. This level will be set on
         * the wrapped logger when updateLevel() is called.
         * @param value A new level for the wrapped logger.
         */
        public void setLevel(String value) {
            levelAsString = value;
        }

        /**
         * Sets the level of the wrapped logger to the value returned by 
         * getLevel().
         * @return null
         */
        public String updateLevel() {
            JavaLoggingAdmin.updateLevel(wrappedLogger, levelAsString);
            return null;
        }
        
    } // End of class LoggerWrapper

} // End of class JavaLoggingAdmin
