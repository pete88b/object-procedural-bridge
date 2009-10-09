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
import java.util.logging.Logger;

/**
 * Represents a timing event.
 * <br/>
 * Timing event publishers define what an event is.
 * A timing event could be a single action such as a database call.
 * A timing event could be any number of actions such as a users'
 * session, where the start time is captured when the user logs on
 * and the end time is captured when the user logs off.
 * <br/>
 * A timing event can be identified by it's publisher and event name.
 * Timing event publishers decide what the event name will be.
 * <br/>
 * The start and end times should both represent time relative to
 * the same baseline - so that the difference between the start time
 * and the end time is the duration of the event.
 * Note: Without knowing the baseline, the start and end time values
 * cannot be used to identify a specific instant in time.
 *
 * @author Peter Butterfill
 */
public class OpbTimingEvent {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbTimingEvent.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The name of the event.
     */
    private final String name;

    /**
     * The start time of the event in milli seconds.
     */
    private final long startTime;

    /**
     * The end time of the event in milli seconds.
     */
    private long endTime;


    /**
     * Creates a new instance of OpbTimingEvent setting the event name and start
     * time.
     * This is package private as no class other than OpbEventTimer should be
     * able to create a timing event.
     *
     * @param eventName The name of the event.
     * @param startTime The start time of the event.
     *
     * @see OpbEventTimer#start(String)
     */
    OpbTimingEvent(final String eventName, final long startTime) {
        final String methodName = "OpbTimingEvent(String, long)";

        logger.entering(CLASS_NAME, methodName);

        this.name = eventName;
        this.startTime = startTime;

    } // End of OpbTimingEvent()

    /**
     * Returns a String representation of this OpbTimingEvent and it's values.
     * @return String representation of this OpbTimingEvent.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns the name of this event.
     * Note: If the event name is null, an empty string is returned so that this
     * method never returns null.
     * @return The name of this event.
     */
    public String getEventName() {
        return (name == null) ? "" : name;
    }

    /**
     * Returns the start time of this event.
     * @return The start time of this event.
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Returns the end time of this event.
     * @return The end time of this event.
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Sets the end time of this event.
     * This is package private as no class other than OpbEventTimer should
     * set the end time of an event.
     *
     * @param endTime The end time of this event.
     *
     * @see OpbEventTimer#end(OpbTimingEvent)
     */
    void setEndTime(final long endTime) {
        this.endTime = endTime;
    }

} // End of class OpbTimingEvent
