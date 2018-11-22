/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blackjack;

/**
 *
 * @author Mkayyee
 */
public class Hand extends Deck {
    
    int value;
    char cString;
    private List<String> wholehand = new ArrayList();
    int totalvalue;
    
    
    public void getHand(){              // tulostaa koko käden
        for (String hand : wholehand)    
            System.out.print(hand+" "); 
    }
    public void addHand(String x){   // lisää kortin jo olemassa olevien joukkoon
        wholehand.add(x)
    }
    public void pAddTotal(int add){     // ei tällä hetkellä mitään käyttöä, ehkä tarpeellinen
        totalvalue = totalvalue + add;
    }
    public int GetTotal(){              // palauttaa käden arvon summan
        return totalvalue;
    }
    public void addValue(String card){  // ottaa ekan merkin kortista ja muuntaa sen str muotoon, jos kuvakortti -> 
                                        // lisää käden summaan 10, muuten parseroi suoraan intiksi ja lisää käden summaan            
        cString = card.charAt(0);
        String cardo = String.valueOf(cString);
        
        if (cardo.equals("T") || cardo.equals("Q") || cardo.equals("J") || cardo.equals("K")){
            totalvalue += 10;
        }
        else if (cardo.equals("A"))
            totalvalue += 11;
        else
            totalvalue += Integer.parseInt(cardo);

    }
}
