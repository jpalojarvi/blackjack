/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Mkayyee
 */
public class Game {
    
    public Deck pakka;
    public Hand playerhand;
    public Hand dealerhand;
    
    private View view;
    // static Scanner lukija = new Scanner(System.in);
    
    public String startGame() {
        
        pakka = new Deck();
        String x = pakka.deal();
        String y = pakka.deal();
        String z = pakka.deal();
        
        playerhand = new Hand();
        dealerhand = new Hand();
        // jaetaan aloituskortit pelaajalle
        playerhand.addHand(x);
        playerhand.addHand(y);
        
        playerhand.addValue(x);
        playerhand.addValue(y);
        
        // jaetaan yksi kortti jakajalle
        dealerhand.addHand(z);
        dealerhand.addValue(z);
        
        if (playerhand.GetTotal() == 21) {
            
            return("blackjack");
                    }
        
        else if (playerhand.GetTotal() > 21) {
            return("bust");
            
                    }
        else {
        return("Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal() +
                "\n. 1. Hit vai 2. Stand ?");
        }
    }
    public String Hit() {
        String x = pakka.deal();
        playerhand.addHand(x);
        playerhand.addValue(x);
        
        if (playerhand.GetTotal() > 21) {
            
            return ("Bust! Your hand is " + playerhand.getHand() + " " + playerhand.GetTotal() + ". Want to play again? (y/n)");
        }
        
        
        else {    
            
        }
        return("Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal() + 
                "\n. 1. Hit vai 2. Stand ?");
        
    }
    
    public String Stand(){
        
        String x = pakka.deal();
        dealerhand.addHand(x);
        dealerhand.addValue(x);
        
        if (dealerhand.GetTotal()>playerhand.GetTotal() && dealerhand.GetTotal()<17){
            return("House wins."+" Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal()+" Dealer has Blackjack, house wins.");     
            
        }else if (dealerhand.GetTotal()<playerhand.GetTotal()){
            while (dealerhand.GetTotal()<playerhand.GetTotal() && dealerhand.GetTotal()<21){
            String y = pakka.deal();
            dealerhand.addHand(y);
            dealerhand.addValue(y);
                if (dealerhand.GetTotal()>21){
                    return ("You win!" +" Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                        "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal());
                
            }
                else if (dealerhand.GetTotal()==21){
                    return ("Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                        "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal()+" Dealer has Blackjack, house wins.");
            }
            
            }
        }
            
    return("Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                        "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal());     
    }
    
    public void gamestate() {
        while (playerhand.GetTotal() < 21) {
            view.showQuestion("Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal() + 
                "\n. 1. Hit vai 2. Stand ?");
        }
        
        if (playerhand.GetTotal() > 21) {
            view.showMessage("hävisit");;
                }
        else {
                view.showMessage("Blackjack!");
                }
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

        
    
