/**
 * 
 */
package omatjutut;

/**
 * Rationaalilukujen joukko on numeroituva.
 * @author Harri Keränen
 * @version 9.5.2020
 */
public class NumeroituvaFunktio {

    /**
     * @param args nope
     */
    public static void main(String[] args) {
        System.out.println(f(4,1));
    }

    private static int f(int m, int n) {
        int tulos = (((m+n)*(m+n-1))/2)-m+1;
        return tulos;
    }

}
