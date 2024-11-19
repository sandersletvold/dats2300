package lib.sorteringsalgoritmer;

import lib.Tabell;

public class Bubblesort {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(10);
        for (int i : a) System.out.print(i+" ");
        bubblesort(a);
        System.out.println();
        for (int i : a) System.out.print(i+" ");
    }

    public static void bubblesort(int[] a) {
        for (int i = 1; i < a.length; i++) {    // Hver gang denne kjører havner 1 element på rett plass
            for (int j = 1; j < a.length; j++) {        // Setter første elem bakerst, deretter nest bakerst neste løkke
                if (a[j-1] > a[j]) {            // Sammenligner naboverdier
                    bytt(a, j-1, j);
                }
            }
        }
    }

    public static void bytt(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

