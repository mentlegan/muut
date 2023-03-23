package Algoritmit;

import java.util.Arrays;

/**
 * Esimerkki union-find-operaatioista.
 * @author Harri Keränen
 * @version 15.4.2020
 */
public class UnionFind {

    private static int laskuri = 0; //findIndexin apu
    private static String[] pj = {"kiuru", "lokki", "rastas", "sorsa", "varis"}; //perusjoukko
    
    /**
     * @param args nope
     */
    public static void main(String[] args) {
                
        String[] oj1 = union2(findString(pj, 1),findString(pj, 0)); //otetaan kaksi pääjoukon alkiota, ja yhdistetään ne osajoujoksi, eli "kiuru" + "lokki"
        String[] oj2 = unionJ(oj1,findString(pj,2)); //liitetään oj1:seen uusi alkio, eli [kiuru, lokki] + "rastas"
        String[] oj3 = union(oj1,oj2); //liitetään oj1 ja oj2 omaksi joukokseen, eli [kiuru, lokki] + [kiuru, lokki, rastas]
        
        String jono = "rastas"; //vaihda tähän mikä tahansa merkkijono, loytyyko-funktio selvittää, että onko sitä kyseisessä joukossa
        if (loytyyko(pj, jono) == true) {
            System.out.println("Alkio " + '"'+jono+'"' + " löytyy joukosta!");
        } else System.out.println("Alkio " + '"'+jono+'"' + " ei löydy joukosta!");
        
        System.out.println(Arrays.toString(oj1)); //tulostaa [kiuru, lokki]
        System.out.println(Arrays.toString(oj2)); //tulostaa [kiuru, lokki, rastas] (rastas lisätty)
        System.out.println(Arrays.toString(oj3)); //tulostaa [kiuru, lokki, kiuru, lokki, rastas] (yhdistetty)
        
        System.out.println(findIndex(pj, "rastas")); //nämä tulostavat indeksin, jotka vastaavat niille annettuja merkkijonoja
        System.out.println(findIndex(pj, "lokki"));
        
        System.out.println(findString(pj, 1)); //tulostavat indeksiä vastaavan merkkijonon
        System.out.println(findString(pj, 4));
        
        String jono2 = "rastas"; //vaihda tähän mikä tahansa merkkijono, loytyyko-funktio selvittää, että onko sitä kyseisessä joukossa
        if (loytyyko(oj1, jono2) == true) {
            System.out.println("Alkio " + '"'+jono2+'"' + " löytyy joukosta!");
        } else System.out.println("Alkio " + '"'+jono2+'"' + " ei löydy joukosta!");
    }
    
    
    /**
     * Tarkistaa, että löytyykö jokin merkkijono joukosta.
     * @param joukko Joukko, jota käsitellään
     * @param jono Merkkijono, jota etsitään
     * @return true jos löytyy, false jos ei
     */
    private static boolean loytyyko(String[] joukko, String jono) {
        for (String string : joukko) {
            if (string == jono) {
                return true;
            }
        }
        return false;
    }


    /**
     * Yhdistä kaksi osajoukkoa omaksi osajoukokseen.
     * @param oj1 osajoukko 1
     * @param oj2 osajoukko 2
     * @return uusi osajoukko
     */
    private static String[] union(String[] oj1, String[] oj2) {
        String tulos[] = new String[oj1.length + oj2.length];
        for (int i = 0; i < oj1.length; i++) {
            tulos[i] = oj1[i];
        }
        int j = oj1.length;
        for (int i = 0; i < oj2.length; i++) {
            tulos[j] = oj2[i];
            j++;
        }
        return tulos;
    }
    
    
    /**
     * Liittää alkion osajoukkoon.
     * @param oj Osajoukko, johon liitetään
     * @param jono Jono, joka liitetään
     * @return Muutettu osajoukko
     */
    private static String[] unionJ(String[] oj, String jono) {
        String tulos[] = new String[oj.length+1];
        tulos[0] = oj[0];
        tulos[1] = oj[1];
        tulos[2] = jono;
        return tulos;
    }
    

    /**
     * Yhdistää kaksi joukon alkiota osajoukoksi.
     * @param j1 jono 1
     * @param j2 jono 2
     * @return Osajoukko kahdesta alkiosta
     */
    private static String[] union2(String j1, String j2) {
        String[] tulos = new String[2];
        if (findIndex(pj, j1) < findIndex(pj, j2)) {            
            tulos[0] = j1;
            tulos[1] = j2;
        }
        
        if (findIndex(pj, j1) > findIndex(pj, j2)) {            
            tulos[0] = j2;
            tulos[1] = j1;
        }
        return tulos;
    }


    /**
     * Rekursiivinen silmukka, joka etsii indeksin merkkijonon mukaan.
     * @param pj Joukko, josta etsitään
     * @param string Merkkijono, jonka indeksiä etsitään
     * @return etsii annetun merkkijonon indeksin
     */
    private static int findIndex(String[] paajoukko, String string) {
        String j = findString(pj, laskuri); // String j = pj[laskuri]; tämä toimisi myös
        if (string == j) {
            int index = laskuri;
            laskuri = 0; //nollataan, että attribuuttia voidaan käyttää monta kertaa
            return index;            
        }                
        laskuri++;
        return findIndex(paajoukko, string);
    }


    /**
     * Etsii merkkijonon indeksin mukaan.
     * Toimii itseasiassa täysin samalla tavalla kuin esim pj[i].
     * @param pj Joukko, mistä etsitään
     * @param index Indeksi, jonka merkkijono etsitään
     * @return Merkkijono, joka on annetun indeksin kohdalla
     */
    private static String findString(String[] paajoukko, int index) {
        return paajoukko[index];
    } 
    
}