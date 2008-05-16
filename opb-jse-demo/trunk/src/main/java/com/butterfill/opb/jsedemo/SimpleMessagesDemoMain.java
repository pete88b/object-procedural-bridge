
package com.butterfill.opb.jsedemo;

import com.butterfill.opb.plsql.messages.OpbMessage;
import com.butterfill.opb.plsql.messages.OpbMessages;
import com.butterfill.opb.session.OpbSession;
import com.butterfill.opb.util.OpbToStringHelper;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Demonstrates the use of Opb messages using Spring for configuration.
 * <br/>
 * <b>Please refer to package.html for DB set-up details.</b>
 * 
 * Note: 
 *  The Opb messages classes are part of the opb-plsql project.
 *  They have been generated from the PL/SQL packages opb_message and opb_messages.
 * 
 */
public class SimpleMessagesDemoMain {
    private static final Logger logger = Logger.getLogger(
            SimpleMessagesDemoMain.class.getName());
    
    /**
     * Demonstrates the use of Opb messages.
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
        
        // get a messages object
        OpbMessages messages = session
                .getDataObjectSource()
                .getInstance(OpbMessages.class, "");
        
        // add a couple of session messages
        messages.addSessionMessage(
                OpbMessages.MESSAGE_LEVEL_INFO, "summary", "detail");
        
        messages.addSessionMessage(
                OpbMessages.MESSAGE_LEVEL_INFO, "summary2", "detail2");
        
        // retrieve the session messages from the DB
        List<OpbMessage> result = messages.getSessionMessages();
        
        // log the result
        for (OpbMessage m : result) {
            logger.info(
                    "Message from result: Level=" +
                    m.getMessageLevel() + ". Summary=" + 
                    m.getMessageSummary() + ". Detail=" + 
                    m.getMessageDetail());
        }
        
        // log the result in verbose mode
//        logger.info(OpbToStringHelper.toStringFull(result));
        
        // sleep for a bit so we can check DB data 
        // e.g. 
        //   select * from opb_message_data;
        //   select * from opb_context_data;
//        Thread.sleep(4000);
        
    }

}
