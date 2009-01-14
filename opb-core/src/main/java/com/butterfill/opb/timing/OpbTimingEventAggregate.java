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

import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.logging.Logger;

/**
 * Combines the data of timing events.
 * <br/>
 * The event name of this aggregate is taken from the name of the first
 * event added. <em>All other events added must have the same name.</em>
 *
 * @author Peter Butterfill
 */
public class OpbTimingEventAggregate {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbTimingEventAggregate.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The event name for this aggregate.
     */
    private String eventName;

    /**
     * The number of events added to this aggregate.
     */
    private int eventCount;

    /**
     * The sum of all events addeed to this aggregate.
     */
    private long totalEventDuration;

    /**
     * The minimum duration of all events added to this aggregate.
     */
    private long minimumEventDuration;

    /**
     * The maximum duration of all events added to this aggregate.
     */
    private long maximumEventDuration;


    /**
     * Creates a new instance of OpbTimingEventAggregate.
     */
    public OpbTimingEventAggregate() {
        logger.entering(CLASS_NAME, "OpbTimingEventAggregate()");

    }

    /**
     * Returns a String representation of this instance and it's values.
     * @return String representation of this OpbTimingEventAggregate.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Adds an event to this aggregate.
     * <br/>
     * This will;
     * <ul>
     *   <li>Increment the event count</li>
     *   <li>Add this events duration to the total event duration</li>
     *   <li>Set the minimum event duration, if this is the first event to be
     *       added, or the duration of this event is less than the current
     *       minimum event duration</li>
     *   <li>Set the maximum event duration, if this is the first event to be
     *       added, or the duration of this event is greater than the current
     *       maximum event duration</li>
     *   <li>If this is the first event to be added, sets the event name for
     *       this aggregate</li>
     * </ul>
     *
     * @param event
     *   The event to be added to this aggregate.
     * @throws IllegalArgumentException
     *   If the event name of event is not the same as this event name.
     */
    public void addEvent(final OpbTimingEvent event) 
            throws IllegalArgumentException {
        final String methodName = "addEvent(OpbTimingEvent)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, "event", event);

        // calculate the duration of the event
        long eventDuration = event.getEndTime() - event.getStartTime();

        if (eventCount == 0) {
            // if this is the first event added to this aggregate,
            // save the event name - checking that the name is not null
            OpbAssert.notNull(
                    logger,
                    CLASS_NAME,
                    methodName,
                    "event.getEventName()",
                    event.getEventName());

            eventName = event.getEventName();

            // and same the min/max duration
            minimumEventDuration = eventDuration;
            maximumEventDuration = eventDuration;

        } else {
            OpbAssert.isEqual(
                logger, CLASS_NAME, methodName, "this.eventName", eventName,
                "event.getEventName()", event.getEventName(),
                "You can't add events with different names to an aggregate");

            if (eventDuration < minimumEventDuration) {
                minimumEventDuration = eventDuration;

            } else if (eventDuration > maximumEventDuration) {
                maximumEventDuration = eventDuration;

            }

        }

        eventCount++;
        totalEventDuration += eventDuration;

    }

    /**
     * Returns the event name of this aggregate.
     * @return The event name of this aggregate.
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * returnes the number of events added to this aggregate.
     * @return The number of events added to this aggregate.
     */
    public int getEventCount() {
        return eventCount;
    }

    /**
     * returnes the sum of all events addeed to this aggregate.
     * @return The sum of all events addeed to this aggregate.
     */
    public long getTotalEventDuration() {
        return totalEventDuration;
    }

    /**
     * Returns the minimum duration of all events added to this aggregate.
     * @return The minimum duration of all events added to this aggregate.
     */
    public long getMinimumEventDuration() {
        return minimumEventDuration;
    }

    /**
     * Returns the maximum duration of all events added to this aggregate.
     * @return The maximum duration of all events added to this aggregate.
     */
    public long getMaximumEventDuration() {
        return maximumEventDuration;
    }

    /**
     * Returns the average duration of all events added to this aggregate.
     * @return The average duration of all events added to this aggregate.
     */
    public long getAverageEventDuration() {
        return totalEventDuration / eventCount;
    }

} // End of class OpbTimingEventAggregate
