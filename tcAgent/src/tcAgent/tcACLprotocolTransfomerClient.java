/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

/**
 *
 * @author rezabashash
 */
public class tcACLprotocolTransfomerClient {
    public static String processInput(String theInput){
            if (theInput.equals("400")){ // Asking for agent status
                return "1";
            }
            if (theInput.equals("initiatekill")){
                System.exit(1);
            }
            if (theInput.startsWith("(")) {  //FIPA message recieved
                FIPAprotocol fipap = new FIPAprotocol();
                fipap.processFIPA(theInput);
                return "1";
            }
            if (theInput.equals("hello")){
                   return "Hello, How are you today?<br>Type in 'Help' to understand my language.";
            }
            if (theInput.equals("help")){
                   return "Well, Im gonna teach how i speak.";
            }
            if (theInput.equalsIgnoreCase("how are you?")){
                   return "Great, Thanks.";
            }
            if (theInput.equalsIgnoreCase("What is your name?")){
                   return "My name is, "+globals.agentName;
            }
            if (theInput.equalsIgnoreCase("buy")){
                communicate comm = new communicate();
                if (comm.tradeStock("1","1", "10", "40.00", "buy", "GTC", "", "", "","")){
                    System.out.println("Buy successfull");
                } else {
                    System.out.println("unable to buy");
                }
                   return "I bought 200 shares of GOOGLE now.";
            }
            if (theInput.equalsIgnoreCase("sell")){
                communicate comm = new communicate();
                if (comm.tradeStock("1","1", "10", "55.00", "sell", "GTC", "", "", "","")){
                    System.out.println("Sell successfull");
                } else {
                    System.out.println("unable to sell");
                }
                   return "I SOLD 200 shares of GOOGLE now.";
            }
        return "0";
    }
}
