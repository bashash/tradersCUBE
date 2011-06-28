package tcAgent;
import java.util.*;
/**
 * Main Agent Implementation
 */

public class Agent implements Runnable{
    
    Thread agent;
    public boolean agentcorestatus = false;
    public String temp = "";
    public Agent(){

            agent = new Thread(this, "Agent");
            agent.start();

            
    }
    public void run(){
        try {
communicate comm = new communicate();
//---------------------------------------------------------------
/////////////////////////////////////////////////////////////////
///////////////////////// Agent Code ////////////////////////////
/////////////////////////////////////////////////////////////////
//---------------------------------------------------------------
agent.sleep(2000); // Wait 2 seconds, making sure the listen thread is active.

print("My \"Agent\" name is:                  \t"+globals.agentName); // String name

print("Server Alive:                          \t"+comm.serveralive()); // Bool server status
print("Server Epoch:                          \t"+comm.getServerEpoch());
print("I am listening to port number:         \t"+comm.getmyport());
print("\n");
print("My Trading ID is:                      \t"+comm.getMyAccountID());     // int
print("My Trading Account name is:            \t"+comm.getMyAccountName());   // String
print("My Trading Account Email is:           \t"+comm.getMyAccountEmail());  // String


print("Market Open? "+comm.isMarketOpen());
print("Seconds to Market Open "+comm.getSecondsToMarketOpen());
print("Seconds to Market Close "+comm.getSecondsToMarketClose());

print("My Financial Account IDs:");
print(comm.getMyFinancialAccountIDs());    // int Array



print("My Financial Account Names:");
print(comm.getMyFinancialAccountNames());  // String Array

print("My Financial Account Limits:");
print(comm.getMyFinancialAccountLimits());  // Double Array

int myFirstAccountID = comm.getMyFinancialAccountIDs()[0]; // e.g. get the first account

print("My First Account: "+myFirstAccountID);


print("My Financial Account Balances:");
print(comm.getMyFinancialAccountBalance(myFirstAccountID));  // Double, Balance for account 1

print("My Holdings IDs:");
print(comm.getHoldingSecurityID());

print("My Holdings Qtys:");
print(comm.getHoldingSecurityQty());

print("My Holdings Cost:");
print(comm.getHoldingSecurityAvgCost());

print("My Holdings Account ID:");
print(comm.getHoldingSecurityAccountID());

print("My Pending Holdings IDs:");
print(comm.getPendingHoldingSecurityID());

print("My Pending Holdings Qtys:");
print(comm.getPendingHoldingSecurityQty());

print("My Pending Holdings Cost:");
print(comm.getPendingHoldingSecurityAvgCost());

print("My Pending Holdings Account ID:");
print(comm.getPendingHoldingSecurityAccountID());
/*

print(comm.getSecurityInfoByInernalID("1", "name")); // Given the known value for the first parameter, these functions provide information on the requested parameters (second parameter).
// Parameters for securities include: securityid, ticker, CUSIP, CIK, MG, name, type, sector, NAICS, primarySIC, secondarySIC, market
//e.g. getSecurityByTicker("I KNOW GOOG", "WHAT IS THE NAICS for GOOG?");
//e.g. getSecurityByTicker("GOOG", "NAICS");
print(comm.getSecurityInfoByTicker("GOOG", "market"));
print(comm.getSecurityInfoByCUSIP("35259P508", "securityID"));
print(comm.getSecurityInfoByCIK("0001288776", "ticker"));
print(comm.getSecurityInfoByMG("00054776", "NAICS"));
print(comm.getSecurityInfoByNAICS("517919", "primarySIC"));

print(comm.getSecurityInfoBySector("8", "ticker")); // List all securities in a specific sector, good for sector rotating
print(comm.getSecurityInfoByType("1", "CIK")); // list all securities by their type, e.g. commonstock, future, bond, options... see documentation for codes
print(comm.getSecurityInfoByMarket("1", "name")); // list all securities whitin a market, e.g. nasdaq or NYSE... see documentation for market codes




print(comm.getHistoricalQuoteForDay("1", "27/04/2010"));  // dd/mm/yy Returns summary quotes for a specific day
// returns array of ['uid', 'epoch', 'high', 'open', 'low', 'close', 'volume']
*/
////print(comm.getDetailHistoricalQuoteForDay("1", "07/10/2010")); // dd/mm/yy Returns all traders from a specific day, return 2D array
//temp = comm.getLastQuote("3")[4];
//print(temp);

/* Timer Example
  Timer timer=  new Timer();
        timer.schedule(new TimerTask(){ public void run() {
            communicate comm = new communicate();


//Loop
if (Double.parseDouble(comm.getLastQuote("1")[4]) > (Double.parseDouble(temp)+(Double.parseDouble(temp)*0.008))){
comm.tradeStock("1","1", "10", comm.getLastQuote("1")[4], "buy", "GTC", "", "", "","");
print("Bought at: "+comm.getLastQuote("1")[4]);
}
if (Double.parseDouble(comm.getLastQuote("1")[4]) > (Double.parseDouble(temp)+(Double.parseDouble(temp)*0.008))){
comm.tradeStock("1","1", "10", comm.getLastQuote("1")[4], "buy", "GTC", "", "", "","");
print("Sold at: "+comm.getLastQuote("1")[4]);
}


        }},0,5000);

*/



// End Loop

        /*

// returns array of [['uid', 'epoch', 'bid', 'ask', 'last', 'volume']
//                   ['uid', 'epoch', 'bid', 'ask', 'last', 'volume']]


print(comm.getLastQuote("1"));
// returns array of ['uid', 'epoch', 'bid', 'ask', 'last', 'volume'] for the last quote

print(comm.tradeStock("1","1", "400", "45.00", "sell", "GTC", "", "", "",""));

*/

//comm.tradeStock("1","1", "500", "45.00", "buy", "GTC", "", "", "","");

//comm.tradeStock("1","1", "400", "45.00", "sell", "GTC", "", "", "","");
//comm.tradeStock("2","1", "500", "45.00", "buy", "GTC", "", "", "","");
//comm.tradeStock("1","1", "9000", "115.00", "sell", "GTC", "", "", "","");


//print(comm.getHoldingSecurityQty());

//print(comm.getLastQuote("1"));







/*message.
  Timer timer=  new Timer();
        timer.schedule(new TimerTask(){ public void run() {
        }},0,5000);
 */


// comm.killmyself(); // Kill Agent, the proper way.





















new flash();


agentcorestatus = true;

//---------------------------------------------------------------
/////////////////////////////////////////////////////////////////
///////////////////////// End Agent Code ////////////////////////
/////////////////////////////////////////////////////////////////
//---------------------------------------------------------------
        } catch (Exception e){

        }
    }
    public boolean agentCoreStatus(){
        return agentcorestatus;
    }
    public void print(String print){
        System.out.println(print);
    }
    public void print(String[] print){
        for(int i = 0; i<print.length; i++){
            System.out.println(print[i]);
        }
    }
    public void print(String[][] print){
        for(int i = 0; i<print.length; i++){
            for(int j = 0; j<print[i].length; j++){
                System.out.println(print[i][j]);
            }
        }
    }
    public void print(int[] print){
        for(int i = 0; i<print.length; i++){
            System.out.println(print[i]);
        }
    }
    public void print(Double[] print){
        for(int i = 0; i<print.length; i++){
            System.out.println(print[i]);
        }
    }
    public void print(Double print){
            System.out.println(print);
    }
    public void print(boolean print){
            System.out.println(print);
    }
    public void print(long print){
            System.out.println(print);
    }
}
