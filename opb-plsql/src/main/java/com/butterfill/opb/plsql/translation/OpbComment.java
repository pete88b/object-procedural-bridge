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

package com.butterfill.opb.plsql.translation;


import com.butterfill.opb.util.OpbAssert;
import com.butterfill.opb.util.OpbToStringHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an Opb comment.
 * This class can be used to parse Opb comments and apply Opb comment elements
 * to an object.
 *
 * @author Peter Butterfill
 */
class OpbComment {

    /**
     * The name of this class.
     */
    public static final String CLASS_NAME = OpbComment.class.getName();

    /**
     * The logger for this class.
     */
    private static final Logger logger = Logger.getLogger(CLASS_NAME);

    /**
     * This is used as the key in map's of the opb comment to save the
     * element type. All other keys are lower cased so this name will never
     * clash.
     */
    public static final String OPB_COMMENT_ELEMENT_TYPE_KEY = "ELEMENT_TYPE";

    /**
     * The type of opb comment found.
     */
    private String opbCommentType;

    /**
     * The opb comment elements of this comment.
     */
    private List<Map<String, String>> opbCommentElements =
            new ArrayList<Map<String, String>>();

    /**
     * Creates a new comment using the specified string.
     * @param comment A complete multi-line comment including /* and &#42;/.
     * @throws NullPointerException If comment is null.
     */
    public OpbComment(final String comment) throws NullPointerException {
        final String methodName = "OpbComment(String)";

        logger.entering(CLASS_NAME, methodName);

        logger.logp(Level.FINEST, CLASS_NAME, methodName, "comment={0}", comment);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, "comment", comment);

        // try to determine Opb comment type - if not possible, we're done
        if (comment.startsWith("/*opb-package")) {
            opbCommentType = "opb-package";

        } else if (comment.startsWith("/*opb")) {
            opbCommentType = "opb";

        } else {
            logger.logp(Level.FINEST, CLASS_NAME, methodName,
                    "Opb comment type not found. Cannot parse {0}", comment);
            return;

        }

        logger.logp(Level.FINER, CLASS_NAME, methodName,
                "Opb comment type={0}", opbCommentType);

        // if we can't find both a line separator
        int firstLineBreak = comment.indexOf("\n");
        if (firstLineBreak == -1) {
            firstLineBreak = comment.indexOf("\r");
        }

        // and a semi-colon,
        int lastIndexOfSemi = comment.lastIndexOf(";");

        // this comment contains no elements
        if (firstLineBreak == -1 || lastIndexOfSemi == -1) {
            logger.logp(Level.INFO, CLASS_NAME, methodName,
                    "Opb comment contained no elements {0}", comment);
            return;
        }

        // check for invalid text on the first line
        String firstLine = comment.substring(2, firstLineBreak).trim();

        if (!opbCommentType.equals(firstLine)) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "Found invalid text after Opb comment type. {0}",
                    firstLine);
        }

        // remove the first line of the input string
        // remove the last ; and anything that follows
        String commentContents = comment.substring(firstLineBreak, lastIndexOfSemi);

        logger.logp(Level.FINEST, CLASS_NAME, methodName,
                "about to parse commentContents={0}", commentContents);

        String[] elements = commentContents.split(";");

        for (int i = 0; i < elements.length; i++) {
            String element = elements[i].trim();

            // if it's a comment (within the comment we're parsing), ignore it
            if (element.startsWith("--")) {
                continue;
            }

            String[] lines = element.split("(\\r\\n|\\n|\\r)");

            if (lines.length < 2) {
                logger.logp(Level.WARNING, CLASS_NAME, methodName,
                        "{0}{1}{2}", new Object[]{
                        "Opb comment elements must have at least 2 lines. ",
                        "Ignoring element ", element});
                continue;
            }

            Map<String, String> elementMap = new HashMap<String, String>();
            opbCommentElements.add(elementMap);

            elementMap.put(OPB_COMMENT_ELEMENT_TYPE_KEY, lines[0].trim());

            for (int j = 1; j < lines.length; j++) {
                String[] keyAndValue = lines[j].split("=");
                // If we don't have a key and a value, warn the user and
                // ignore this line
                if (keyAndValue.length != 2) {
                    logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                            "{0}{1}{2}{3}", new Object[]{
                            "Invalid line in an element of an opb comment. ",
                            lines[j], ". Expecting key=value. Line ignored. ",
                            elements[i]});
                    continue;
                }

                elementMap.put(
                        keyAndValue[0].trim().toLowerCase(),
                        keyAndValue[1].trim());

            }

            logger.logp(Level.FINEST, CLASS_NAME, methodName,
                    "parsed element={0}", elementMap);

        } // End of for (int i = 0; i < elements.length; i++)

    } // End of OpbComment(String)


    /**
     * Returns a string representation of this instance and it's values.
     * @return A string representation of this OpbComment and it's values.
     */
    @Override
    public String toString() {
        return OpbToStringHelper.toString(this);
    }

    /**
     * Returns true if this is an Opb package comment, false otherwise.
     * @return true if this is an Opb package comment, false otherwise.
     */
    public boolean isOpbPackage() {
        return "opb-package".equals(opbCommentType);
    }

    /**
     * Returns true if this is a Opb comment, false otherwise.
     * @return true if this is a Opb comment, false otherwise.
     */
    public boolean isOpb() {
        return "opb".equals(opbCommentType);
    }

    /**
     * Returns the elements of this comment.
     * @return The elements of this comment.
     */
    public List<Map<String, String>> getElements() {
        return opbCommentElements;
    }

    /**
     * Logs a message if the type of any elements of this comment are not in the
     * specified set of types.
     * @param types All valid element types for this comment.
     * @throws NullPointerException If types is null.
     */
    public void checkElementTypes(final String... types) throws NullPointerException {
        final String methodName = "checkElementTypes(String...)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, "types", types);

        List<String> typesList = new ArrayList<String>();

        for (String type : types) {
            typesList.add(type);
        }

        for (Map<String, String> element : opbCommentElements) {
            String t = element.get(OPB_COMMENT_ELEMENT_TYPE_KEY);
            if (!typesList.contains(t)) {
                // if it's not a known element type we need to warn the user
                StringBuilder sb = new StringBuilder(
                        "Found opb comment element of type ");
                sb.append(t);
                sb.append(" in ");
                sb.append(opbCommentType);
                sb.append(" comment. Expecting ");
                sb.append(typesList);

                logger.logp(Level.SEVERE, CLASS_NAME, methodName, sb.toString());

            }

        }

    } // End of checkElementTypes(String...)

    /**
     * Applies element properties to the target object.
     * <br/>
     * For every property in the map (except for the property keyed by
     * OPB_COMMENT_ELEMENT_TYPE_KEY) this method will call a method on the
     * target object passing the property value. The method on the target
     * object will have this signature opb_&lt;property key>(String).
     * <br/>
     * After applying all properties, opb_applyElementComplete() will be called
     * on the target object.
     *
     * @param element An Opb comment element.
     * @param target The object on which properties should be set.
     * @throws NullPointerException If either element or target are null.
     */
    public void applyElement(final Map<String, String> element, final Object target)
            throws NullPointerException {

        final String methodName = "applyElement(Map<String, String>, Object)";

        logger.entering(CLASS_NAME, methodName);

        OpbAssert.notNull(logger, CLASS_NAME, methodName, "element", element);
        OpbAssert.notNull(logger, CLASS_NAME, methodName, "target", target);

        if (element.size() == 0) {
            logger.logp(Level.WARNING, CLASS_NAME, methodName,
                    "element has no properties");
        }

        Class targetClass = target.getClass();

        // try to set properties on the target class
        for (String key : element.keySet()) {
            if (OPB_COMMENT_ELEMENT_TYPE_KEY.equals(key)) {
                continue;
            }

            try {
                Method m = targetClass.getMethod("opb_" + key, String.class);
                m.invoke(target, element.get(key));

            } catch (NoSuchMethodException ex) {
                logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                        "Property {0}{1}{2}{3}{4}. element={5}", new Object[]{
                        key, " for Opb comment element of type ",
                        element.get(OPB_COMMENT_ELEMENT_TYPE_KEY),
                        ". cannot be applied to ",
                        targetClass.getSimpleName(), element});

            } catch (Exception ex) {
                logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                        "Failed to call opb_" + key + " on an instance of "
                        + targetClass.getName(), ex);

            }

        }

        try {
            Method m = targetClass.getMethod("opb_applyElementComplete");
            m.invoke(target);

        } catch (NoSuchMethodException ex) {
            // it's ok if the target does not want the call back
            logger.logp(Level.FINEST, CLASS_NAME, methodName,
                    "target has no opb_applyElementComplete method for callback", ex);

        } catch (Exception ex) {
            logger.logp(Level.SEVERE, CLASS_NAME, methodName,
                    "callback opb_applyElementComplete failed", ex);

        }

    } // End of applyElement(Map<String, String>, Object)

}
