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

public class FIPAenvelope{
    //Fields
    private String receiverIPAddress;
    private int receiverPort;
    private FIPAmessage messageContent;

    //Constructor
    public FIPAenvelope(String address, int port, FIPAmessage content){
        receiverIPAddress = address;
        receiverPort = port;
        messageContent = content;
    }

    public FIPAenvelope(){};

    //Set Methods
    public void setReceiverIPAddress(String address){
        receiverIPAddress = address;
    }
    public void setReceiverPort(int port){
        receiverPort = port;
    }
    public void setmessageContent(FIPAmessage content){
        messageContent = content;
    }

    //Get Methods
    public String getReceiverIPAddress(){
        return receiverIPAddress;
    }
    public int getReceiverPort(){
        return receiverPort;
    }
    public FIPAmessage getMessageContent(){
        return messageContent;
    }


        public String FIPAconstructor(FIPAmessage message){
            String FIPAcomplainceMessage = "";
        FIPAcomplainceMessage=  "("+message.getPerformative()+" ";
        if (!(message.getSender().equals(""))){ FIPAcomplainceMessage                   = FIPAcomplainceMessage + " :sender "+ message.getSender()+" "; }
        if (!(message.getReceiver().equals(""))){ FIPAcomplainceMessage                 = FIPAcomplainceMessage + " :receiver "+ message.getReceiver()+" "; }
        if (!(message.getReply_to().equals(""))){ FIPAcomplainceMessage                 = FIPAcomplainceMessage + " :reply-to "+ message.getReply_to()+" "; }
        if (!(message.getContent().equals(""))){ FIPAcomplainceMessage                  = FIPAcomplainceMessage + " :content ("+ message.getContent()+") "; }
        if (!(message.getLanguage().equals(""))){ FIPAcomplainceMessage                 = FIPAcomplainceMessage + " :language "+ message.getLanguage()+" "; }
        if (!(message.getEncoding().equals(""))){ FIPAcomplainceMessage                 = FIPAcomplainceMessage + " :encoding "+ message.getEncoding()+" "; }
        if (!(message.getOntology().equals(""))){ FIPAcomplainceMessage                 = FIPAcomplainceMessage + " :ontology "+ message.getOntology()+" "; }
        if (!(message.getProtocol().equals(""))){ FIPAcomplainceMessage                 = FIPAcomplainceMessage + " :protocol "+ message.getProtocol()+" "; }
        if (!(message.getConversation_id().equals(""))){ FIPAcomplainceMessage          = FIPAcomplainceMessage + " :conversation-id "+ message.getConversation_id()+" "; }
        if (!(message.getReply_with().equals(""))){ FIPAcomplainceMessage               = FIPAcomplainceMessage + " :reply-with "+ message.getReply_with()+" "; }
        if (!(message.getIn_reply_to().equals(""))){ FIPAcomplainceMessage              = FIPAcomplainceMessage + " :in-reply-to "+ message.getIn_reply_to()+" "; }
        if (!(message.getReply_by().equals(""))){ FIPAcomplainceMessage                 = FIPAcomplainceMessage + " :reply-by "+ message.getReply_by()+" "; }
        FIPAcomplainceMessage = FIPAcomplainceMessage + ")";
        return FIPAcomplainceMessage;
    }


        public String send(FIPAenvelope fe) throws IOException {
          try {
              //fe.FIPAconstructor(message)
                 Socket kkSocket = null;
                 PrintWriter out = null;
                 BufferedReader in = null;
                try {
                    System.out.println(fe.getReceiverPort());
                    kkSocket = new Socket(fe.getReceiverIPAddress(), fe.getReceiverPort());
                    out = new PrintWriter(kkSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
                    System.out.println(fe.FIPAconstructor(fe.getMessageContent()));
                    out.println(fe.FIPAconstructor(fe.getMessageContent()));
                    out.flush();
                } catch (UnknownHostException e) {
                    System.err.println("Don't know about host.");
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for the connection "+e);
                }
                 String response = in.readLine();
                out.close();
                in.close();
                kkSocket.close();
                return response;
           } catch (IOException e) {
             System.out.println(e);
           }
          return "";
        }
}
