/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;


import static Blackjack.Deck.deal;
import java.util.Scanner;

public class Game extends Hand {
    
    static Scanner lukija = new Scanner(System.in);
    public static void main (String args[]){
        
        // 2 ekaa korttii molemmille defaulttina ennen while looppia - lisätään niiden arvot luotuihin olioihin,
        // pelaajan kolmas kortti ja printit on vaan testaamisen takii
   
        String pcard1 = Deck.deal();      //Luodaan pelaajan ensimmäinen kortti
        String pcard2 = Deck.deal();      //Luodaan pelaajan toinen kortti
        String pcard3 = Deck.deal();      //Luodaan pelaajan kolmas kortti

        String dcard1 = Deck.deal();    //Luodaan jakajan ensimmäinen kortti
        String dcard2 = Deck.deal();    //Luodaan jakajan toinen kortti
        
        Hand pHand = new Hand();    //Luodaan pelaajan käsi -olio
        Hand dHand = new Hand();    //Luodaan jakajan käsi -olio
        
        pHand.addHand(pcard1);      //Lisätään pelaajan ensimmäisen kortin arvo pelaajan käsi -olioon
        pHand.addHand(pcard2);      //Lisätään pelaajan toisen kortin arvo pelaajan käsi -olioon
        pHand.addHand(pcard3);      //Lisätään pelaajan kolmannen kortin arvo pelaajan käsi -olioon
        
        pHand.addValue(pcard1);     //Lisätään pelaajan ensimmäisen kortin numeerinen arvo pelaajan käden olion total valueen
        pHand.addValue(pcard2);     //Lisätään pelaajan toisen kortin numeerinen arvo pelaajan käden olion total valueen
        pHand.addValue(pcard3);     //Lisätään pelaajan kolmannen kortin numeerinen arvo pelaajan käden olion total valueen
        
        pHand.getHand();       //Tulostaa pelaajan koko käden stringeinä
        System.out.println(pHand.GetTotal());   //tulostaa pelaajan korttien arvojen summan
        
        dHand.addHand(dcard1);  //Lisätään jakajan ensimmäisen kortin arvo jakajan käden olioon
        dHand.addHand(dcard2);  //Lisätään jakajan ensimmäisen kortin arvo pelaajan jakajan käden olioon
        
        dHand.addValue(dcard1);//Lisätään jakajan ensimmäisen kortin numeerinen arvo pelaajan käden olion total valueen
        dHand.addValue(dcard2);//Lisätään jakajan toisen kortin numeerinen arvo pelaajan käden olion total valueen
        
        dHand.getHand(); //Tulostaa jakajan koko käden stringeinä
        System.out.println(dHand.GetTotal()); //tulostaa jakajan korttien arvojen summan
        
        
    
    
    
    

    }
}
    

        
    

