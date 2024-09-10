package kap_1_2_nest_storste_verdi;

import lib.Tabell;

import java.util.Arrays;

public class Oppgave_1_2_1 {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(10);
        System.out.println(Arrays.toString(a));

        // Oppgave 1
        System.out.println(Tabell.min(a));
        System.out.println(Tabell.min(a, 2, 4));
    }
}
