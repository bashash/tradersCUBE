package tcAgent;
import java.util.*;

/**
 *
 * @author rezabashash
 */


public class flash extends Agent{

    // Variables

    public static  String stocks[] = {"XOM", "BAC"};
    public static  int flashCard[] = {0, 0};
    public static  double flashPrice[] = {0, 0};
    public void run(){
        try {



/*
 * A Very Simple Agent Implementation
 * INCREMENT CARD AGENT
 */

try{

  Timer timer=  new Timer();
        timer.schedule(new TimerTask(){ public void run() {
            communicate comm = new communicate();
            String[] securities = new String[stocks.length];
            String[] lastPrices = new String[stocks.length];

            for (int i = 0; i < stocks.length; i++){
                securities[i] = comm.getSecurityInfoByTicker(stocks[i], "securityid");
                lastPrices[i] = comm.getLastQuote(securities[i])[4];
                print(lastPrices[i]);
                if (Double.parseDouble(lastPrices[i]) > flashPrice[i]){
                    flashPrice[i] = Double.parseDouble(lastPrices[i]);
                    flashCard[i]++;
                    print("flash++");
                } else if (Double.parseDouble(lastPrices[i]) < flashPrice[i]){
                    flashPrice[i] = Double.parseDouble(lastPrices[i]);
                    flashCard[i]--;
                    print("flash--");
                } else {
                    // Price Hasnt Changed
                }
                                   
                 
                if (flashCard[i] == 2){
                    int accID = 1;
                    Double kir;
                    kir = Math.floor((comm.getMyFinancialAccountBalance(1)-1500)/flashPrice[i]);
                    int qty = kir.intValue();

                    comm.tradeStock(securities[i],Integer.toString(accID), Integer.toString(qty), Double.toString(flashPrice[i]), "buy", "GTC", "", "", "","");
                    flashCard[i] = 0;
                    print("Bought");
                }
                if (flashCard[i] == -2){
                    int accID = 1;
                    int qtysell = 0;
                    int sellids[] = comm.getHoldingSecurityID();
                    int sellqtys[] = comm.getHoldingSecurityQty();

                    for (int z = 0; z<=sellids.length; z++){
                        if (sellids[z] == Integer.parseInt(securities[i])){
                            qtysell = sellqtys[z];
                            comm.tradeStock(securities[i],Integer.toString(accID), Integer.toString(qtysell), Double.toString(flashPrice[i]), "sell", "GTC", "", "", "","");
                            flashCard[i] = 0;
                            print("SOLD");
                            break;
                        }
                    }


                    
                    
                }
            }


        }},0,5000);


} catch (Exception e){
    System.out.println(e);
}





























































        } catch(Exception e){

        }
    }
   }