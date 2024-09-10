package kap_1_3_ordnede_tabeller;

import java.util.Arrays;
import lib.Tabell;

public class Oppgave_1_3_3 {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(10);
        int[] b = a.clone();

        System.out.println("Usortert tallrekke: "+Arrays.toString(a));
        omvendtBoblesortering(b);
        // Oppgave 1
        Tabell.boblesortering(a);

        System.out.println("Boblesortering: "+Arrays.toString(a));
        System.out.println("Omvendt boblesortering: "+Arrays.toString(b));
    }

    /* Dette er en litt mer avansert boblesortering.

    public static void boblesortering(int[] a) {
        for (int n = a.length; n > 1; ) {            // n er intervallgrense
            int byttindeks = 0;                      // hjelpevariabel
            for (int i = 1; i < n; i++) {              // går fra 1 til n
                if (a[i - 1] > a[i]) {                   // sammenligner
                    Metoder.bytt(a, i - 1, i); // bytter
                    byttindeks = i;                      // høyre indeks i ombyttingen
                }
            }
            n = byttindeks;                          // ny intervallgrense
        }
    }

    */

    // Oppgave 3
    public static void omvendtBoblesortering(int[] a) {     // hører til klassen Tabell
        for (int n = 0; n < a.length-1; n++) {          // n reduseres med 1 hver gang
            for (int i = a.length-1; i > n; i--) {                // går fra 1 til n
                if (a[i] < a[i-1]) {
                    Tabell.bytt(a, i-1, i);  // sammenligner/bytter
                }
            }
        }
    }
}
