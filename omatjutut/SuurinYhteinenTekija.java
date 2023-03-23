package omatjutut;

/**
 * Eukleideen algoritmin toteutus.
 * Löytää kahden luonnollisen luvun suurimman yhteisen tekijän.
 * @author Harri Keränen
 * @version 15.4.2022
 */
public class SuurinYhteinenTekija {

    /**
     * @param args nope
     */
    public static void main(String[] args) {
        int n = 1000;
        int m = 1;
        System.out.println("n | m");
        System.out.println("Suurin yhteinen tekijä: "+syt(n, m));
        System.out.println("Algoritmin kierroksia: "+kiekat(n,m));
        System.out.println("Suurin yhteinen tekijä: "+sytV(n, m));
        System.out.println("Algoritmin kierroksia: "+kiekatV(n,m));
    }

    
    /**
     * Hakee lukujen n ja m suurimman yhteisen tekijän käsittelemällä niitä siten,
     * että jokaisella kierroksella n:n paikalle tulee m ja m:n paikalle tulee
     * n mod m, kunnes m = 0.
     * @param n1 n
     * @param m1 m
     * @return Lukujen n ja m yhteinen tekijä.
     */
    private static int syt(int n1, int m1) {
        int n = n1;
        int m = m1;
        while (m!= 0) {
            int k = n % m;
            n = m;
            m = k;
            if (n >= 10) {                
                System.out.println(n+ "|" +m);
            } else System.out.println(n+ " |" +m);            
        }
        return n;
    }
    
    
    /**
     * Vähennyslaskukeino.
     * TODO: Ei täydellinen (antaa oikeat luvut ja vastauksen, mutta välivaiheiden m ja n voivat olla sekaisin).
     * @param n1
     * @param m1
     * @return
     */
    private static int sytV(int n1, int m1) {
        int n = n1;
        int m = m1;
        while (m != n) {
            if (n > m) {
                n = n - m;
            } else m = m - n;
            
            if (n >= 10) {                    
                 System.out.println(n+ "|" +m);
            }
            
            if (n < 10) {                  
                 System.out.println(n+ " |" +m);
            }
        }
        return n;
    }
    
    
    /**
     * Laskee, että montako kierrosta algoritmi tekee.
     * @param n1 n
     * @param m1 m
     * @return Algoritmin kierrosmäärän
     */
    private static int kiekat(int n1, int m1) {
        int kiekat = 0;
        int n = n1;
        int m = m1;
        while (m!= 0) {
            int k = n % m;
            n = m;
            m = k;
            kiekat++;
        }
        return kiekat;
    }
    
    /**
     * Laskee, että montako kierrosta algoritmin vähennyslaskukeino tekee.
     * Ei anna ihan täysin tarkkaa lukua.
     * @param n1 n
     * @param m1 m
     * @return Algoritmin kierrosmäärän
     */
    private static int kiekatV(int n1, int m1) {
        int n = n1;
        int m = m1;
        int kiekat = 1;
        while (m != n) {
            if (n > m) {
                n = n - m;
            } else m = m - n;
            
            if (n >= 10) {                    
                 System.out.println(n+ "|" +m);
            }
            
            if (n < 10) {                  
                 System.out.println(n+ " |" +m);
            }
        kiekat++;
        }
        return kiekat;
    }
}