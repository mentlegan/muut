package omatjutut;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * OSRS-apuohjelma-2, joka listaa tavarat, joita kannattaa high alchata.
 * Listaa myös tavaroiden ostohinnan, millä tekee voittoa.
 * Tämä ohjelma ajetaan notepad++:n versiolla, joka on nykyään @version 30.5.2020. TODO: päivitä np++ koodi ajamalla molemmat ohjelmat, koodi ei tietenkään dokumentaation kannalta ole yhtenäinen
 * @author Harri Keränen
 * @version 21.5.2020 Ohjelman ensimmäinen versio.
 * @version 30.5.2020 Lisätty Rune dagger, kokonaishinnat korjattu, isompiin lukuihin lisätty pilkut.
 * @version 22.7.2020 Lisätty sulkemisohje käyttäjälle kysyttäessä Nature Runen hintaa. Dokumentaatio päivitetty.
 */
public class HighAlch {

    private String nimi; 
    private int alchMaara;
    private int limit;
    private static int natureHinta;
    
    /**
     * @param nimi Nimi
     * @param value Alch-rahamäärä
     * @param limit GE-ostoraja
     */
    public HighAlch(String nimi, int value, int limit) {
        this.nimi = nimi;
        this.alchMaara = value;
        this.limit = limit;
    }    
    
    /**
     * @return nimi
     */
    public String getNimi() {
        return this.nimi;
    }
    
    /**
     * @return Alch rahamäärä
     */
    public int getAlchMaara() {
        return this.alchMaara;
    }
    
    /**
     * @return GE-ostoraja
     */
    public int getLimit() {
        return this.limit;
    }
    
    /**
     * @param i Alchattava tavara
     * @return Alchattavan tavaran hinnasta vähennetty nature runen hinta ja 1 (voiton takaamiseksi)
     */
    public static int getGeHinta(HighAlch i) {
        int tulos = i.getAlchMaara() - natureHinta - 1;
        return tulos;        
    }
    
    /** 
     * Tämä funktio palauttaa luvun merkkijonon tulostusta varten, ei myöhempää käsittelyä varten.
     * TODO: Tämän voisi ehkä tehdä siistimmäksi, ja kopsata omaksi ohjelmakseen myöhempää käyttöä varten.
     * @param luku annettava luku
     * @return luku jonona, jossa on pilkut
     */
    public static String lukuunPilkut(int luku) {
        String jono = Integer.toString(luku);
        StringBuilder sb = new StringBuilder("");
        
        if (jono.length() == 3) {
            sb.append(jono.charAt(0));
            sb.append(jono.charAt(1));
            sb.append(jono.charAt(2));
        }
        
        if (jono.length() == 4) {
            sb.append(jono.charAt(0));
            sb.append(',');
            sb.append(jono.charAt(1));
            sb.append(jono.charAt(2));
            sb.append(jono.charAt(3));
        }
                
        if (jono.length() == 5) {
            sb.append(jono.charAt(0));
            sb.append(jono.charAt(1));
            sb.append(',');
            sb.append(jono.charAt(2));
            sb.append(jono.charAt(3));
            sb.append(jono.charAt(4));
        }
        
        if (jono.length() == 6) {
            sb.append(jono.charAt(0));
            sb.append(jono.charAt(1));
            sb.append(jono.charAt(2));
            sb.append(',');
            sb.append(jono.charAt(3));
            sb.append(jono.charAt(4));
            sb.append(jono.charAt(5));
        }
        
        if (jono.length() == 7) {
            sb.append(jono.charAt(0));
            sb.append(',');
            sb.append(jono.charAt(1));
            sb.append(jono.charAt(2));
            sb.append(jono.charAt(3));
            sb.append(',');
            sb.append(jono.charAt(4));
            sb.append(jono.charAt(5));
            sb.append(jono.charAt(6));
        }
        
        return sb.toString();
    }
    
    /**
     * Hakee tarvittavien nature runejen määrän.
     * @param alchatavat tavarat
     * @return satsin alchaamiseen tarvittavien runejen määrä
     */
    private static int haeNatureMaarat(ArrayList<HighAlch> alchatavat) {
        int maara = 0;
        for (HighAlch highAlch : alchatavat) {
            maara += highAlch.getLimit();
        }
        return maara;
    }    
    
    /**
     * Pääohjelma on valtava lista alchattavia esineitä, jotka ovat osoittautuneet edullisiksi voittoa tavoitellessa.
     * @param args nope
     */
    public static void main(String[] args) {
        
        ArrayList<HighAlch> alchatavat = new ArrayList<HighAlch>();        
        
        HighAlch sPBody = new HighAlch("Steel platebody", 1200, 125);
        HighAlch mPLegs = new HighAlch("Mithril platelegs" ,1560, 125);
        HighAlch m2hSword = new HighAlch("Mithril 2h sword", 1560, 125);
        HighAlch mPBody = new HighAlch("Mithril platebody", 3120, 125);
        HighAlch aKShield = new HighAlch("Adamant kiteshield", 3264, 125);
        HighAlch gDHideBody = new HighAlch("Green d'hide body", 4680, 125);
        HighAlch aPBody = new HighAlch("Adamant platebody", 9984, 125);
        HighAlch rPick = new HighAlch("Rune pickaxe", 19200, 40);
        HighAlch rDagger = new HighAlch("Rune dagger", 4440, 70);
        HighAlch rMace = new HighAlch("Rune mace", 8640, 70);
        HighAlch rScimitar = new HighAlch("Rune scimitar", 15360, 70);
        HighAlch rLong = new HighAlch("Rune longsword", 19200, 70);
        HighAlch rFHelm = new HighAlch("Rune full helm", 21120, 70);
        HighAlch rSqShield = new HighAlch("Rune sq shield", 23040, 70);
        HighAlch rBattleAxe = new HighAlch("Rune battleaxe", 24960, 70);
        HighAlch rCBody = new HighAlch("Rune chainbody", 30000, 70);
        HighAlch rKShield = new HighAlch("Rune kiteshield", 32640, 70);
        HighAlch r2hSword = new HighAlch("Rune 2h sword", 38400, 70);
        HighAlch rPLegs = new HighAlch("Rune platelegs", 38400, 70);
        HighAlch rPSkirt = new HighAlch("Rune plateskirt", 38400, 70);
        HighAlch rPBody = new HighAlch("Rune platebody", 39000, 70);
               
        alchatavat.add(sPBody);
        alchatavat.add(mPLegs);
        alchatavat.add(m2hSword);
        alchatavat.add(mPBody);
        alchatavat.add(aKShield);
        alchatavat.add(gDHideBody);
        alchatavat.add(aPBody);
        alchatavat.add(rPick);
        alchatavat.add(rDagger);
        alchatavat.add(rMace);
        alchatavat.add(rScimitar); 
        alchatavat.add(rLong);
        alchatavat.add(rFHelm);
        alchatavat.add(rSqShield);
        alchatavat.add(rBattleAxe);
        alchatavat.add(rCBody);
        alchatavat.add(rKShield);
        alchatavat.add(r2hSword);
        alchatavat.add(rPLegs);
        alchatavat.add(rPSkirt); 
        alchatavat.add(rPBody);
        
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        int i = 0; //ikuisen silmukan takia
        System.out.println("Anna Nature Runen hinta, jos haluat lopettaa, kirjoita exit");
        do {                      
            
            String rivi = s.nextLine();
            if (rivi.matches("[0-9]+")) {               
                natureHinta = Integer.parseInt(rivi);            
            }
            System.out.println("Tarvitset " + haeNatureMaarat(alchatavat) + " Nature runea koko satsin alchaamiseen, maksaa " + natureHinta*haeNatureMaarat(alchatavat)+" gp");
            System.out.println("Koko satsin alchaaminen on " + haeNatureMaarat(alchatavat)*65 + " Magic XP");
            System.out.println();
            
            for (HighAlch j : alchatavat) {
                System.out.println(j.getNimi() + ", osta GE-hintaan: " + lukuunPilkut(getGeHinta(j)) + " gp");
                System.out.println(j.getLimit() + " kpl maksaa " + lukuunPilkut(j.getLimit() * getGeHinta(j)) +" gp");
                System.out.println();
            }
            
            if ( rivi.matches("exit")) {
                break; //breikkaa ikuisesta silmukasta pois kun kirjoittaa exit (kuten komentorivin sulkemisessa)
            }
            
        } while (i == 0); //ikuisen silmukan takia
                
    }
    
}