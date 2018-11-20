package esim;

import javax.swing.JOptionPane;

/**
 * @author ratyj 
 * Tämä on MVC-sovelluksen Malli (M) eli dataluokka.
 */

public class Pankkitili {   
    // kapseloidut ominaisuudet
    private double saldo;

    // konstruktori, joka vaatii alkusaldon
    public Pankkitili(double saldo) {
        this.saldo = saldo;
    }

    // palauttaa tilin saldon
    public double getSaldo() {
        return saldo;
    }

    // Otetaan tililtä rahaa pois. Palauttaa tiedon että onnistuiko.
    // Tililtä nosto onnistuu vain, jos tilillä on tarpeeksi rahaa.
    // Parametrina haluttu noston määrä.
    public boolean otto(double maara) {
        
        // onko tilillä tarpeeksi rahaa?     
        if (saldo >= maara) {
            // jos saldoa on riittävästi, niin vähennetään siitä
            // noston määrä. Ja palautetaan tieto onnistuneesta nostosta.
            saldo = saldo - maara;
            return true;
        } else {
        
            // tilillä ei ollut tarpeeksi rahaa.
            // Palautetaan tieto epäonnistuneesta nostosta.
            return false;
        }                
        
    }

    // Talletetaan tilille lisää rahaa. 
    // Parametrina lisättävän rahan määrä.
    public void talletus(double määrä) {
        // kasvatetaan saldoa saadulla rahamäärällä.
        this.saldo += määrä;
    }
    
}
