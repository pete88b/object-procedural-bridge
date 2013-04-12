/**
 * Copyright (C) 2008 Peter Butterfill.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.butterfill.opb.timing;

import com.butterfill.opb.util.OpbToStringHelper;
import com.butterfill.opb.util.OpbExactMatchList;
import java.util.List;
import java.util.logging.Logger;

/**
 * A basic timing event listener.
 * <br/>
 * This listener will return all completed events via getCompletedEvents().
 *
 * @author Peter Butterfill
 */
public class OpbBasicTimingEventListener implements OpbTimingEventListener {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbBasicTimingEventListener.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * A list of timing events that are complete.
     */
    private List<OpbTimingEvent> completed =
            new OpbExactMatchList<OpbTimingEvent>();

    /**
     * Creates a new instance of OpbBasicTimingEventListener.
     */
    public OpbBasicTimingEventListener() {
        logger.entering(CLASS_NAME, "OpbBasicTimingEventListener()");

    } // End of OpbBasicTimingEventListener()

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbBasicTimingEventListener.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Saves the specified timing event as complete.
     * <br/>
     * Adding the same event twice will cause it to appear twice in the list returned by
     * <code>getCompletedEvents()</code>.
     *
     * @param event
     *   A complete timing event. 
     *   i.e. One that has a name, a start time and an end time.
     *   If event is null, this is a no-op.
     */
    public synchronized void timingEventComplete(final OpbTimingEvent event) {
        final String methodName = "timingEventComplete(OpbTimingEvent)";

        logger.entering(CLASS_NAME, methodName);

        if (event != null) {
            completed.add(event);

        }

    }

    /**
     * Returns all completed events received by this listener and
     * clears all completed events that have been saved by this listener.
     * <br/>
     * This method will not return the same instance twice.
     *
     * @return All completed events received by this listener.
     */
    public synchronized List<OpbTimingEvent> getCompletedEvents() {
        final String methodName = "getCompletedEvents()";

        logger.entering(CLASS_NAME, methodName);

        final List<OpbTimingEvent> result = completed;

        completed = new OpbExactMatchList<OpbTimingEvent>();

        return result;

    }

    /**
     * Clears all completed events that have been saved by this listener.
     */
    public synchronized void clearCompletedEvents() {
        final String methodName = "clearCompletedEvents()";

        logger.entering(CLASS_NAME, methodName);

        completed.clear();
        
    }

} // End of class OpbBasicTimingEventListener
