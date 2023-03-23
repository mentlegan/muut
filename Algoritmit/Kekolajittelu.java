package Algoritmit;

import java.util.Arrays;

/**
 * kekolajittelua käyttävä ohjelma
 * lajittelee pienimmästä suurimpaan
 * @author Harri Keränen
 * @version 27.3.2020
 */
public class Kekolajittelu {

    /**
     * @param args nope
     */
    public static void main(String[] args) {
         int t1[] = { 24, 25, 21, 1, 3, 8 };
         int t3[] = { 1, 2, 3, 4, 5, 6, 7 };
         int t2[] = { -4, 5, 1, 0, -3, -8 };
         int t4[] = { 100, -200, 400, 300 };
         
         int t5[] = new int[5]; //luodaan satunnaistaulukko
         for (int i = 0; i < t5.length; i++) {
            t5[i] = (int)(Math.random() * 100);
         }
         
         System.out.println("Alkuperäiset:");
         System.out.println("t1: " + Arrays.toString(t1));
         System.out.println("t2: " + Arrays.toString(t2));
         System.out.println("t3: " + Arrays.toString(t3));
         System.out.println("t4: " + Arrays.toString(t4));
         System.out.println("t5: " + Arrays.toString(t5));
         
         System.out.println(""); //väliä
         
         System.out.println("Lajitellut:");
         lajittele(t1);
         lajittele(t2);
         lajittele(t3);
         lajittele(t4);
         lajittele(t5);
         System.out.println("t1: " + Arrays.toString(t1));
         System.out.println("t2: " + Arrays.toString(t2));
         System.out.println("t3: " + Arrays.toString(t3));
         System.out.println("t4: " + Arrays.toString(t4));
         System.out.println("t5: " + Arrays.toString(t5));
         
    }

    /**
     * @param t taulukko
     */
    public static void lajittele(int[] t) {
        int pituus = t.length;
        
        for (int i = pituus / 2 - 1; i >= 0; i--) {
            teeKeko(t,pituus,i);
        }
        
        for (int i = pituus-1; i >= 0; i--) {
            int x = t[0];
            t[0] = t[i];
            t[i] = x;
            teeKeko(t,i,0);
        }
    }

    /**
     * @param t taulukko
     * @param koko koko
     * @param i //
     */
    public static void teeKeko(int[] t, int koko, int i) {
        int isoin = i;
        int vasen = 2*i + 1;
        int oikea = 2*i + 2;
        
        if (vasen < koko && t[vasen] > t[isoin])
            isoin = vasen;
        
        if (oikea < koko && t[oikea] > t[isoin])
            isoin = oikea;
        
        if (isoin != i) {
            int vaihto = t[i];
            t[i] = t[isoin];
            t[isoin] = vaihto;
            teeKeko(t,koko,isoin);
        }
        
    }

}