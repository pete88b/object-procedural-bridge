/*
 */
package com.butterfill.opb;

import junit.framework.TestCase;

/**
 *
 * @author Butterp
 */
public class OpbConstantsTest extends TestCase {

    public OpbConstantsTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testConstants() {
        assertEquals("VARCHAR", OpbConstants.DEFAULT_DATATYPE);
        assertEquals("com.butterfill.opb.data.OpbDynamicDataView", OpbConstants.DEFAULT_ENTITY);
        assertEquals("com.butterfill.opb.util.OpbValueWrapper", OpbConstants.DEFAULT_VALUE_WRAPPER);
    }
}
