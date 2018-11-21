package blackjack;
import java.util.Random;

public class Hands // purpose similar to Pankkitili.java example?

/**
 *
 * @author Mkayyee
 */
public class deck {
    
    
    static String deck [] = {"1h","2h","3h","4h","5h","6h","7h","8h","9h","Th","Jh","Qh","Kh","Ah",
                      "1d","2d","3d","4d","5d","6d","7d","8d","9d","Td","Jd","Qd","Kd","Ad",
                      "1s","2s","3s","4s","5s","6s","7s","8s","9s","Ts","Js","Qs","Ks","As",
                      "1c","2c","3c","4c","5c","6c","7c","8c","9c","Tc","Jc","Qc","Kc","Ac"};
    
    public static String deal(){
        int idx = new Random().nextInt(deck.length);
        String hand = (deck[idx]);
        return hand;
        
    }
