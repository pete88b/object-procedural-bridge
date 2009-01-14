
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.jsedemo.data.ArrayDemo;
import com.butterfill.opb.session.OpbSession;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Note: Unused import helps with compilation
import com.butterfill.opb.jsedemo.data.ArrayDemoImpl;

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
        
        // get an instance that implements the ArrayDemo interface
        ArrayDemo arrayDemo = session
                .getDataObjectSource()
                .getInstance(ArrayDemo.class, "");
        
        // create an array to pass to the demoOne method
        String[] array = new String[]{"a", "b", "3"};
        
        // call a method on our instance. This will make a PL/SQL call
        arrayDemo.demoOne(array);
        
        // Check the DB logs. select * from logger_data_recent
        
    }

}
