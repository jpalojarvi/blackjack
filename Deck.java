/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;


public class Deck {
    
    
    static String deck [] = {"2h","3h","4h","5h","6h","7h","8h","9h","Th","Jh","Qh","Kh","Ah",
                            "2d","3d","4d","5d","6d","7d","8d","9d","Td","Jd","Qd","Kd","Ad",
                            "2s","3s","4s","5s","6s","7s","8s","9s","Ts","Js","Qs","Ks","As",
                            "2c","3c","4c","5c","6c","7c","8c","9c","Tc","Jc","Qc","Kc","Ac"};
    
    public String deal(){
        int idx = new Random().nextInt(deck.length);
        String hand = (deck[idx]);
        return hand;
        
    }

        

    

}
