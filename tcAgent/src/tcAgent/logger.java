/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tcAgent;

/**
 *
 * @author rezabashash
 */
public class logger {
public static String errors = "";


   public static void error (String className, String methodName, String args, String comments){
       if (globals.log){
           String err = "ERROR: \n Class Name: "+className+"\n Method Name: "+methodName+"\n args: "+args+"\n Comments: "+comments;
           errors = errors+"\n"+err;
           System.err.println(err);
       }
   }
}
