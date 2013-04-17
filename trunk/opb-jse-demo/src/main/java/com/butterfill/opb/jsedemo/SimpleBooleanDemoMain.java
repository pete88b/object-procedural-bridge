
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.jsedemo.data.BooleanDemo;
import com.butterfill.opb.session.OpbSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates the use of BooleanDemo (see {@link SimpleTranslationDemoMain})
 * using Spring for configuration.
 * <br/>
 * <b>Please refer to package.html for DB set-up details.</b>
 * <b>To run this demo;</b>
 * <ul>
 * <li>Run the main method of this class.</li>
 * </ul>
 */
public class SimpleBooleanDemoMain {

    /**
     * Gets a Boolean value from a PL/SQL function via the Opb generated
     * BooleanDemo class.
     *
     * @param args not used.
     */
    public static void main(String[] args) throws Exception {
        // create the spring context
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // register the shutdown hook so that the context will call destroy
        // methods
        context.registerShutdownHook();

        // get a new Opb session
        OpbSession session = (OpbSession) context.getBean("opbSession");

        // get an instance that implements the BooleanDemo interface
        BooleanDemo booleanDemo = session
                .getDataObjectSource()
                .getInstance(BooleanDemo.class, "");

        // call a method on the instance. This will make a PL/SQL call
        Boolean result = booleanDemo.getTrue();

        // verify that we got the result we expected
        if (!result) {
            throw new RuntimeException(
                    "BooleanDemo#getTrue() did not return true." +
                    "Actual result=" + result);
        }

        // Note: Spring will release the connection held by our session via the destroy-method

    }

}
