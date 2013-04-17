
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.jsedemo.data.ArrayDemo;
import com.butterfill.opb.session.OpbSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Note: Unused import helps with compilation
import com.butterfill.opb.jsedemo.data.ArrayDemoImpl;
import com.butterfill.opb.jsedemo.data.DbmsOutput;
import com.butterfill.opb.util.OpbValueWrapper;
import com.butterfill.opb.util.OpbValueWrapperImpl;

/**
 * Demonstrates the use of ArrayDemo (see {@link SimpleTranslationDemoMain})
 * using Spring for configuration.
 * <br/>
 * <b>Please refer to package.html for DB set-up details.</b>
 * <b>To run this demo;</b>
 * <ul>
 * <li>Run the main method of this class.</li>
 * </ul>
 *
 */
public class SimpleArrayDemoMain {

    /**
     * Passes an array to a PL/SQL procedure via the Opb generated ArrayDemo
     * class.
     *
     * @param args not used.
     */
    public static void main(String[] args) throws Exception {
        // create the spring context
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // register the shutdown hook so that the context will call destroy methods
        context.registerShutdownHook();

        // get a new session
        OpbSession session = (OpbSession) context.getBean("opbSession");

        // get an object that can make DBMS_OUTPUT calls
        final DbmsOutput dbmsOutput = session.
                getDataObjectSource().
                newInstance(DbmsOutput.class);

        // enable DBMS_OUTPUT
        dbmsOutput.enable(1000000L);

        // get an instance that implements the ArrayDemo interface
        final ArrayDemo arrayDemo = session
                .getDataObjectSource()
                .getInstance(ArrayDemo.class, "");

        // create an array to pass to the demoOne method
        String[] array = new String[]{"a", "b", "3"};

        // call a method on our instance. This will make a PL/SQL call
        // and the PL/SQL will output to DBMS_OUTPUT
        arrayDemo.demoOne(array);

        // get the DBMS_OUTPUT
        // before we can make the GET_LINE call, we need a couple of wrappers to hold the value
        // returned via the "line" parameter and
        final OpbValueWrapper<String> getLineResultWrapper = new OpbValueWrapperImpl<String>();

        // the value returned via the "status" parameter
        final OpbValueWrapper<Long> getLineStatusWrapper = new OpbValueWrapperImpl<Long>();

        // make the 1st GET_LINE call to get the data back
        dbmsOutput.getLine(getLineResultWrapper, getLineStatusWrapper);

        // if the status is 0, we got some data
        while (getLineStatusWrapper.getValue().equals(0L)) {
            // output the values returned
            System.out.println(getLineResultWrapper.getValue());
            // and see if we have some more data
            dbmsOutput.getLine(getLineResultWrapper, getLineStatusWrapper);

        }

        /*
         * you should see;
         * 1=a
         * 2=b
         * 3=3
         * from System.out
         */

        // Note: Spring will release the connection held by our session via the destroy-method

    }

}
