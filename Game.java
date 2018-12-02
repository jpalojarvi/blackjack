package blackjack;


public class Game {
    
    public Deck pakka;
    public Hand playerhand;
    public Hand dealerhand;
    public static boolean gamestate;
    
    Controller kontrolla;
 
    
    public View view;
    
    

    public String startGame() {
        
    
        
        
        pakka = new Deck();
        String x = pakka.deal();
        String y = pakka.deal();
        String z = pakka.deal();
         // jaetaan aloituskortit pelaajalle ja yksi jakajalle
        
        playerhand = new Hand();
        dealerhand = new Hand();
        // luodaan pelaajan ja jakajan kädelle oliot
        
        playerhand.addHand(x);
        playerhand.addHand(y);
        // lisätään pelaajan arvoihin kaksi korttia 'x,y'
        playerhand.addValue(x);
        playerhand.addValue(y);
        
        // Lisätään jakajan arvoihin yksi kortti 'z'
        dealerhand.addHand(z);
        dealerhand.addValue(z);
        
        if (playerhand.GetTotal() == 21) {   // jos pelaaja ja suoraa blackjackin, häntä onnitellaan
            gamestate = true; 
            Controller.win(View.winnie);
            return("Your hand is: "+playerhand.getHand()+"  Value: "+playerhand.GetTotal()+", Blackjack!"
                    + "\nPress enter / click OK to return to the start menu.");
            
                    }
        else {
        return("You: " + playerhand.getHand() + "   Value: " + playerhand.GetTotal() +   // muuten tulostetaan molempien kädet + arvo ja kysytään mitä tehdä
                "\n Dealer: " + dealerhand.getHand() + "    Value: " + dealerhand.GetTotal() +
                "\n. 1. Hit or 2. Stand ?");
        }
    }
    public String Hit() {
        if (gamestate == true){   // jos boolean 'gamestate' on true, mennään aina tähän. 'gamestate' nollaantuu aina, kun mennään startmenuun.
            return("\nPress enter / click OK to return to the start menu.");
        }
        String x = pakka.deal();   // muuttuja x hakee pakasta satunnaisen kortin ja lisää sen pelaajan arvoihin
        playerhand.addHand(x);
        playerhand.addValue(x);
        
        
        //tästä eteenpäin blackjack ehtoja, oletuksena tulostaa uudet korttien arvot ja kysyy mennäänkö takaisin hittiin, vai jäädäänkö tämänhetkiseen käteen
        if (playerhand.GetTotal() > 21){
   // jostain syystä skippaa tän välillä ja menee suoraan alempaan (samaan ehtoon)
            
            playerhand.removeAce();    // miinustaa 10 ja muuntaa Ax:n _A:ksi jos yli 21
            playerhand.GetTotal();
                 
        }
        
        
        if (playerhand.GetTotal() == 21) {
            gamestate = true;
            Controller.win(View.winnie);
            return("Your hand is: "+playerhand.getHand()+"  Value: "+playerhand.GetTotal()+", "
                    + "Blackjack!\nPress enter / click OK to return to the start menu.");
        }
        if (playerhand.GetTotal() > 21 ) {     
            gamestate = true;
            return ("Bust! Your hand: " + playerhand.getHand() + "  Value: " + playerhand.GetTotal() + ""
                    + "\nPress enter / click OK to return to the start menu.");
            
        }
        else {    
            
        }
        return("You: " + playerhand.getHand() + "   Value: " + playerhand.GetTotal() + 
                "\nDealer: " + dealerhand.getHand() + " Value: " + dealerhand.GetTotal() + 
                "\n. 1. Hit or 2. Stand ?");
        
    }
    
    public String Stand(){
        
        if (dealerhand.GetTotal()>21)   
            gamestate = true;
        
        if (gamestate == true){   
            return("\nPress enter / click OK to return to the start menu.");
        } 
// sama kuin hitissä. Jos gamestate on 'true', täytyy 'resetoida' peli startmenun kautta

        

        while (dealerhand.GetTotal()<21){     // Dealeri saa yhden kortin niin kauan, että dealerin käsi on alle 21, tai alla olevat ehdot täyttyvät
            String y = pakka.deal();
            dealerhand.addHand(y);
            dealerhand.addValue(y);
            
        
        if (dealerhand.GetTotal() > 21){
            dealerhand.removeAce();    
            dealerhand.GetTotal();
            }
        
        if (dealerhand.GetTotal()>=playerhand.GetTotal() && dealerhand.GetTotal()>16){
                if (dealerhand.GetTotal()<21) {
                    gamestate = true;
                    return("House wins."+"\nYou: " + playerhand.getHand() + "   Value: " + playerhand.GetTotal() +     
                            "\nDealer: " + dealerhand.getHand() + " Value: " + dealerhand.GetTotal()+""
                            + "\nPress enter / click OK to return to the start menu.");
                }
        }
        if (dealerhand.GetTotal()==21) {
            gamestate = true;
            return("House wins."+"\nYou: " + playerhand.getHand() + "   Value: " + playerhand.GetTotal() + 
                    "\nDealer: " + dealerhand.getHand() + " Value: " + dealerhand.GetTotal()+"\nDealer has Blackjack."
                    + "\nPress enter / click OK to return to the start menu.");    
        }
        
        if (dealerhand.GetTotal()>21 ){
            Controller.win(View.winnie);
            gamestate = true;
            return ("You win!" +"\nYou: " + playerhand.getHand() + "    Value: " + playerhand.GetTotal() + 
                    "\nDealer: " + dealerhand.getHand() + "   Value: " + dealerhand.GetTotal()+""
                    + "\nPress enter / click OK to return to the start menu.");
            }
          
        if (dealerhand.GetTotal()>=playerhand.GetTotal() && dealerhand.GetTotal()>16){
                if (dealerhand.GetTotal()<21) {
                    return("House wins."+"\nYou: " + playerhand.getHand() + "   Value: " + playerhand.GetTotal() +  
                            "\n Dealer: " + dealerhand.getHand() + "    Value: " + dealerhand.GetTotal()+""
                            + "\nPress enter / click OK to return to the start menu.");
                }
            
        
                
            }
        }
            
    return("Korttisi ovat: " + playerhand.getHand() + " korttiesi arvo on: " + playerhand.GetTotal() + 
                        "\n Jakajan kortit ovat: " + dealerhand.getHand() + " joiden arvo on: " + dealerhand.GetTotal());     
    }
    
}
