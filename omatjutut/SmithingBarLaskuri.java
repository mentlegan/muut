package omatjutut;

import java.util.Scanner;

/**
 * OSRS-apuohjelma-1, joka laskee xp-matematiikkaa nopeasti pelaajan puolesta.
 * Ohjelma laskee tarvittavien barien määrän olettaen, että pelaaja smithaa platebodyja, tällöin pelaaja tietää täsmälleen että montako baria hänen on hankittava.
 * @author Harri Keränen
 * @version 10.8 Major revamp: tehty komentorivimäinen versio: käyttäjältä kysytään, että mitä materiaalia käyttää, ja sitten tarvittavan xp-määrän, minkä pelaaja on laskenut itse.
 * Ottaa ironia käytettäessä huomioon ring of forgingin käytön.
 * Bonuksena lasketaan mining-xp, jos pelaaja haluaa kerätä orensa itse.
 */
public class SmithingBarLaskuri {
        
    /**
     * @param args nope
     */
    public static void main(String[] args) {
        
        int i = 0;
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);        
        System.out.println("Kirjoita, mitä materiaalia käytät");
        System.out.println("Bronze");
        System.out.println("Iron");
        System.out.println("Steel");
        System.out.println("Mithril");
        System.out.println("Adamant");
        System.out.println("Runite");
        System.out.println("Komento exit sulkee ohjelman");
        double barXp = 0; //yhden barin smeltauksen smithing xp
        double pBodyXp = 0; //yhden platebodyn smithing xp
        int tarvittavaXp = 0; //tarvittava xp, minkä pelaaja kirjoittaa komentoriville
        int miningXp = 0; //yhden barin mining xp
        
        do {
            String rivi = s.nextLine();
            
            if (rivi.matches("exit")) {
                break;
            }
            
            if (rivi.matches("Bronze")) {
                barXp = 6.2;
                pBodyXp = 62.5;
                miningXp = 35;
                System.out.println("Aseta tarvittava xp määrä");
            }
            
            if (rivi.matches("Iron")) {
                barXp = 12.5;
                pBodyXp = 125;
                miningXp = 35;
                System.out.println("Aseta tarvittava xp määrä");
            }
            
            if (rivi.matches("Steel")) {
                barXp = 17.5;
                pBodyXp = 187.5;
                miningXp = 135;
                System.out.println("Aseta tarvittava xp määrä");
            }
            
            if (rivi.matches("Mithril")) {
                barXp = 30;
                pBodyXp = 250;
                miningXp = 280;
                System.out.println("Aseta tarvittava xp määrä");
            }
            
            if (rivi.matches("Adamant")) {
                barXp = 37.5;
                pBodyXp = 312.5;
                miningXp = 395;
                System.out.println("Aseta tarvittava xp määrä");
            }
            
            if (rivi.matches("Runite")) {
                barXp = 50;
                pBodyXp = 375;
                miningXp = 525;
                System.out.println("Aseta tarvittava xp määrä");
            }
            
            if (rivi.matches("[0-9]+") && rivi.length() > 2) {
                tarvittavaXp = Integer.parseInt(rivi);
                int tarvittavat = laskeBarit(barXp, pBodyXp, tarvittavaXp); //homman ydin: tarvittavat barit xp-määrää varten
                System.out.println("Tarvitset " + tarvittavat + " baria");
                System.out.println("Jos itse mainaat kaiken, saat " + tarvittavat * miningXp + " verran mining xp:tä");
                if (barXp == 12.5) { //tällä tunnisetaan ironin käyttö, joten osataan ottaa ring of forging huomioon
                    System.out.println("Huomioi ring of forgingit! Tarvitset " + tarvittavat + " chargea, jonka perusteella");
                    System.out.println("tarvitset ainakin " + tarvittavat / 140 + " täyttä ring of forgingia");
                }
            }
            
        } while (i == 0); //ikuisen silmukan takia

    }

    /** 
     * Funktio ottaa bareista saatavan xp:n, ja bodyistä saatavan xp:n ja laskee ne yhteen, kertoen, että montako baria pelaaja tarvitsee haluamaansa xp-määrään.
     * @param barXp barin smeltauksesta saatava xp
     * @param pBodyXp bodyn smithauksesta saatava xp
     * @param tarvittavaXp pelaajan laskema tarvittava xp määrä (yleensä johonkin leveliin)
     * @return tarvittavien barien määrä annettuun xp-määrään asti
     */
    private static int laskeBarit(double barXp, double pBodyXp, double tarvittavaXp) {
        int bodyja = 1; //bodyja smithataan aina vähintään yksi leveliä varten
        for (int i = 0; i < Integer.MAX_VALUE; i++) { //tämän voisi tehdä helpommin (tekee nimittäin äärettömän määrän silmukoita, kunnes saatu xp ylittää tarvittavan xp:n
            int bareja = bodyja * 5; //bodyt ovat aina 5 baria
            double xp = bodyja * pBodyXp + bareja * barXp; //tässä lasketaan silmukassa saatu xp-määrä yhteen
            if (xp > tarvittavaXp) { //jos xp:tä on tarpeeksi--
                return bareja;       //--> voidaan palauttaa arvo
            }                        //...
            bodyja++;                //muuten lisätään tarvittavia bodyja yhdellä
        }                            //...
        return 0;                    //ja tämä nyt ei oikeastaan koskaan toteutu :P
    }

}