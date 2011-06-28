/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

import java.net.*;
import java.io.*;

/**
 *
 * @author rezabashash
 */
public class tcACLprotocol {

        public String processInput(String theInput) throws IOException{
            //return Integer.toString(Integer.parseInt(theInput)*10);


                tcACLprotocolTransfomerClient tcap = new tcACLprotocolTransfomerClient();
                return(tcap.processInput(theInput));

        }


}
