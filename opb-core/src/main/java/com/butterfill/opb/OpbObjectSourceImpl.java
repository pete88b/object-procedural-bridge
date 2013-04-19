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


package com.butterfill.opb;

import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbExceptionHelper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The default object source for Opb code.
 *
 * @author Peter Butterfill
 */
public class OpbObjectSourceImpl implements OpbObjectSource {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbObjectSourceImpl.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * Returns a new instance of the specified class.
     * <br/>
     * This method will try to return one of two possible concrete
     * implementations of interfaceOfInstance.
     * <br/>
     * The class returned will have the same name as the interface with 'Impl'
     * appended.
     * The class returned will be in either the same package as the interface or
     * in a sub-package called ext.
     * Classes found in the ext package will be used in preference to classes
     * found in the same package as the interface.
     * <br/>
     * e.g.
     * If interfaceOfInstance specifies a class named
     * com.butterfill.opb.plsql.messages.OpbMessages, we first look for
     * com.butterfill.opb.plsql.messages.<b>ext</b>.OpbMessages<b>Impl</b>
     * (the ext implementation).
     * If the ext implementation cannot be found, we look for
     * com.butterfill.opb.plsql.messages.OpbMessages<b>Impl</b>.
     *
     * @param <T>
     *   The type of object to return.
     * @param interfaceOfInstance
     *   The type of object to return.
     * @return
     *   A new instance of the specified class.
     * @throws com.butterfill.opb.OpbException
     *   If we can't create the new instance.
     */
    @SuppressWarnings("unchecked")
    public <T> T newInstance(final Class<T> interfaceOfInstance)
            throws OpbException {
        final String methodName = "newInstance(Class)";

        logger.entering(CLASS_NAME, methodName);

        // callers should make sure the input in not null but check it anyway
        OpbAssert.notNull(logger, CLASS_NAME, methodName,
                "interfaceOfInstance", interfaceOfInstance);

        String interfaceName = interfaceOfInstance.getName();
        String packageName;
        String simpleInterfaceName;

        int lastDotPos = interfaceName.lastIndexOf(".");

        if (lastDotPos == -1) {
            packageName = "";
            simpleInterfaceName = interfaceName;

        } else {
            packageName =
                    interfaceName.substring(0, lastDotPos + 1);
            simpleInterfaceName =
                    interfaceName.substring(lastDotPos + 1);

        }

        String className = null;
        T result = null;

        try {
            // Create the name of the class that implements the requested type
            className = packageName + "ext." + simpleInterfaceName + "Impl";

            Class dataObjectClass;

            // Get the class of object that we will return
            try {
                logger.logp(Level.FINEST, CLASS_NAME, methodName,
                        "trying to get class {0}", className);

                dataObjectClass = Class.forName(className);

            } catch (ClassNotFoundException ex) {
                className = packageName + simpleInterfaceName + "Impl";

                logger.logp(Level.FINEST, CLASS_NAME, methodName,
                        "ext class not found. trying to get class {0}",
                        className);

                dataObjectClass = Class.forName(className);

            }

            logger.logp(Level.FINEST, CLASS_NAME, methodName,
                    "creating instance of {0} which should implement {1}",
                    new Object[] {className, interfaceName});

            // create an instance of the class.
            // Note: This line will not throw a class cast exception.
            // Note: This line will create an unchecked warning. The following
            // isInstance check ensures that the object created will implement
            // the requested type - so it's ok to suppress the warning.
            result = (T) dataObjectClass.newInstance();

        } catch (ClassNotFoundException ex) {
            OpbExceptionHelper.throwException(
                    new OpbException(
                    "failed to create new instance of a " + className
                    + " which should implement " + interfaceName
                    + ". Class not found: " + className),
                    logger, CLASS_NAME, methodName);

        } catch (Exception ex) {
            OpbExceptionHelper.throwException(
                    new OpbException(
                    "failed to create new instance of a " + className
                    + " which should implement " + interfaceName, ex),
                    logger, CLASS_NAME, methodName);

        }

        // Check thst the object created implements the requested interface
        if (!interfaceOfInstance.isInstance(result)) {
            OpbExceptionHelper.throwException(
                    new OpbException(
                    "failed to create new instance of a " + className
                    + ". It does not implement " + interfaceName),
                    logger, CLASS_NAME, methodName);
        }

        return result;

    } // End of newInstance(Class)

}
