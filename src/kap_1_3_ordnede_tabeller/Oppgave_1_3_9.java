package kap_1_3_ordnede_tabeller;

import lib.Tabell;

import java.util.Arrays;

import static lib.Tabell.bytt;

public class Oppgave_1_3_9 {
    public static void main(String[] args) {
        // Oppgave 7
        int[] a = Tabell.randPerm(30);
        Kode.treDeler(a);
        System.out.println(Arrays.toString(a));

        // Oppgave 11
        int[] b = Tabell.randPerm(20);           // en tilfeldig permutasjon
        Tabell.kvikksortering(b);                // sorterer
        System.out.println(Arrays.toString(b));  // skriver ut

        // Oppgave 12
        long t1 = System.currentTimeMillis();
        int[] c = Tabell.randPerm(100000);
        Tabell.kvikksortering(c);
        System.out.println(System.currentTimeMillis()-t1);

        long t2 = System.currentTimeMillis();
        int[] d = Tabell.randPerm(100000);
        Kode.innsettingssortering(d);
        System.out.println(System.currentTimeMillis()-t2);

        long t3 = System.currentTimeMillis();
        int[] e = Tabell.randPerm(100000);
        Arrays.sort(e);
        System.out.println(System.currentTimeMillis()-t3);
    }
}

class Kode {
    // Oppgave 7
    public static void treDeler(int[] tabell) {
        Tabell.parter(tabell, 11);
        int skille = 0;
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i] > 10) {
                skille = i;
                break;
            }
        }
        Tabell.parter(tabell, skille, tabell.length, 21);
    }

    // Oppgave 12
    public static void innsettingssortering(int[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            int verdi = a[i], j = i - 1;      // verdi er et tabellelemnet, j er en indeks
            for (; j >= 0 && verdi < a[j]; j--) a[j+1] = a[j];  // sammenligner og flytter
            a[j + 1] = verdi;                 // j + 1 er rett sortert plass
        }
    }

    // Oppgave 13

    // Oppgave 15

    // Oppgave 16

    // Oppgave 17
}

class Kommentarer {
    // Oppgave 3
    /*  7 som skilleverdi
        7,10,3,4,1,6,8,2,9,5 - 5 skal bytte med 7
        5,10,3,4,1,6,8,2,9,7 - 10 skal bytte med 2
        5,2,3,4,1,6,8,10,9,7 - Ferdig

        5 som skilleverdi
        7,10,3,4,1,6,8,2,9,5 - 2 skal bytte med 7
        2,10,3,4,1,6,8,7,9,5 - 1 skal bytte med 10
        2,1,3,4,10,6,8,7,9,5 - Ferdig
    */

    // Oppgave 4
    /*  6 som skilleverdi
        11,2,17,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,6,5 - 5 skal bytte med 11
        5,2,17,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,6,11 - 4 skal bytte med 17
        5,2,4,1,9,8,12,14,15,3,19,18,7,10,16,20,13,17,6,11 - 3 skal bytte med 9
        5,2,4,1,3,8,12,14,15,9,19,18,7,10,16,20,13,17,6,11 - Ferdig

        10 som skilleverdi
        11,2,17,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,6,5 - 5 skal bytte med 11
        5,2,17,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,6,11 - 6 skal bytte med 17
        5,2,6,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,17,11 - 4 skal bytte med 12
        5,2,6,1,9,8,4,14,15,3,19,18,7,10,16,20,13,12,17,11 - 7 skal bytte med 14
        5,2,6,1,9,8,4,7,15,3,19,18,14,10,16,20,13,12,17,11 - 3 skal bytte med 15
        5,2,6,1,9,8,4,7,3,15,19,18,14,10,16,20,13,12,17,11 - Ferdig

        15 som skilleverdi
        11,2,17,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,6,5 - 5 skal bytte med 17
        11,2,5,1,9,8,12,14,15,3,19,18,7,10,16,20,13,4,6,17 - 6 skal bytte med 15
        11,2,5,1,9,8,12,14,6,3,19,18,7,10,16,20,13,4,15,17 - 4 skal bytte med 19
        11,2,5,1,9,8,12,14,6,3,4,18,7,10,16,20,13,19,15,17 - 13 skal bytte med 18
        11,2,5,1,9,8,12,14,6,3,4,13,7,10,16,20,18,19,15,17 - Ferdig
    */
}
