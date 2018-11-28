package blackjack;

import javax.swing.JOptionPane;

/**
 * Tämä luokka on MVC-mallin View (V) eli näyttö. Näyttö on tässä luokassa
 * toteutettu pääosin JOptionPane-avulla.
 *
 */
public class View extends Game {

    // tieto kontrollerista, jolle näyttö lähettää pyynnöt

    private Controller controller;
    
    // metodi luo näytön, joka näytetään aluksi käyttäjälle
    public void startMenu() {
        String choiceStr;      // käyttäjän valinta merkkijonona
        int choice;            // valinta numerona

        // näytetään käyttäjälle päävalikko
        choiceStr = JOptionPane.showInputDialog(null,
                "Welcome to Blackjack! Choose function (1-4) of the following: \n"
                + "1: Play \n"
                + "2: Show me the rules of Blackjack \n"
                + "3: Show chip balance \n"
                + "4: Quit \n"
                + "What do you want to do?");

        // muutetaan käyttäjän vastaus numeroksi
        choice = Integer.parseInt(choiceStr);

        // siirrytään käyttäjän haluamaan toimintoon
        switch (choice) {
            case 1:
                play();
                break;
            case 2:
                rules();
                break;
            case 3:
                // balance(); ehkä myöhemmin panos-systeemi?
                break;
            case 4:
                quit();
                break;
            default:
                // näytetään valikko uudestaan, jos ei kunnollinen valinta
                startMenu();
        }

    }
    
    public void play() {
        // pyydetään käyttäjältä lisätietoa ennen kontrollerin kutsumista
        // kontrolleri vaatii parametrina double, muutetaan se 'lennossa'.
        controller.play();
    }
    
    // näytön toimintoja
    public void showMessage(String message) {
        // Parametrina näytettävä viesti
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void showQuestion(String message) {
        // Parametrina näytettävä viesti
        String choiceStr = JOptionPane.showInputDialog(message);
        int choice = Integer.parseInt(choiceStr);
        if (choice == 1) {
            controller.hit();
        }
        else {
            controller.stand();
        }
    }
    /*
    public void balance() {
        // pyydetään kontrolleria hoitamaan toiminto, 
        // saadaan takaisin haluttu vastaus
        double balance = controller.balance();
        JOptionPane.showMessageDialog(null, "Your chip balance: " + balance + "€.");
        // siirrytään takaisin aloitusnäyttöön
        startMenu();
    }
    */
    
    /* public void pano() {
        // pyydetään käyttäjältä lisätietoa ennen kontrollerin kutsumista
        String uuttaRahaa =
                JOptionPane.showInputDialog(null, "Paljonko talletetaan?");
        // kontrolleri vaatii parametrina double, muutetaan se 'lennossa'.
        kontrolleri.talletus( Double.parseDouble(uuttaRahaa) );
    }*/
     
    public void rules() {
        
        JOptionPane.showMessageDialog(null, "The idea of BlackJack is to get a larger number than your opponents. The largest number being 21, if the number goes over you bust (lose).\n"
        + "You will be dealt two cards in the beginning and you decide whether to be \"Hit\" with a new card, or to Stand and see what the dealers hand is going to be by letting him pick cards.\n"
        + "If the Dealer has a hand of under 17 the dealer must take another card, if the dealers hand goes over 21, you win, and if its smaller you lose.\n" 
        + "In the case of a draw, the dealer always wins.");
    }
    
    public void quit() {
        JOptionPane.showMessageDialog(null, "Thanks for playing!");
        System.exit(0);
    }
    
    

    public void setController(Controller ohjain) {
        // näyttö saa tiedon kontrollerista, jolle se välittää pyyntöjä
        this.controller = ohjain;
    }

}
