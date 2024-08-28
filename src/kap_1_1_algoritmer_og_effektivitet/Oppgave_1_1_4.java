package kap_1_1_algoritmer_og_effektivitet;

public class Oppgave_1_1_4 {
    // Oppgave 1

    // 10, 5, 7, 2, 9, 1, 3, 8, 4, 6
    // 42 operasjoner

    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    // 69 operasjoner

    // 1, 3, 2, 7, 5, 9, 6, 8, 10, 4
    // 54 operasjoner

    // Formelen for antall operasjoner blir:
    // 2+4n+3x

    public static int maks(int[] a) {
        int m = 0;
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }
}
