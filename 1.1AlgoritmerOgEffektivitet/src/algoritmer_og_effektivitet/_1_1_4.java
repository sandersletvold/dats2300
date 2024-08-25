package algoritmer_og_effektivitet;

public class _1_1_4 {
    public static void main(String[] args) {

    }

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
        int m = 0; // 1
        int maksverdi = a[0]; // 2 Denne strykes bort

        for (int i = 1; i < a.length; i++) { /* 1+n+n-1+2(n-1) som kan forkortes til 2n+2(n-1)
            Deretter gjør vi om 2(n-1) til 2n ved å ta 2 bort fra int maksverdi. Da har vi 4n her */
            if (a[i] > maksverdi) { // x
                maksverdi = a[i]; // x
                m = i; // x
            }
        }
        return m; // 1
    }

}
