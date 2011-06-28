/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

/**
 *
 * @author Reza Bashash
 */
import java.net.*;
import java.io.*;

public class tcMultiThread extends Thread {
    public static Socket socket = null;

    public tcMultiThread(Socket socket) {
    super("tcMultiThread");
    this.socket = socket;

    }

    public void run() {
while(true)
    try {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                    socket.getInputStream()));
                   // sned the port for client to listen
        String inputLine, outputLine;
        tcACLprotocol kkp = new tcACLprotocol();
        outputLine = kkp.processInput(in.readLine());
        out.println(outputLine);

        out.close();
        in.close();
        socket.close();



    } catch (IOException e) {
         //    System.err.print("oops! "+e);
    }
    }

}
