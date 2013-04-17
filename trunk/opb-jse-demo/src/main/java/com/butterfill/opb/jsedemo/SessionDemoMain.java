

package com.butterfill.opb.jsedemo;

import com.butterfill.opb.jsedemo.data.DbmsOutput;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.OpbValueWrapper;
import com.butterfill.opb.util.OpbValueWrapperImpl;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates the use of the light Opb session - OpbSessionLightPlsqlImpl.
 * <br/>
 * <b>Please refer to package.html for DB set-up details.</b>
 * <b>To run this demo;</b>
 * <ul>
 * <li>Run the main method of this class.</li>
 * </ul>
 *
 */
public class SessionDemoMain {

    /**
     * Sends some data to DBMS_OUTPUT (via a PUT_LINE call)
     * and then gets the data back (via a GET_LINE call).
     * <br/>
     * Expect to see <code>getLineResult=test line sent to DBMS_OUTPUT</code> output.
     *
     * @param args
     *   Is ignored.
     */
    public static void main(String[] args) {
        // create the spring context
        final AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // register the shutdown hook so that the context will call destroy methods
        context.registerShutdownHook();

        // get a new session
        final OpbSession session = (OpbSession) context.getBean("opbSession");

        // get an object that can make DBMS_OUTPUT calls
        final DbmsOutput dbmsOutput = session.
                getDataObjectSource().
                newInstance(DbmsOutput.class);

        // enable DBMS_OUTPUT
        dbmsOutput.enable(1000000L);

        // send some data to DBMS_OUTPUT
        dbmsOutput.putLine("test line sent to DBMS_OUTPUT");

        // before we can make the GET_LINE call, we need a couple of wrappers to hold the value
        // returned via the "line" parameter and
        final OpbValueWrapper<String> getLineResultWrapper = new OpbValueWrapperImpl<String>();

        // the value returned via the "status" parameter
        final OpbValueWrapper<Long> getLineStatusWrapper = new OpbValueWrapperImpl<Long>();

        // make the GET_LINE call to get the data back
        dbmsOutput.getLine(getLineResultWrapper, getLineStatusWrapper);

        // output the values returned
        System.out.println("getLineResult=" + getLineResultWrapper.getValue());
//        System.out.println("getLineStatus=" + getLineStatusWrapper.getValue());

        // Note: Spring will release the connection held by our session via the destroy-method

    }

}
