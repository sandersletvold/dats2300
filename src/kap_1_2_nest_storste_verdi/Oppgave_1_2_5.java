package kap_1_2_nest_storste_verdi;

import lib.Metoder;

import java.util.Arrays;

public class Oppgave_1_2_5 {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(10);
        System.out.println(Arrays.toString(a));

        // Oppgave 1
        System.out.println(Arrays.toString(Metoder.nestMaks(a)));

        // Oppgave 3
        System.out.println(Arrays.toString(Metoder.nestMin(a)));
    }
}
