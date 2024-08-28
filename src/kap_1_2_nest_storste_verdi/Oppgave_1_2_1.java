package kap_1_2_nest_storste_verdi;

import lib.Metoder;

import java.util.Arrays;

public class Oppgave_1_2_1 {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(10);
        System.out.println(Arrays.toString(a));

        // Oppgave 1
        System.out.println(Metoder.min(a));
        System.out.println(Metoder.min(a, 2, 4));
    }
}
