package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    int value;
    char cString;
    private final List<String> wholehand = new ArrayList();
    int totalvalue;
    private final Deck pakka;
    
    public Hand() {
        pakka = new Deck();
    }
    public String getHand(){
        return(wholehand.toString());
    }
    /*public void getHand(){
        for (String hand : wholehand)    
            System.out.print(hand+" ");
    }*/
    public void dealerFirstCard(){
        System.out.print(wholehand.get(0)+" ");
    }
    public void dealerFirstValue(){
        System.out.print(value);
    }
    public String addHand(String x){
       wholehand.add(x);
       return x;
        
    }
    public void pAddTotal(int add){
        totalvalue = totalvalue + add;
    }
    public int GetTotal(){
        return totalvalue;
    }
    
        
    
    public void addValue(String card){
        
        cString = card.charAt(0);
        String cardo = String.valueOf(cString);
        GetTotal();
        int compare = totalvalue + 11;
        
        switch (cardo) {
            case "T":
            case "Q":
            case "J":
            case "K":
                totalvalue += 10;
                break;
            case "A":
                if (compare > 21)
                    totalvalue += 1;
                else if (compare <= 21)
                    totalvalue += 11;
                break;
            default:
                totalvalue += Integer.parseInt(cardo);
                break;
        }

    }
    public int getValue(String card){
        
        cString = card.charAt(0);
        String dcardo = String.valueOf(cString);
        switch (dcardo) {
            case "T":
            case "Q":
            case "J":
            case "K":
                value = 10;
                break;
            case "A":
                if (totalvalue > 21){
                    value = 1;
                }
                else
                    value = 11;
                break;
            default:
                value = Integer.parseInt(dcardo);
                break;
        }
        return value;
    }
    public void removeAce(){
        for (int i = 0 ; i < wholehand.size(); i++ ){
            String y = wholehand.get(i);
            String z = String.valueOf(y.charAt(0));
            
            String x = "A";
            if (z.equals(x)){
                wholehand.remove(i);
                wholehand.add(" A");
                totalvalue = totalvalue - 10;
                break;
              
            }
            if (!z.equals(x))
                break;
           
        }
   }

}
