/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



package tcAgent;
import java.net.*;
import java.io.*;
/**
 *
 * @author Mohammadreza Bashash
 *
 */
public class communicate {


/**
 * Check if server is alive
 * @return bool true/false
 */    
public boolean serveralive(){
    try{
        if (communicateWithServer("2", "system test").equals("true")){
            return true;
        } else {
             return false;
        }
    } catch (Exception e){
        System.out.println(e);
        return false;
    }
}

/**
 * Terminate the agent
 * This method terminates the agent and lets the server and other agents know about it
 */
public String killmyself (){
        try{
            if (serveralive()){
            return(communicateWithServer("0", globals.agentName));
            } else {
                return "NOT CONNECTED";
            }
        } catch (Exception e){
            System.out.println("CAN'T KILL MYSELF");
            return "CAN'T KILL MYSELF";
        }
}

/**
 * Get the listening port number
 * The port number is retrieved from globals.port
 * @return int port
 */
public int getmyport(){
    try{
   if (globals.connected){
        return (globals.port)+1;
    }
   return 0;
    } catch (Exception e){
        return 0;
    }
}


/**
 * Get the account trading name from server
 * @return account name
 */
public String getMyAccountName(){
     try{
        return communicateWithServer("100", "trader<p>traderName");
     } catch (Exception e){
         return "error, "+e;
     }
}

/**
 * Get the account trading ID from server
 * @return account ID
 */
public int getMyAccountID(){
     try{
        return Integer.parseInt(communicateWithServer("100", "trader<p>traderID"));
     } catch (Exception e){
         return 0;
     }
}

/**
 * Get the account trading Email from server
 * @return account Email
 */
public String getMyAccountEmail(){
     try{
        return communicateWithServer("100", "trader<p>traderEmail");
     } catch (Exception e){
         return "error, "+e;
     }
}

/**
 * Get the list of financial account IDs from the server
 * @return int accountIDs[]
 */
public int[] getMyFinancialAccountIDs(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("101", "traderaccount<p>traderAccountID");
         resultArray = result.split("<a>");
         int[] newarray = new int[resultArray.length-1];
         
         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Integer.parseInt(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

/**
 * Get the list of financial account names from the server
 * @return String accountIDs[]
 */
public String[] getMyFinancialAccountNames(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("101", "traderaccount<p>accountName");
         resultArray = result.split("<a>");
         String[] newarray = new String[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = resultArray[i];
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

/**
 * Get the list of financial account balances from the server
 * @return Double acountbalances[]
 */
public Double[] getMyFinancialAccountLimits(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("101", "traderaccount<p>accountLimit");
         resultArray = result.split("<a>");
         Double[] newarray = new Double[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Double.parseDouble(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

/**
 * Get the account balance for a specific financial account
 * @param accountID
 * @return Double accountIDs[]
 */
public Double getMyFinancialAccountBalance(int accountID){
    
     try{

         return Double.parseDouble(communicateWithServer("102", Integer.toString(accountID)));

     } catch (Exception e){
         System.out.println(e);
         return null;
     }
}

/**
 * Get a list of securities that the trader currently holds, Pending transactions and trades are not retrieved
 * @return int securityIds[]
 */

public int[] getHoldingSecurityID(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("103", "transaction<p>securityID");
         resultArray = result.split("<a>");
         int[] newarray = new int[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Integer.parseInt(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

public int[] getHoldingSecurityQty(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("103", "transaction<p>qty");
         resultArray = result.split("<a>");
         int[] newarray = new int[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Integer.parseInt(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}




public Double[] getHoldingSecurityAvgCost(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("103", "transaction<p>avgcost");
         resultArray = result.split("<a>");
         Double[] newarray = new Double[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Double.parseDouble(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

public int[] getHoldingSecurityAccountID(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("103", "transaction<p>transactionAccount");
         resultArray = result.split("<a>");
         int[] newarray = new int[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Integer.parseInt(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

public int[] getPendingHoldingSecurityID(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("104", "transaction<p>securityID");
         resultArray = result.split("<a>");
         int[] newarray = new int[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Integer.parseInt(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

public int[] getPendingHoldingSecurityQty(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("104", "transaction<p>qty");
         resultArray = result.split("<a>");
         int[] newarray = new int[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Integer.parseInt(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

public Double[] getPendingHoldingSecurityAvgCost(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("104", "transaction<p>avgcost");
         resultArray = result.split("<a>");
         Double[] newarray = new Double[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Double.parseDouble(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}
public int[] getPendingHoldingSecurityAccountID(){
    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("104", "transaction<p>transactionAccount");
         resultArray = result.split("<a>");
         int[] newarray = new int[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = Integer.parseInt(resultArray[i]);
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

public String getSecurityInfoByInernalID(String id, String info){ // info: securityid, ticker, CUSIP, CIK, MG, name, type, sector, NAICS, primarySIC, secondarySIC, market
     try{
        return communicateWithServer("110", "security<p>securityID<p>"+id+"<p>"+info);
     } catch (Exception e){
         return "error, "+e;
     }
}
public String getSecurityInfoByTicker(String ticker, String info){
     try{
        return communicateWithServer("110", "security<p>ticker<p>"+ticker+"<p>"+info);
     } catch (Exception e){
         return "error, "+e;
     }
}
public String getSecurityInfoByCUSIP(String cusip, String info){
     try{
        return communicateWithServer("110", "security<p>CUSIP<p>"+cusip+"<p>"+info);
     } catch (Exception e){
         return "error, "+e;
     }
}
public String getSecurityInfoByCIK(String cik, String info){
     try{
        return communicateWithServer("110", "security<p>CIK<p>"+cik+"<p>"+info);
     } catch (Exception e){
         return "error, "+e;
     }
}
public String getSecurityInfoByMG(String mg, String info){
     try{
        return communicateWithServer("110", "security<p>MG<p>"+mg+"<p>"+info);
     } catch (Exception e){
         return "error, "+e;
     }
}
public String getSecurityInfoByNAICS(String NAICS, String info){
     try{
        return communicateWithServer("110", "security<p>NAICS<p>"+NAICS+"<p>"+info);
     } catch (Exception e){
         return "error, "+e;
     }
}
public String[] getSecurityInfoBySector(String sector, String info){

    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("111", "security<p>sector<p>"+sector+"<p>"+info);
         resultArray = result.split("<a>");
         String[] newarray = new String[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = resultArray[i];
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}
public String[] getSecurityInfoByType(String type, String info){ //commonstock, mutual fund, option, future... See documentation for info

    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("111", "security<p>type<p>"+type+"<p>"+info);
         resultArray = result.split("<a>");
         String[] newarray = new String[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = resultArray[i];
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

public String[] getSecurityInfoByMarket(String market, String info){ //// to see all the markets, see documentation

    String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("111", "security<p>market<p>"+market+"<p>"+info);
         resultArray = result.split("<a>");
         String[] newarray = new String[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = resultArray[i];
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}


public String[] getHistoricalQuoteForDay(String securityid, String Date){
 String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("120", securityid+"<p>"+Date);
         resultArray = result.split("<a>");
         String[] newarray = new String[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = resultArray[i];
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}
/**
 * 
 * @param security
 * @param securityIdentifier
 * @param Date
 * @return
 */
public String[][] getDetailHistoricalQuoteForDay(String securityid, String Date){
 String result = "";
    String resultArray[];
    String resultArray2[];
    

     try{

         result = communicateWithServer("130", securityid+"<p>"+Date);
         resultArray = result.split("<li>");
System.out.println(result);
         String[][] newarray = new String[resultArray.length-1][6];

         for (int i=1; i<resultArray.length; i++){
             resultArray2 = resultArray[i].split("<a>");
             for (int j=1; j<7; j++){

             newarray[i-1][j-1] = resultArray2[j];
             }
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

/**
 * Get last quote for a security
 * @param securityid
 * @return
 */
public String[] getLastQuote(String securityid){
 String result = "";
    String resultArray[];

     try{

         result = communicateWithServer("140", securityid);
         resultArray = result.split("<a>");
         String[] newarray = new String[resultArray.length-1];

         for (int i=1; i<resultArray.length; i++){
             newarray[i-1] = resultArray[i];
         }

     return newarray;
     } catch (Exception e){
         return null;
     }
}

/**
 * instructions to server for a trader
 * [stockid],[accountid], [qty], [$limitprice/market], [buy/sell/short/cover], [GTC/GTECD/GTD], [$stoplimit/null], [all/none/null], [VTSO/null],[specialinstructions/null]
 * @param securityid
 * @param accountid
 * @param qty
 * @param price
 * @param action
 * @param terms
 * @param stoplimit
 * @param allnone
 * @param vtso
 * @param specialinstructions
 * @return bool[true=success/false=error]
 */
public boolean tradeStock(String securityid, String accountid, String qty, String price, String action, String terms, String stoplimit, String allnone, String vtso, String specialinstructions){
    
    try{ 
        if (communicateWithServer("200", securityid+"<p>"+accountid+"<p>"+qty+"<p>"+price+"<p>"+action+"<p>"+terms+"<p>"+stoplimit+"<p>"+allnone+"<p>"+vtso+"<p>"+specialinstructions).equals("1")){
            return true;
        } else {
            return false;
        }
     } catch (Exception e){
         return false;
     }

}
public long getServerEpoch(){
         try{
         return Long.parseLong(communicateWithServer("213", ""));
     } catch (Exception e){
         return 0;
     }
}
public Boolean isMarketOpen(){
     try{
         if (communicateWithServer("210", "").equals("1")){
             return true;
         } else {
             return false;
         }

     } catch (Exception e){
         return false;
     }
}
public long getSecondsToMarketOpen(){
     try{
         return Long.parseLong(communicateWithServer("211", ""));
     } catch (Exception e){
         return 0;
     }
}
public long getSecondsToMarketClose(){
     try{
         return Long.parseLong(communicateWithServer("212", ""));
     } catch (Exception e){
         return 0;
     }
}


public String communicateWithServer(String action, String content) throws IOException {
          try {
                 Socket kkSocket = null;
                 PrintWriter out = null;
                 BufferedReader in = null;
                try {
                    kkSocket = new Socket(globals.serverip, globals.serverport);
                    out = new PrintWriter(kkSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
                    out.println(messageWrapper(action, content));
                    out.flush();
                } catch (UnknownHostException e) {
                    System.err.println("Don't know about host.");
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for the connection");
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

    public String messageWrapper(String action, String content){
        switch (Integer.parseInt(action)){
            case 0:
                return (action+"<i>"+globals.agentName);

            case 2:
                return (action+"<i>"+globals.agentName);

            default:
                return (action+"<i>"+globals.agentName+"<i>"+globals.accountid+"<i>"+(globals.connectionID++)+"<i>"+(globals.sequence++)+"<i>"+(System.currentTimeMillis()/1000)+"<i>"+content);
        }
    }
}
