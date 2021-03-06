package blackjack;

import javax.swing.JOptionPane;


public class View extends Game {

    

    private Controller controller;

    
    public void startMenu() {
        String choiceStr;     
        int choice;           

      
        choiceStr = JOptionPane.showInputDialog(null,
                "Welcome to Blackjack! Choose function (1-4) of the following: \n"
                + "1: Play \n"
                + "2: Show me the rules of Blackjack \n"
                + "3: Show chip balance \n"
                + "4: Quit \n"
                + "What do you want to do?");

        
        choice = ConvertIntoNumeric(choiceStr);

        
        switch (choice) {
            case 1:
                play();
                break;
            case 2:
                rules();
                break;
            case 3:
                
                break;
            case 4:
                quit();
                break;
            default:
                startMenu();
        }

    }
    
    public void play() {
        
        controller.play();
    }
    
 
    public void showMessage(String message) {
      
        JOptionPane.showMessageDialog(null, message);
    }
    
    public void showQuestion(String message) {
        
        String choiceStr = JOptionPane.showInputDialog(message);
        int choice = ConvertIntoNumeric(choiceStr);
        switch (choice) {
            
            case 0:
                
                Game.gamestate = false;
                startMenu();
                break;
                
            case 1:
                
                if (gamestate == false){
                    controller.hit();
                }
                else
                    gamestate = false;
                    startMenu();
                            
                
                break;
                
            case 2:
                
                if (gamestate == false){
                    controller.stand();
                }
                else
                    gamestate = false;
                    startMenu();
            
            default:
                Game.gamestate = false;
                startMenu();
                break;
        }
        
    }
    private int ConvertIntoNumeric(String xVal)
        {
         try
          { 
             return Integer.parseInt(xVal);
          }
         catch(Exception ex) 
          {
             return 0; 
          }
        }
   
    public void rules() {
        
        JOptionPane.showMessageDialog(null, "The idea of BlackJack is to get a larger number than your opponents. The largest number being 21, if the number goes over you bust (lose).\n"
        + "You will be dealt two cards in the beginning and you decide whether to be \"Hit\" with a new card, or to Stand and see what the dealers hand is going to be by letting him pick cards.\n"
        + "If the Dealer has a hand of under 17 the dealer must take another card, if the dealers hand goes over 21, you win, and if its smaller you lose.\n" 
        + "In the case of a draw, the dealer always wins.");
        startMenu();
    }
    
    public void quit() {
        JOptionPane.showMessageDialog(null, "Thanks for playing!");
        System.exit(0);
    }
    
    

    public void setController(Controller ohjain) {
     
        this.controller = ohjain;
    }


}
