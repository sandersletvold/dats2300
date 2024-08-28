package kap_1_1_algoritmer_og_effektivitet;

public class Oppgave_1_1_2 {
    public static void main(String[] args) {
        int[] a = {3,6,1,5,8,1,6,9,8,9};
        System.out.println(min2(a));
        System.out.println(min3(a));
    }

    // Oppgave 2
    public static int min2(int[] a) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }
        int minstIndex = 0;
        for (int i = 1; i<a.length; i++) {
            if (a[i]<a[minstIndex]) {
                minstIndex = i;
            }
        }
        return minstIndex;
    }

    // Oppgave 3
    public static int min3(int[] a) {
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }
        int minstIndex = 0;
        for (int i = 1; i<a.length; i++) {
            if (a[i]<=a[minstIndex]) {
                minstIndex = i;
            }
        }
        return minstIndex;
    }
}
