/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

/**
 *
 * @author rezabashash
 */
public class FIPAmessage {

    //Fields
    private String performative = "";
    private String sender = "";
    private String receiver = "";
    private String reply_to = "";
    private String content = "";
    private String language = "";
    private String encoding = "";
    private String ontology = "";
    private String protocol = "";
    private String conversation_id = "";
    private String reply_with = "";
    private String in_reply_to = "";
    private String reply_by = "";


    //Complete Constructor
    public FIPAmessage(String vperformative, String vsender, String vreceiver, String vreply_to, String vcontent, String vlanguage, String vencoding, String vontology, String vprotocol, String vconversation_id, String vreply_with, String vin_reply_to, String vreply_by){
        performative = vperformative;
        sender = vsender;
        receiver = vreceiver;
        reply_to = vreply_to;
        content = vcontent;
        language = vlanguage;
        encoding = vencoding;
        ontology = vontology;
        protocol = vprotocol;
        conversation_id = vconversation_id;
        reply_with = vreply_with;
        in_reply_to = vin_reply_to;
        reply_by = vreply_by;
    }

    //Single Constructor
    public FIPAmessage(){};


    //Set methods
    public void setPerformative(String a){
        performative = a;
    }
    public void setSender(String a){
        sender = a;
    }
    public void setReceiver(String a){
        receiver = a;
    }
    public void setReply_to(String a){
        reply_to = a;
    }
    public void setContent(String a){
        content = a;
    }
    public void setLanguage(String a){
        language = a;
    }
    public void setEncoding(String a){
        encoding = a;
    }
    public void setOntology(String a){
        ontology = a;
    }
    public void setProtocol(String a){
        protocol = a;
    }
    public void setConversation_id(String a){
        conversation_id = a;
    }
    public void setReply_with(String a){
        reply_with = a;
    }
    public void setIn_reply_to(String a){
        in_reply_to = a;
    }
    public void setReply_by(String a){
        reply_by = a;
    }



    // Get methods
    public String getPerformative(){
        return performative;
    }
    public String getSender(){
        return sender;
    }
    public String getReceiver(){
        return receiver;
    }
    public String getReply_to(){
        return reply_to;
    }
    public String getContent(){
        return content;
    }
    public String getLanguage(){
        return language;
    }
    public String getEncoding(){
        return encoding;
    }
    public String getOntology(){
        return ontology;
    }
    public String getProtocol(){
        return protocol;
    }
    public String getConversation_id(){
        return conversation_id;
    }
    public String getReply_with(){
        return reply_with;
    }
    public String getIn_reply_to(){
        return in_reply_to;
    }
    public String getReply_by(){
        return reply_by;
    }
}