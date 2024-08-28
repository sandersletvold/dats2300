package kap_1_3_ordnede_tabeller;

import lib.Metoder;

public class Oppgave_1_3_5 {
    public static void main(String[] args) {
        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};

        // Oppgave 2
        // Søker i a etter: 2, 15, 16, 40, 41
        System.out.print(" "+ Metoder.linearSok(a, 2));
        System.out.print(" "+ Metoder.linearSok(a, 15));
        System.out.print(" "+ Metoder.linearSok(a, 16));
        System.out.print(" "+ Metoder.linearSok(a, 40));
        System.out.print(" "+ Metoder.linearSok(a, 41));

        System.out.println();

        // Oppgave 4
        // Søker i a etter: 5, 8, 14, 18, 27, 36, 40, 42
        System.out.print(" "+begrensetLinearsok(a, 5, 4, 13));
        System.out.print(" "+begrensetLinearsok(a, 8, 4, 13));
        System.out.print(" "+begrensetLinearsok(a, 14, 4, 13));
        System.out.print(" "+begrensetLinearsok(a, 18, 4, 13));
        System.out.print(" "+begrensetLinearsok(a, 27, 4, 13));
        System.out.print(" "+begrensetLinearsok(a, 36, 4, 13));
        System.out.print(" "+begrensetLinearsok(a, 40, 4, 13));
        System.out.print(" "+begrensetLinearsok(a, 42, 4, 13));
    }

    // Oppgave 4
    public static boolean kontroll(int[] a, int fra, int til) {
        if (a.length == 0 || fra >= til) {
            return false;
        } else {
            return true;
        }
    }

    public static int begrensetLinearsok(int[] a, int verdi, int fra, int til) {
        if (kontroll(a, fra, til)) {
            if (verdi > a[til]) {
                return -(til + 1);
            } else if (verdi < a[fra]) {
                return  -(fra - 1);
            }

            int i = fra;
            for( ; a[i] < verdi; i++);
            return verdi == a[i] ? i : -(i);
        } else {
            return 0;
        }
    }

    // Oppgave 6
}
