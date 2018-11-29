/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;


public class Controller extends Game {
    // kapseloidut ominaisuudet (V, M)
    private View view;
    // private Hand hand;
    
    Game startgame;
    
    
    public Controller() {
        // Nyt kontrollerin (C) konstruktori (eli tämä metodi) 
        // luo muut tarvittavat komponentit ja pyytää sitten 
        // näyttöä esittämään aloitusnäytön.
        
        // luodaan sovelluksen tarvitsemat muut komponentit: M, V.
        /* playerhand = new Hand();            // M, alkusaldo 500.
        dealerhand = new Hand();
        cardpack = new Hand();
        */
        view = new View();                  // V
        
        // välitetään näytölle tieto sovelluksen kontrollerista eli
        // tämä komponentti itse (this).
        view.setController(this); 
        
        startgame = new Game();
        // pyydetään näyttöä esittämään aloitusnäyttö
        view.startMenu();
        
        
                        
    }
    
    /*
    // näytöltä tulevia pyyntöjä
    public double balance() {
        double cardBalance = cardpack.getBalance();
        return cardBalance;
    }
    */
    
    /*public void take(double card) {
        boolean successcheck;
        successcheck = cardpack.takecard(cards);
        // Ei kerrota nyt käyttäjälle toiminnon onnistumisesta mitään (???)
        if (successcheck)
        { 
            view.showMessage("Nostosi onnistui. Tililläsi on nyt " + malli.getSaldo() + "€.");
            
        }
        else {
            view.showMessage("Nostosi epäonnistui. Tililläsi on edelleen " + malli.getSaldo() + "€.");
        }
        // Näyttöä pyydetään siirtymään vain aloitusnäyttöön
        view.startMenu();                        
    }
    */
    
    /*
    public void talletus(double lisaRaha) {
        view.talletus(lisaRaha);
        // Ei kerrota nyt käyttäjälle toiminnon onnistumisesta mitään (???)
        
        // Näyttöä pyydetään siirtymään vain aloitusnäyttöön
        view.startMenu();&
    }
    */
    
    public void play() {
        // pelilogiikka tänne?
        // startgame();
        // askplayerhitorstand();
        // ifHit jne....??
        view.showMessage("Starting the game!");
        String vastaus = startgame.startGame(); 
        view.showQuestion(vastaus);
    }
    
    public void hit() { // pelaajalle annetaan yksi kortti lisää
        String hittered = startgame.Hit();
        view.showQuestion(hittered);
        gamestate();
    }
        
    public void stand() { // pelaaja on lopettanut 
        String stood = startgame.Stand();
        view.showQuestion(stood);
    }
    
    public void question(String message) {
        view.showMessage(message);
    }

    
    // Koko sovelluksen käynnistäminen
    public static void main(String[] args) {
        // luodaan uusi kontrolleri-olio, joka valmistelee nyt sovelluksen
        Controller controller = new Controller();
        
    }
} 
