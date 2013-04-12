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
 * Defines methods to be impemented by classes that want to publish
 * timing events via an OpbEventTimer.
 *
 * @author Peter Butterfill
 * @see OpbEventTimer
 */
public interface OpbTimingEventPublisher {

    /**
     * Sets the OpbEventTimerProvider through which an OpbEventTimer can be
     * obtained. The OpbEventTimer can be used to publish timing events.
     * @param provider
     *   An event timer provider.
     */
    void setOpbEventTimerProvider(OpbEventTimerProvider provider);

}
