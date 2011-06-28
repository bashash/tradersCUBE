/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

/**
 *
 * @author rezabashash
 */
public class FIPAprotocol {
    public void processFIPA(String msg){
        msg = msg.toLowerCase();
        msg = msg.substring(1);
    
        if (msg.startsWith("inform")) {
            System.out.println("I HAVE BEEN INFORMED.");
        }
        if (msg.startsWith("action")) {
            System.out.println("I WILL DO OR WILL NOT.");
        }
    }
}
