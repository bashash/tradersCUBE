/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

import java.net.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author rezabashash
 */
class listenThread implements Runnable{

    Thread t;

    listenThread(int port){
        t = new Thread(this,"listner");
        t.start();

    }

    public void run(){
        try{
         ServerSocket serverSocket = null;
        boolean listening = true;
      //  System.out.println("----------- INFO -----------");


        try {

            serverSocket = new ServerSocket((globals.port+1));
      //    System.out.println("tcServer Satus: Live");
      //    System.out.println("port: "+(globals.port+1));
            globals g = new globals();
            g.connected("1");
        } catch (IOException e) {
            //debugger.debug(e, java.lang.String.class);
            System.err.println("tcServer Satus: Unable to start. err: "+e);
            e.printStackTrace();
            System.err.println("Could not listen on port: "+globals.port);
            System.exit(-1);
        }
    //    System.out.println("----------------------------");
                Timer timer = new Timer();
       timer.schedule(new TimerTask(){ public void run(){

           try{
   communicate comm = new communicate();
    globals g = new globals();
  //  g.connected(comm.communicateWithServer("2", "System Test"));
           } catch(Exception e){
               globals g = new globals();
                g.connected("0");
           }
           globals g = new globals();
   //        System.out.println(g.connected);

       }}, 0, 60000);

while (true){
    new tcMultiThread(serverSocket.accept()).start();
}
       // serverSocket.close();
    } catch (Exception e) {

    }
    }

}
