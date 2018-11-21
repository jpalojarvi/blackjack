package blackjack;

/**
 *
 * @author Johannes Palojärvi <johannes.palojarvi@metropolia.fi>
 */
public class Controller {
    // kapseloidut ominaisuudet (V, M)
    private View view;
    // private Hand hand;
    
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
        // game logic goes here? need card pack first. 
        
    }
    
            
    // Koko sovelluksen käynnistäminen
    public static void main(String[] args) {
        // luodaan uusi kontrolleri-olio, joka valmistelee nyt sovelluksen
        new Controller();
        
    }
}

