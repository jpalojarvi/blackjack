package esim;

/**
 * Tämä on sovelluksen Controller (C). Tämä luokka sisältää nyt myös sovelluksen
 * käynnistyksen (main).
 *
 */
    // Tämä luokka sisältää sovelluksen toimintalogiikkaa.    
    // Tuntee MVC-mallin View-tason sekä Model-tason. 
    // View-taso kutsuu Controllerin metodeja, joten sille välitetään
    // viite tähän Controller-olioon.

public class Kontrolleri {       
    // kapseloidut ominaisuudet (V, M)
    private Naytto naytto;
    private Pankkitili malli;
    
    public Kontrolleri() {
        // Nyt kontrollerin (C) konstruktori (eli tämä metodi) 
        // luo muut tarvittavat komponentit ja pyytää sitten 
        // näyttöä esittämään aloitusnäytön.
        
        // luodaan sovelluksen tarvitsemat muut komponentit: M, V.
        malli = new Pankkitili(500);            // M, alkusaldo 500.
        naytto = new Naytto();                  // V
        
        // välitetään näytölle tieto sovelluksen kontrollerista eli
        // tämä komponentti itse (this).
        naytto.rekisteroiOhjain(this); 
        
        // pyydetään näyttöä esittämään aloitusnäyttö
        naytto.aloitusNaytto();
                        
    }
    
    // näytöltä tulevia pyyntöjä
    public double saldo() {
        double tilinSaldo = malli.getSaldo();
        return tilinSaldo;
    }
    
    public void otto(double kateisenMaara) {
        boolean onnistuiko;
        onnistuiko = malli.otto(kateisenMaara);
        // Ei kerrota nyt käyttäjälle toiminnon onnistumisesta mitään (???)
        if (onnistuiko)
        { 
            naytto.naytaViesti("Nostosi onnistui. Tililläsi on nyt " + malli.getSaldo() + "€.");
            
        }
        else {
            naytto.naytaViesti("Nostosi epäonnistui. Tililläsi on edelleen " + malli.getSaldo() + "€.");
        }
        // Näyttöä pyydetään siirtymään vain aloitusnäyttöön
        naytto.aloitusNaytto();                        
    }
    
    public void talletus(double lisaRaha) {
        malli.talletus(lisaRaha);
        // Ei kerrota nyt käyttäjälle toiminnon onnistumisesta mitään (???)
        
        // Näyttöä pyydetään siirtymään vain aloitusnäyttöön
        naytto.aloitusNaytto();
    }
    
        
    // Koko sovelluksen käynnistäminen
    public static void main(String[] args) {
        // luodaan uusi kontrolleri-olio, joka valmistelee nyt sovelluksen
        new Kontrolleri();
        
    }
}
