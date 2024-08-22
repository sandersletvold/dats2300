package nest_storste_verdi;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(16);              // en tilfeldig tabell

        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int maks = Tabell.maks(a);   // finner posisjonen til største verdi
        int min = Tabell.min(a);
        int begrensetMaks = Tabell.maks(a, 0, 4);
        int begrensetMin = Tabell.min(a, 0, 4);

        System.out.println("\n\nStørste verdi ligger på plass " + maks);
        System.out.println("Minste verdi ligger på plass " + min);
        System.out.println("Største verdi mellom index 0 og 4 ligger på plass " + begrensetMaks);
        System.out.println("Minste verdi mellom index 0 og 4 ligger på plass " + begrensetMin);

        char[] c = {'D','H','O','J','B','Q','P','C','I','S'};
        System.out.println("\nChar tabell før endring:");
        for (char i : c) {
            System.out.print(i+", ");
        }
        Tabell.bytt(c, 0, 9);
        System.out.println("\nChar tabell etter endring:");
        for (char i : c) {
            System.out.print(i+", ");
        }

        System.out.println("\n\nIndex for største og nest største verdi");
        int[] nm = Tabell.nestMaks(a);
        for (int i : nm) {
            System.out.print(i+" ");
        }

        System.out.println("\nIndex for minste og nest minste verdi");
        int[] nm1 = Tabell.nestMin(a);
        for (int i : nm1) {
            System.out.print(i+" ");
        }

        System.out.println("\n\nVerdiene for 1. og 2. plassen");
        int[] resultat = Tabell.turnering(a);
        for (int i : resultat) {
            System.out.print(i+" ");
        }
    }
}
