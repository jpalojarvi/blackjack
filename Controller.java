/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;


public class Controller extends Game {
    private final View view;
    Game state;
    Game startgame;
    
    
    public Controller() {
        
        view = new View();                  // V
        view.setController(this); 
        startgame = new Game();
        view.startMenu();
        
        
                        
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
        
        Controller controller = new Controller();
        
    }
} 
