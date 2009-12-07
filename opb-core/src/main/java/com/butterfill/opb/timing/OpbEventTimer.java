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
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The hub for timing events.
 * <br/>
 * In this comment, publisher means an OpbTimingEventPublisher and
 * listener means OpbTimingEventListener.
 * <br/>
 * Objects that want to publish timing events implement OpbTimingEventPublisher.
 * Publishers call start(String) at the start of an event that may  need to be
 * timed saving the OpbTimingEvent returned.
 * Publishers call end(OpbTimingEvent) at the end of the event passing back in
 * the OpbTimingEvent returned by the start method.
 * <br/>
 * Objects that want to monitor timing events implement
 * OpbTimingEventListener and register with an OpbEventTimer by
 * calling addTimingEventListener(OpbTimingEventListener).
 * The OpbEventTimer calls timingEventComplete(OpbTimingEvent) on all
 * registered listeners when a publisher calls end(OpbTimingEvent)
 * on the OpbEventTimer as long as the OpbTimingEvent is not null.
 *
 * @author Peter Butterfill
 */
public class OpbEventTimer {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbEventTimer.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * The timing event listeners registered with this event timer.
     * Note: This is a set so that listeners cannot be added more than
     * once.
     */
    private final Collection<OpbTimingEventListener> timingEventListeners =
            new HashSet<OpbTimingEventListener>();

    /**
     * Creates a new instance of OpbEventTimer.
     */
    public OpbEventTimer() {
        logger.entering(CLASS_NAME, "OpbEventTimer()");

    } // End of OpbEventTimer()

    /**
     * Returns a String representation of this OpbEventTimer and it's values.
     * @return String representation of this OpbEventTimer.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Registers a timing event listener.
     * Note: If listener has already been added, this is a no-op.
     *
     * @param listener A timing event listener.
     * @throws NullPointerException
     *   If listener is null.
     */
    public void addTimingEventListener(final OpbTimingEventListener listener)
            throws NullPointerException {
        final String methodName = 
                "addTimingEventListener(OpbTimingEventListener)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(
                logger, CLASS_NAME, methodName, "listener", listener);

        timingEventListeners.add(listener);

    }

    /**
     * Un-registers a timing event listener.
     * Note: If listener has not been added, this is a no-op.
     * @param listener The listener to be removed.
     */
    public void removeTimingEventListener(
            final OpbTimingEventListener listener) {
        final String methodName = 
                "removeTimingEventListener(OpbTimingEventListener)";

        logger.entering(CLASS_NAME, methodName);

        timingEventListeners.remove(listener);

    }

    /**
     * Un-registers all timing event listeners.
     */
    public void removeAllTimingEventListeners() {
        final String methodName = "removeAllTimingEventListeners()";

        logger.entering(CLASS_NAME, methodName);

        timingEventListeners.clear();

    }

    /**
     *
     * Returns a newley created timing event with the specified event name and a
     * start time set to the value returned by System.currentTimeMillis().
     * <br/>
     * Called by timing event publishers at the start of an event that
     * may need to be timed.
     * @param eventName The name of the event.
     * @return A newley created timing event .
     */
    public OpbTimingEvent start(final String eventName) {
        final String methodName = "start(String)";

        logger.entering(CLASS_NAME, methodName);

        return new OpbTimingEvent(eventName, System.currentTimeMillis());

    }

    /**
     * Sets the end time for the specified event to be the value returned by
     * System.currentTimeMillis() and calls timingEventComplete on all registed
     * listeners.
     * <br/>
     * Called by timing event publishers at the end of an event.
     * <br/>
     * If calling timingEventComplete on a registered listener raises an exception,
     * details of the exception will be logged and the listener will be removed
     * (so it doesn't have change to raise further exceptions).
     *
     * @param event
     *   A timing event returned by a previous call to start(String).
     * @see OpbTimingEventListener#timingEventComplete(OpbTimingEvent)
     */
    public void end(final OpbTimingEvent event) {
        final String methodName = "end(OpbTimingEvent)";

        logger.entering(CLASS_NAME, methodName);

        try {
            if (event == null) {
                logger.logp(Level.FINER, CLASS_NAME, methodName,
                        "event is null. returning");
                return;

            }

            event.setEndTime(System.currentTimeMillis());

            notifyListeners(event);

        } catch (Exception ex) {
            // don't let any exceptions propogate from this method
            logger.logp(Level.SEVERE, CLASS_NAME, methodName, "unexpected exception", ex);

        }

    }

    /**
     * Calls timingEventComplete on all registed listeners.
     * <br/>
     * This is a separate method, just to make end(OpbTimingEvent) easier to read.
     * 
     * @param event
     *   A timing event returned by a previous call to start(String).
     */
    private synchronized void notifyListeners(final OpbTimingEvent event) {
        final String methodName = "notifyListeners(OpbTimingEvent)";

        logger.entering(CLASS_NAME, methodName);

        for (Iterator<OpbTimingEventListener> i = timingEventListeners.iterator(); i.hasNext(); ) {
            try {
                // call timingEventComplete on the listener
                i.next().
                        timingEventComplete(event);

            } catch (Exception ex) {
                // if the listener raised any exception, remove it so we don't use it again
                // Note: this remove is why we have to synchronize this method
                i.remove();
                // log details of the exception (but don't let the exception propogate)
                logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                        "removed listener as it threw an exception", ex);

            }

        }

    }

} // End of class OpbEventTimer
