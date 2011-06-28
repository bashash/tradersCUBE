/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException{
 
        
            new AgentClientCore(args); // initialze Agent's core modules.
            logger.error("Main", "main", "noargs", "Testing the error logging");
            new Agent();
            

        FIPAmessage message = new FIPAmessage();
        message.setPerformative("action");
        message.setSender("Reza Bashash");
        message.setReceiver("Agent A");
        message.setContent("<XML>RDF:rdf</XML>");

        FIPAenvelope envelope = new FIPAenvelope("localhost",59971 , message);
       // envelope.send(envelope);


    }
}



