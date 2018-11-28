/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Game {
    
    private Hand playerhand;
    private Hand dealerhand;
    // private View view;
    // static Scanner lukija = new Scanner(System.in);
    
    public String startGame() {
        playerhand = new Hand();
        dealerhand = new Hand();
        // jaetaan aloituskortit pelaajalle
        playerhand.addHand();
        playerhand.addHand();
        
        // jaetaan yksi kortti jakajalle
        dealerhand.addHand();
        
        return("Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal() + 
                "\n. 1. Hit vai 2. Stand ?");
}
    /* public static void main (String args[]){
        
        // 2 ekaa korttii molemmille defaulttina ennen while looppia - lisätään niiden arvot luotuihin olioihin,
   
        String pcard1 = Deck.deal();      //Luodaan pelaajan ensimmäinen kortti
        String pcard2 = Deck.deal();      //Luodaan pelaajan toinen kortti
        
        String dcard1 = Deck.deal();    //Luodaan jakajan ensimmäinen kortti
        String dcard2 = Deck.deal();    //Luodaan jakajan toinen kortti
        
        Hand pHand = new Hand();    //Luodaan pelaajan käsi -olio
        Hand dHand = new Hand();    //Luodaan jakajan käsi -olio
        
        // pHand.addHand(pcard1);      //Lisätään pelaajan ensimmäisen kortin arvo pelaajan käsi -olioon
        // pHand.addHand(pcard2);      //Lisätään pelaajan toisen kortin arvo pelaajan käsi -olioon
        
        pHand.addValue(pcard1);     //Lisätään pelaajan ensimmäisen kortin numeerinen arvo pelaajan käden olion total valueen
        pHand.addValue(pcard2);     //Lisätään pelaajan toisen kortin numeerinen arvo pelaajan käden olion total valueen
        
        System.out.println("Your cards, total value " + pHand.GetTotal() + ":");
        pHand.getHand();       //Tulostaa pelaajan koko käden stringeinä
        System.out.println("");
        
        // dHand.addHand(dcard1);  //Lisätään jakajan ensimmäisen kortin arvo jakajan käden olioon
        // dHand.addHand(dcard2);  //Lisätään jakajan ensimmäisen kortin arvo pelaajan jakajan käden olioon
        
        dHand.addValue(dcard1);//Lisätään jakajan ensimmäisen kortin numeerinen arvo pelaajan käden olion total valueen
        dHand.addValue(dcard2);//Lisätään jakajan toisen kortin numeerinen arvo pelaajan käden olion total valueen
        
        System.out.println("The dealer's cards, known value " + dHand.getValue(dcard1) + ":");
        System.out.println("[Unknown card] + " + dcard1);
        System.out.println("");
        
        if (pHand.GetTotal() == 21) {
                System.out.println("You got a Blackjack! You won!");
            }
        
        
        while (pHand.GetTotal() < 21 & (dHand.GetTotal() < 17)) { // jatketaan peliä
        String choiceStr = JOptionPane.showInputDialog("Would you like to (1) be Hit or (2) Stand?");
        int choice = Integer.parseInt(choiceStr);
        
        if (choice == 1) {
            System.out.println("Drawing card...");
            String pcard3 = Deck.deal();      //Luodaan pelaajan kolmas kortti
            // pHand.addHand(pcard3);      //Lisätään pelaajan kolmannen kortin arvo pelaajan käsi -olioon
            pHand.addValue(pcard3);     //Lisätään pelaajan kolmannen kortin numeerinen arvo pelaajan käden olion total valueen
            System.out.print("Your hand is: ");
            pHand.getHand();       //Tulostaa pelaajan koko käden stringeinä
            
            System.out.println(pHand.GetTotal());   //tulostaa pelaajan korttien arvojen summan
        }
        else if (choice == 2) {
            System.out.println("");
            String dcard3 = Deck.deal();      //Luodaan dealerin kolmas kortti
            // pHand.addHand(dcard3);      //Lisätään dealerin kolmannen kortin arvo pelaajan käsi -olioon
            pHand.addValue(dcard3);     //Lisätään dealerin kolmannen kortin numeerinen arvo dealerin käden olion total valueen
            System.out.print("The dealer's hand is: ");
            pHand.getHand();       //Tulostaa dealerin koko käden stringeinä
            System.out.println(dHand.GetTotal());   //tulostaa dealerin korttien arvojen summan
        }
            
        if (pHand.GetTotal() > 21) {
                System.out.println("Bust: you went over 21, so the Dealer wins!");
            }
        }
        
        if (dHand.GetTotal() > 16 & dHand.GetTotal() < 21) {
            System.out.println("The Dealer wins!");    
        }
        
        if (pHand.GetTotal() == 21) {
                System.out.println("You got a Blackjack! You won!");
            }
        
        } */
}
        
        
    
    

    
