package Ohjelmistoturvallisuus;

/**
 * @author Harri Keränen
 * @version 15.5.2022
 * Tehtävien vastaukset alla olevassa dokumentaatiossa numeroituina.
 */
public class demo7 {
    /**
     * @param args nope
     */
    public static void main (String[] args) {
        String viiskyt = "Tässäpä merkkijonossa on tarkoitus olla 50 merkkiä";
        System.out.println("merkkijono viiskyt: " + viiskyt);
        System.out.println("Viiskyt-nimisessä merkkijonossa on " + viiskyt.length() + " merkkiä.");
                
        StringBuilder aa = new StringBuilder();
        char a = 'A';
        for (int i = 0; i < 50; i++) {
            aa.append(a);
        }
        String toinen = aa.toString();
        System.out.println("merkkijono toinen: " + toinen);
        System.out.println("Tässä toinen-nimisessä merkkijonossa on " + toinen.length() + " merkkiä.");
        
        
        // 1. Merkkijonoja on mahdollista verrata matches-funktiolla.
        // Tämä ei kuitenkaan ole turvallista, sillä funktio
        // antaa falsen heti, kun ensimmäinenkin merkki on väärin.
        // Tästä voidaan alkaa päätellä salaista merkkijonoa
        // ohjelman suoritusnopeuden perusteella.
        if (viiskyt.matches(toinen)) {
            System.out.println("Merkkijonot ovat samat.");
        } else {
            System.out.println("Merkkijonot eivät ole samat.");
        }
        
        if (viiskyt.matches(viiskyt)) {
            System.out.println("viiskyt == viiskyt");
        }
        
        // 2. Javaan olisi mahdollinen tehdä uusi vertailua tekevä funktio niin että,
        // se ei ole riippuvainen merkkijonojen pituuksista.
        // ts. algoritmin pitäisi ainakin:
        // - Verrata kaikki merkit ennen return-osuutta (true tai false),
        //   returnin tulo liian aikaisin vuotaa tietoa ja antaa mahdollisuuden hyökkääjälle
        // - Verrata samanpituiset merkkijonot,
        //   jos yksi merkkijono on toista pidempi, return tulee jälleen liian aikaisin,
        //   ja vuotaa tietoa salaisen merkkijonon pituudesta.
    }
}
