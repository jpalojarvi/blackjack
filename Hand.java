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
                if (compare > 21){
                    removeAce();
                    totalvalue +=11;
                }
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
                    removeAce();
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
        int i=0;
        
        for (String search : wholehand){
            
            if (search.contains("A")){
                wholehand.remove(search);
                wholehand.add(i,"Ä"+String.valueOf(search.charAt(1)));
                totalvalue = totalvalue - 10;
                break;
              
            }
            i++;
 
        }
 
        
        
        
   }
    public boolean checkAce(){
        boolean checked = false;
        for (int i = 0 ; i <= wholehand.size(); i++ ){
            String y = wholehand.get(i);
            String z = String.valueOf(y.charAt(0));
            
            if (z.equals("A")){   
                checked = true;
                return checked;
            }
            
          
}
        return checked;
           
    }
    
}
