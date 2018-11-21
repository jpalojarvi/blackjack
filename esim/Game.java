/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;


import static Blackjack.Deck.deal;
import java.util.Scanner;

/**
 *
 * @author Mkayyee
 */
public class Game extends Hand {
    
    static Scanner lukija = new Scanner(System.in);
    public static void main (String args[]){
        
        // 2 ekaa korttii molemmille defaulttina ennen while looppia - lisätään niiden arvot luotuihin olioihin,
        // pelaajan kolmas kortti ja printit on vaan testaamisen takii
   
        String pcard1 = Deck.deal();
        String pcard2 = Deck.deal();
        String pcard3 = Deck.deal();

        String dcard1 = Deck.deal();
        String dcard2 = Deck.deal();
        
        Hand pHand = new Hand();
        Hand dHand = new Hand();
        
        pHand.addHand(pcard1);
        pHand.addHand(pcard2);
        pHand.addHand(pcard3);
        
        pHand.addValue(pcard1);
        pHand.addValue(pcard2);
        pHand.addValue(pcard3);
        
        pHand.getHand();
        System.out.println(pHand.GetTotal());
        
        dHand.addHand(dcard1);
        dHand.addHand(dcard2);
        
        dHand.addValue(dcard1);
        dHand.addValue(dcard2);
        
        dHand.getHand();
        System.out.println(dHand.GetTotal());
        
        
    
    
    
    

    }
}
    

        
    

