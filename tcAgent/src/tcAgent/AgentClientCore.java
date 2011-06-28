/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

/**
 *
 * @author rezabashash
 */
import java.io.*;
import java.net.*;


class AgentClientCore implements Runnable{
    //public static String agentID = "";
    //public static String agentName = "tradersCube Client";
    public static String agentLocation = "";
    public static boolean listening = false;

    

    Thread t;
    AgentClientCore(String args[]){
           
            globals g = new globals();
            g.init(args);
            t = new Thread(this, "Client Start");
            t.start();

    }


    public void run(){
        try{
                Socket kkSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            InetAddress addr = InetAddress.getLocalHost();
            String ipAddr = addr.getHostAddress();
            String hostname = addr.getHostName();
            agentLocation = ipAddr+"<"+hostname+">";


            kkSocket = new Socket(globals.serverip, globals.serverport);
            out = new PrintWriter(kkSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
            //System.out.println(out);
            //System.out.println(in);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;
        initiateConnection(in, out);

        while ((fromServer = in.readLine()) != null) {
            //System.out.println(fromServer);
            globals.port = Integer.parseInt(fromServer);
        if (!(listening)){

            startListening(Integer.parseInt(fromServer));
            listening = true;
        }
           // System.out.println("Server: " + fromServer);

            fromUser = stdIn.readLine();
	    if (fromUser != null) {
                out.println(fromUser);
	    }
        }

        out.close();
        in.close();
        stdIn.close();
        kkSocket.close();
        } catch (Exception e){
            
        }

        // Making Sure the connection is still alive


    }

    public static void startClient() throws IOException {


    }

    public static void send(String args,BufferedReader in, PrintWriter out){
        	
			out.println(args);
			out.flush();
    }
    public static void initiateConnection(BufferedReader in, PrintWriter out){
        //System.out.println(agentLocation);
        send("1<i>"+globals.agentName+"<i>"+agentLocation+"<i>"+globals.accountid, in, out);
    }
    public static void closeConnection(BufferedReader in, PrintWriter out){
        send("0<i>"+globals.agentName, in, out);
       // System.exit(1);
    }


public static void startListening(int port) throws IOException {
     new listenThread(port);
    
    }
}

            //out.println("1");
            //out.flush();