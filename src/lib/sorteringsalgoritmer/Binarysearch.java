package lib.sorteringsalgoritmer;

import lib.Tabell;

public class Binarysearch {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);
        Quicksort.quicksort(a);
        System.out.println(binarysearch(a, 6));
    }
    public static int binarysearch(int[] a, int x) {
        int high = a.length-1;      // Siste indeks
        int low = 0;        // Første indeks
        int mid = (low+high)/2;         // Indeks på midten

        while (low <= high) {
            if (a[mid] == x) {      // Hvis x er første indeks vi sjekker midt i tabellen
                return mid;
            } else if (a[mid] > x) {
                high = mid-1;       // Endrer "maks" indeks til midten-1.
            } else {
                low = mid+1;        // Endrer "min" indeks til midten+1.
            }
            mid = (low+high)/2;         // Nye midten settes her.
        }
        return -1;
    }
}
