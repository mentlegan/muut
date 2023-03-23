package koodailua;

/**
 * @author Harri Keränen
 * @version 1.0, 31.3.2020
 * Ohjelma laskee keskiarvon joko kokonaisluvuista(keskiarvoI), tai desimaaliluvuista(keskiarvoD)
 */
public class Keskiarvo {
    public static void main(String args[]) {
      int[] katselukerrat = new int[] {46856,28407,13692,1237,1195,816,792,722,704,547,504,367,328,196,177,167,156,101,73,67,67,67,63,62,62,59,47,44,40,40,36,34,33,33,33,34,28,28,27,25,24,23,22,21,20,20,20,20,18,17,14,12,11,11,11,10,9,9,8,8,8,6,7,6,6,6,6,6,5,4,4,4,3,2,2,1};
      int arvo = keskiarvoI(katselukerrat); //youtube-videoideni katselukerrat :)
      
      double[] desimaalit = new double[] {0.25,0.5,0.75,1.0};
      double arvo2 = keskiarvoD(desimaalit);
      
      System.out.println(arvo);
      System.out.println(arvo2);
    }
    
    /**
     * Laske keskiarvon kokonaisluvuista
     * @param luvut Lukujoukko, jonka keskiarvo lasketaan
     * @returns Keskiarvon (pyöristää alaspäin)
     */
    public static int keskiarvoI(int[] luvut) {
        int summa = 0;
        for(int i : luvut) {
            summa += i;
        }
        int tulos = summa / luvut.length;
        return tulos;
    }
    
    /**
     * Laskee keskiarvon desimaaliluvuista
     * @param luvut Lukujoukko, jonka keskiarvo lasketaan
     * @returns Keskiarvon
     */
    public static double keskiarvoD(double[] luvut) {
        double summa = 0;
        for(double i : luvut) {
            summa += i;
        }
        double tulos = summa / luvut.length;
        return tulos;
    }
}