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

/**
 * Defines methods to be impemented by classes that want to register
 * with an OpbEventTimer to receive timing events.
 *
 * @see OpbEventTimer
 * @author Peter Butterfill
 */
public interface OpbTimingEventListener {

    /**
     * Called at the end of an event.
     *
     * @param event
     *   A complete timing event. i.e. One that has ended.
     */
    void timingEventComplete(OpbTimingEvent event);

}
