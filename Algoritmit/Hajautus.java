package Algoritmit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Ohjelma lisää taulukkoon kokonaislukuja käyttäen hajautusta
 * ts. jokaiselle kokonaisluvulle annetaan avain, joka on myös kokonaisluku
 * Jos taulukossa on arvo 0, se tarkoittaa, että paikka on VAPAA
 * @author Harri Keränen
 * @version 31.3.2020
 */
public class Hajautus {
    
    private static int avain = 1;

    /**
     * @param args nope
     */
    public static void main(String[] args) {
        Random rand = new Random();
        int m = 10; //taulukon koko
        int[] t = new int[m]; //luvut
        ArrayList<Integer> a = new ArrayList<>(10); //avaimet
        
        
        for (int i = 1; i < m+10; i++) { //avaintaulukkoon satunnaisia lukuja, voisi tehdä myös vaikka merkkijonoja esim. "one" "two"?
            a.add(i); 
        }
        Collections.shuffle(a); //jokainen avain on kuitenkin erilainen, 
                                //koska yllä oleva silmukka suoritetaan aina enemmän kuin m kertaa
                                     
        System.out.println(Arrays.toString(t)+" <-- Taulukossa ovat paikat vielä vapaana" );
        System.out.println("Lisäys- ja poistometodien jälkeen:");
        System.out.println("(luku) = (avain)");
        
        //t[6] = lisaa(6); //voit ottaa tämän pois kommenteista virheen testaamiseksi
        for (int i = 2; i < m; i++) { //jätetään kaksi ensimmäistä paikkaa vapaaksi testauksen takia           
            if (t[i] > 0) {
                System.err.println("Taulukossa ei ole vapaita paikkoja!"); //virheilmoitus, jos yritetään lisätä varattuun paikkaan                
            }
            t[i] = lisaa(rand.nextInt(50)+1); //lukutaulukkoon satunnaisia lukuja, jotka ovat isompia kuin 0
        }
        
            t[7] = poista();
            t[4] = poista(); // poistetaan alkioita
            t[4] = lisaa(22); // lisätään tilalle jokin arvo
            t[0] = lisaa(49); // lisätään tyhjäksi jätettyyn kohtaan jotain
            //lisäyksiä ja poistoja voi siis tehdä mielensä mukaan, kunhan tilaa riittää
            
 
        for (int i = 0; i < m; i++) {
            if (t[i] == -1) {
                System.out.println(t[i] +" = "+ haeAvain(a) + ", alkio on POISTETTU");                           
            } else if (t[i] == 0) {
                System.out.println(t[i] + " = " + haeAvain(a) + ", paikka on VAPAA");
            } else
            System.out.println(t[i]+" = "+haeAvain(a));
        }
        
    }
    

    /**
     * @param a avaintaulukko, johon on mainissa lisätty avaimia kokonaislukumuodossa
     * @return avaimen luku, ei voi olla sama kuin toinen avain
     */
    public static int haeAvain(ArrayList<Integer> a) {
        int avainLuku = 1;
        avainLuku += a.indexOf(avain);
        avain++;
        return avainLuku;
    }


    /**
     * @param alkio lisättävä alkio
     * @return lisättävä alkio
     */
    public static int lisaa(int alkio) {
        return alkio;
    }
    

    /**
     * @return -1 tarkoittaa POISTETTU
     */
    public static int poista() {
        return -1;
    }
    
}