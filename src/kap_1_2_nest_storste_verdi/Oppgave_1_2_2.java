package kap_1_2_nest_storste_verdi;

import lib.Metoder;


public class Oppgave_1_2_2 {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(10);
        for (int i : a) {
            System.out.print(i+" ");
        }

        // Oppgave 2
        System.out.println("\n"+Metoder.maks(a));

        // Oppgave 3
        char[] c = {'D','H','O','J','B','Q','P','C','I','S'};
        for (char i : c) {
            System.out.print(i+" ");
        }

        System.out.println();
        Metoder.bytt(c, 2,4);
        for (char i : c) {
            System.out.print(i+" ");
        }
    }
}
