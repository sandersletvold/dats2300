package algoritmer_og_effektivitet;

public class A114 {
    public static void main(String[] args) {

    }

    // Oppgave 1

    // 10, 5, 7, 2, 9, 1, 3, 8, 4, 6
    // 1+(10*2)+(0*2) = 21

    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    // 1+(10*2)+(9*2) = 39

    // 1, 3, 2, 7, 5, 9, 6, 8, 10, 4
    // 1+(10*2)+(4*2) = 29

    // Formelen for antall operasjoner blir:
    // 1+1+(n-1)*2+2x+1
    // Forenklet blir dette: 1+2n+2x

    public static int maks(int[] a) {
        int m = 0; // 1
        int maksverdi = a[0]; // 1

        for (int i = 1; i < a.length; i++) { // (n-1)*2
            if (a[i] > maksverdi) {
                maksverdi = a[i]; // x
                m = i; // x
            }
        }
        return m; // 1
    }
}
