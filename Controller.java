package blackjack;

import Blackjack.Chips;


public class Controller extends Game {
    private View view;
    Game state;
    Game startgame;
    private static Chips chips = new Chips(1000);
    int gain;
    static int balanssi;
  
    public Controller() {
        
        view = new View();                  // V
        view.setController(this); 
        startgame = new Game();
        view.startMenu();
        
        
        
        
                        
    }
    public static int chipAmount(){
        balanssi = chips.getChips();
        return balanssi;
        
    }
    public int showChips(){
        return chips.getChips();
    }
    
    public static void bet(int amount){
        chips.addChips(-amount);
    }
    
    public static void win(int winnings){
        chips.addChips(winnings);
    }
  
    
    
    public void play() {
        view.showMessage("Starting the game!");
        String vastaus = startgame.startGame(); 
        view.showQuestion(vastaus);
    }
    
    public void hit() { // pelaajalle annetaan yksi kortti lisää
        String hittered = startgame.Hit();
        view.showQuestion(hittered);
        
    }
        
    public void stand() { // jakajalle niin paljon kortteja että blackjack ehdot täyttyvät
        String stood = startgame.Stand();
        view.showQuestion(stood);
    }
    
    public void question(String message) {
        view.showMessage(message); 
    }

    
   
    public static void main(String[] args) {
        
        new Controller();
        
    }
    
} 
