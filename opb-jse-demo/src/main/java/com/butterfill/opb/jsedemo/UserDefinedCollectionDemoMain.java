
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.jsedemo.data.UserDefinedCollectionDemo;
import com.butterfill.opb.session.OpbSession;
import java.math.BigDecimal;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates the use of UserDefinedCollectionDemo
 * (see {@link SimpleTranslationDemoMain}) using Spring for configuration.
 * <br/>
 * <b>Please refer to package.html for DB set-up details.</b>
 * <b>To run this demo;</b>
 * <ul>
 * <li>Run the main method of this class.</li>
 * </ul>
 */
public class UserDefinedCollectionDemoMain {

    /**
     * Passes an array to a PL/SQL procedure via the Opb generated
     * UserDefinedCollectionDemo class.
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

        // get a new session
        OpbSession session = (OpbSession)context.getBean("opbSession");

        // get an instance that implements the ArrayDemo interface
        UserDefinedCollectionDemo demoInstance = session
                .getDataObjectSource()
                .getInstance(UserDefinedCollectionDemo.class, "");

        // create an array to pass to the echo method.
        // Note: The elements in this array can be of any type as long as they
        // can be converted to numbers
        Object[] arrayIn = new Object[]{
            1,
            2L,
            "3",
            "3.14",
            BigDecimal.TEN,
            9.99,
            6.23F};

        // call a method on our instance. This will make a PL/SQL call.
        // Note: The return type is specific
        BigDecimal[] arrayResult = demoInstance.echo(arrayIn);

        // show what we passed in next to what we got back
        for (int i = 0; i < arrayIn.length; i++) {
            System.out.println(
                    "in=" + arrayIn[i] + ", result=" + arrayResult[i]);

        }

        // Note: Spring will release the connection held by our session via the destroy-method

    }

}
