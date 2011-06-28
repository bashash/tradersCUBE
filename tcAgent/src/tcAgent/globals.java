/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

/**
 *
 * @author rezabashash
 */
public class globals {
public static int port = 0;
public static int serverport = 32540;
public static String serverName = "tcServer";
public static String serverip = "192.168.1.4";
public static String agentName = "";
public static int connectionID = 0;
public static int sequence = 0;
public static boolean connected;
public static String accountid = "";
public static boolean log = false;

public static boolean tempbuy = true;
public static boolean tempsold = true;

public static void init(String args[]){

    if (args.length >=1){ //setting Server IP
        serverip = args[0];
    }

    if (args.length >=2){ // setting server port
        serverport = Integer.parseInt(args[1]);
    }

    if (args.length >=3){ // setting agent name (if na is provided, an agent name will be created)
        if ((args[2]).equals("na")){
            setAgentName("");
        } else {
            setAgentName(args[2]);
        }

    } else {
        setAgentName("");
    }

     if (args.length >=4){ // setting client authorization
        accountid = args[3];
    }
    if (args.length >= 5){
        if (args[4].equals("nolog")){
            log = false;
        } else if (args[4].equals("log")){
            log = true;
        } else {
            System.err.println("Invalid logging initiation.");
        }
    }
    if (args.length >= 6){
        System.out.println("Loading agent state...");
        AgentMigrate agt = new AgentMigrate();
        agt.migrateState(args[5]);
    }

}

public static void setAgentName(String name){
    if (name.equals("")){
         agentName = Long.toHexString(Double.doubleToLongBits(Math.random()));
    } else {
        agentName = name;
    }
}
public static void connected(String connection){
    int temp = 0;
    temp = Integer.parseInt(connection);
    if (temp == 1){
        connected = true;
    } else {
        connected = false;
    }
}
}
