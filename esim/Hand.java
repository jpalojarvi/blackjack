/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

/**
 *
 * @author Mkayyee
 */
public class Hand extends Deck {
    
    int value;
    char cString;
    int playervalue;
    int dealervalue;
    int bigcards;
    String wholehand;
    int totalvalue;
    

    public void getHand(){
        System.out.println(wholehand);
    }
    public void addHand(String x){
        wholehand = wholehand + " "+x;
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
        
        if (cardo.equals("T") || cardo.equals("Q") || cardo.equals("J") || cardo.equals("K")){
            totalvalue += 10;
        }
        else if (cardo.equals("A"))
            totalvalue += 11;
        else
            totalvalue += Integer.parseInt(cardo);

    }
}
