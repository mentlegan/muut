package Ohjelmistoturvallisuus;

import java.util.Scanner;

/**
 * @author Harri Keränen
 * @version 23.4.2022
 * Ohjelmistoturvallisuuden perusteet demo4
 * 1. Javan oma kirjasto lokien kirjoitukseen on java.util.logging,
 * jota käytetään tässä ohjelmassa.
 * Kohdat 2 - 4 dokumentoitu ohjelman puolella.
 */
public class demo4 {
    
/**    // Kohdan 2 muuttuja, kts. pääohjelma.
    private static final java.util.logging.Logger loki =
            java.util.logging.Logger.getLogger("ohjelma");
    
    // Kohdan 2 aliohjelma, kts. pääohjelma
    private static void lokiEsim(String viesti, String varoitus,
            Exception e) {
        
        // Yksinkertainen viesti info-tasolle
        loki.info(viesti);
        
        // Tehdään varoitus
        loki.log(java.util.logging.Level.WARNING, varoitus, e);
    }
    
    /**
     * @param args nope
     */
    public static void main(String[] args) {
        
        // 2. Näissä ohjelmissa voitaisiin väärentää loki.
        // Hyökkääjä voi aina hallita mitä lokiin kirjoitetaan hallitsemalla HTTP-
        // pyyntöä. Lokiin voidaan injektoida esim. HTML-koodia siinä toivossa,
        // että log-tiedostot katsotaan web-ohjelmassa.
        
        // loki.setLevel(java.util.logging.Level.FINE);        
        // lokiEsim("Hello World", "Hello World", new Exception("Hello World"));
        
        
        // 3. ja 4. Yksinkertainen kyselevä validointi voisi toimia ennen
        // lokia tekevien rivien suorittamista. Tämä esimerkki tehty käsin.
        // Salasana voi olla rakenteinen tietotyyppi vaikkapa string-muodossa.
        // Ongelmana on lähdekoodiin käsiksi pääsy salasanan
        // kalasteluun tämän esimerkkiohjelman tapauksessa.
        // En löytänyt java.util.logging - kirjastosta injektioiden estoon
        // sopivia esimerkkejä.
        // Tallettaminen tietokantaan olisi myös oiva keino estää loki-injektio
        // Tähän en valitettavasti löytänyt järkevää esimerkkiä.
        // Tietokantaan tallennus voisi puolestaan olla altis SQL-injektiolle.
        int i = 0;
        String salasana = "rasvakattila";
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        System.out.println("Anna salasana tai kirjoita exit sulkeaksesi");
        do {
            String rivi = s.nextLine();
            
            if (rivi.matches(salasana)) {
                System.out.println("Salasana oikein!");
                break; // tähän voitaisiin korvata lokin
                       // onnistunut teko
            }
            
            if (!rivi.matches(salasana) && !rivi.matches("exit")) {
                System.out.println("Salasana väärin!");
                // ohjelma jatkuu tästä normaalisti ja jatkaa kyselyä
            }
            
            if (rivi.matches("exit")) {
                break; // exit-komennolla ohjelma sulkeutuu
            }
            
        } while (i == 0); //ikuisen silmukan takia
    }
}
