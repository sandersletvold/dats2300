package kap_1_3_ordnede_tabeller;

import lib.Tabell;

import java.util.Arrays;

public class Oppgave_1_3_5 {
    public static void main(String[] args) {
        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};

        // Oppgave 2
        // Søker i a etter: 2, 15, 16, 40, 41
        System.out.println("Oppgave 2");
        System.out.print(" "+ Tabell.lineærsøk(a, 2));
        System.out.print(" "+ Tabell.lineærsøk(a, 15));
        System.out.print(" "+ Tabell.lineærsøk(a, 16));
        System.out.print(" "+ Tabell.lineærsøk(a, 40));
        System.out.print(" "+ Tabell.lineærsøk(a, 41));

        // Oppgave 4
        // Søker i a etter: 5, 8, 14, 18, 27, 36, 40, 42
        System.out.println("\n\nOppgave 4");
        System.out.print(" "+linaersokBegrenset(a, 5, 4, 13));
        System.out.print(" "+linaersokBegrenset(a, 8, 4, 13));
        System.out.print(" "+linaersokBegrenset(a, 14, 4, 13));
        System.out.print(" "+linaersokBegrenset(a, 18, 4, 13));
        System.out.print(" "+linaersokBegrenset(a, 27, 4, 13));
        System.out.print(" "+linaersokBegrenset(a, 36, 4, 13));
        System.out.print(" "+linaersokBegrenset(a, 40, 4, 13));
        System.out.print(" "+linaersokBegrenset(a, 42, 4, 13));

        // Oppgave 5a
        System.out.println("\n\nOppgave 5a\n"+linaersokIntervall(a, 5, 36));

        // Oppgave 5c
        System.out.println("\nOppgave 5c\n"+kvadratrotsok(a, 37));

        // Oppgave 6
        System.out.println("\nOppgave 6\n"+Arrays.toString(linaersokFraTil(a, 4,7)));
    }

    // Oppgave 4
    public static boolean kontroll(int[] a, int fra, int til) {
        if (a.length == 0 || fra >= til) {
            return false;
        } else {
            return true;
        }
    }

    public static int linaersokBegrenset(int[] a, int verdi, int fra, int til) {
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

    // Oppgave 5a
    public static int linaersokIntervall(int[] a, int k, int verdi) {
        if (a.length == 0) {
            return -1;
        } else {
            for (int i = 0; i<a.length+k; ) {
                if (a[i] == verdi) {
                    return i;
                }
                i += k;
                if (i > a.length-1 || a[i] > verdi) {
                    i -= k;
                    for (int j = i; j < i+k; j++) {
                        if (a[j] == verdi) {
                            return j;
                        }
                    }
                    return -1;
                }
            }
        }
        return -1;
    }

    // Oppgave 5c
    public static int kvadratrotsok(int[] a, int verdi) {
        double l = Math.sqrt(a.length);
        int k = (int)Math.round(l);
        return linaersokIntervall(a, k, verdi);
    }


    // Oppgave 6
    public static int[] linaersokFraTil (int[] a, int fraverdi, int tilverdi) {
        int[] b = new int[tilverdi-fraverdi+1];
        int j = 0;
        if (fraverdi >= tilverdi || a.length < 3 || fraverdi < 0 || tilverdi > a.length-1) {
            return a;
        }
        for (int i = fraverdi; i <= tilverdi; i++) {
            b[j] = a[i];
            j++;
        }
        return b;
    }
}
