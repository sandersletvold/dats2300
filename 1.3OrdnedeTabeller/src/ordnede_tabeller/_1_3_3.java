package ordnede_tabeller;

import java.util.Arrays;
import java.util.Random;

public class _1_3_3 {
    public static void main(String[] args) {
        int[] a = randPerm(10);
        System.out.println(Arrays.toString(a));
        boblesortering(a);
        System.out.println(Arrays.toString(a));
    }
    // Oppgave 1
    public static void boblesortering(int[] a) {
        for (int n = a.length; n > 1; ) {          // n er intervallgrense
            int byttindeks = 0;                      // hjelpevariabel
            for (int i = 1; i < n; i++) {           // går fra 1 til n
                if (a[i - 1] > a[i]) {                // sammenligner
                    bytt(a, i - 1, i);                   // bytter
                    byttindeks = i;                      // høyre indeks i ombyttingen
                }
            }
            n = byttindeks;                          // ny intervallgrense
        }
    }

    public static void boblesortering1(int[] a)     // hører til klassen Tabell
    {
        for (int n = a.length; n > 1; n--)           // n reduseres med 1 hver gang
        {
            for (int i = 1; i < n; i++)                // går fra 1 til n
            {
                if (a[i - 1] > a[i]) {
                    bytt(a, i - 1, i);  // sammenligner/bytter
                }
            }
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    // Oppgave 3
    // Lag motsatt boblesortering metode som går fra høyre til venstre
}
