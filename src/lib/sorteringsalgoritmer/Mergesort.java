package lib.sorteringsalgoritmer;

import lib.Tabell;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);
        System.out.println(Arrays.toString(a));
        mergesort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergesort(int[] a) {
        if (a.length <= 1) return; // Basistilfelle: Hvis arrayet har én eller ingen elementer, er det allerede sortert.

        int m = a.length / 2; // Finn midtpunktet for å dele arrayet i to.
        int[] v = new int[m]; // Opprett en array for venstre halvdel.
        int[] h = new int[a.length - m]; // Opprett en array for høyre halvdel.
        int j = 0; // Indeks for å fylle opp høyre array.

        for (int i = 0; i < a.length; i++) {
            if (i < m) {
                v[i] = a[i]; // Fyll venstre array med de første m elementene.
            } else {
                h[j] = a[i]; // Fyll høyre array med de resterende elementene.
                j++;
            }
        }

        mergesort(v); // Rekursivt sorter venstre halvdel.
        mergesort(h); // Rekursivt sorter høyre halvdel.
        merge(a, v, h); // Flett de to sorterte halvdelene tilbake til hovedarrayet.
    }

    public static void merge(int[] a, int[] venstre, int[] høyre) {
        int venstreLengde = a.length / 2; // Antall elementer i venstre halvdel (basert på delt arraystørrelse).
        int høyreLengde = a.length - venstreLengde; // Antall elementer i høyre halvdel.

        int i = 0; // Indeks for å sette verdier i det endelige sorterte arrayet.
        int j = 0; // Indeks for venstre array.
        int k = 0; // Indeks for høyre array.

        // Flett elementene fra venstre og høyre array til det sorterte arrayet.
        while (j < venstreLengde && k < høyreLengde) {
            if (venstre[j] < høyre[k]) { // Sammenlign elementer i venstre og høyre array.
                a[i] = venstre[j]; // Legg det minste elementet i det sorterte arrayet.
                i++;
                j++;
            } else {
                a[i] = høyre[k]; // Legg det minste elementet fra høyre i det sorterte arrayet.
                i++;
                k++;
            }
        }

        // Kopier eventuelle gjenværende elementer fra venstre array.
        while (j < venstreLengde) {
            a[i] = venstre[j];
            i++;
            j++;
        }

        // Kopier eventuelle gjenværende elementer fra høyre array.
        while (k < høyreLengde) {
            a[i] = høyre[k];
            i++;
            k++;
        }
    }
}
