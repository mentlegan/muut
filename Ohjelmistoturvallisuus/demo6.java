package Ohjelmistoturvallisuus;

/**
 * @author Harri Keränen
 * @version 8.5.2022
 * Tarkastetaan, että aiheuttaisiko kertolasku integer-ylivuodon.
 * TODO: EI TOIMI jostain syystä, varmaan koska java ei osaa mitenkään
 * käsitellä liian isoja int-kokoja.
 */
public class demo6 {
    /**
     * @param args nope
     */
    public static void main (String[] args) {
        int luku1 = 1000000000;
        int luku2 = 250000000;
        System.out.println(onkoYlivuotoa(luku1, luku2));
    }

    private static boolean onkoYlivuotoa(int luku1, int luku2) {        
        if (luku1 * luku2 < Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
}