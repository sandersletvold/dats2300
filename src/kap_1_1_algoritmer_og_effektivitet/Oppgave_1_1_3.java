package kap_1_1_algoritmer_og_effektivitet;

import java.util.Arrays;

public class Oppgave_1_1_3 {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {2,1};
        System.out.println(Arrays.toString(minmaks(a)));
        System.out.println(Arrays.toString(minmaks(b)));

        System.out.println(fakultet(5));
    }

    // Oppgave 5
    public static int[] minmaks(int[] a) {
        int m1 = 0;
        int m2 = 1;
        if (a[m1] < a[m2]){
            int[] b = {m1, m2};
            return b;
        } else {
            int[] b = {m2, m1};
            return b;
        }
    }

    // Oppgave 6
    public static long fakultet(int n) {
        long fakultet = 1;
        for (int i = 2; i<=n; i++) {
            fakultet = fakultet*i;
        }
        return fakultet;
    }
}
