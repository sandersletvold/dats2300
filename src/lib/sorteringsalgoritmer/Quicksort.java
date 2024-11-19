package lib.sorteringsalgoritmer;

import lib.Tabell;

public class Quicksort {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(10);
        for (int i : a) System.out.print(i+" ");
        quicksort(a);
        System.out.println();
        for (int i : a) System.out.print(i+" ");
    }

    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length-1);
    }

    public static void quicksort(int[] a, int fra, int til) {
        if (til <= fra) return;
        int pivot  = partisjoner(a, fra, til);
        quicksort(a, fra, pivot-1);
        quicksort(a, pivot+1, til);
    }

    private static int partisjoner(int[] a, int fra, int til) {
        int pivot = a[til];         // Setter pivotelementet til siste i listen
        int i = fra-1;      // Setter i til å starte på index -1

        for (int j = fra; j <= til-1; j++) {
            if (a[j] < pivot) {         // Hvis j er mindre enn pivotelementet
                i++;        // Øker i med 1 før vi bytter
                bytt(a, j, i);      // Bytter plass på j med i+1
            }
        }
        i++;
        bytt(a, i, til);        // Bytter i+ med pivot elementet på slutten
        return i;       // Dette er nå riktig plassert
    }

    private static void bytt(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
