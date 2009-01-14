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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Helps to produce timing aggregates from timing events.
 *
 * @see OpbTimingEventAggregate
 * @author Peter Butterfill
 */
public class OpbTimingEventAggregateHelper {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME =
            OpbTimingEventAggregateHelper.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The map of aggregates created by adding events to this helper.
     */
    private final Map<String, OpbTimingEventAggregate> aggregateMap =
                new HashMap<String, OpbTimingEventAggregate>();

    /**
     * Creates a new instance of OpbTimingEventAggregateHelper.
     */
    public OpbTimingEventAggregateHelper() {
        logger.entering("OpbTimingEventAggregateHelper",
                "OpbTimingEventAggregateHelper()");

    } // End of OpbTimingEventAggregateHelper()

    /**
     * Returns a String representation of this OpbTimingEventAggregateHelper
     * and it's values.
     * @return String representation of this OpbTimingEventAggregateHelper.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Adds an event to this helper. Events added here will be included in the
     * aggregates returned by getAggregates().
     *
     * @param event
     *   The event to add to this helper.
     * @throws NullPointerException
     *   If event is null.
     */
    public void addEvent(final OpbTimingEvent event)
            throws NullPointerException {
        final String methodName = "addEvent(OpbTimingEvent)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, "event", event);

        if (!aggregateMap.containsKey(event.getEventName())) {
            aggregateMap.put(
                    event.getEventName(),
                    new OpbTimingEventAggregate());
        }

        aggregateMap.get(event.getEventName()).addEvent(event);

    }

    /**
     * Adds a list of events to this helper. Events added here will be included
     * in the aggregates returned by getAggregates().
     *
     * @param events
     *   The events to add to this helper.
     * @throws NullPointerException
     *   If events is null.
     */
    public void addEvents(final List<OpbTimingEvent> events)
            throws NullPointerException {
        final String methodName = "addEvents(List<OpbTimingEvent>)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, "events", events);

        for (OpbTimingEvent event : events) {
            addEvent(event);
        }

    }

    /**
     * Returns a list containing one timing aggregate for each event name
     * passed to addEvent(OpbTimingEvent) or addEvents(List).
     * Note: Changes made to the aggregates in the list returned will change
     * the aggregates held by this helper.
     * @return The aggregates of this helper.
     */
    public List<OpbTimingEventAggregate> getAggregates() {
        logger.entering(CLASS_NAME, "getAggregates()");

        return new ArrayList<OpbTimingEventAggregate>(aggregateMap.values());

    }

} // End of class OpbTimingEventAggregateHelper
