package algoritmer_og_effektivitet;

public class A115 {
    public static void main(String[] args) {
        int[] a = {6};
        System.out.println(maks(a));
    }

    public static int maks(int[] a) {  // versjon 3 av maks-metoden
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    // Oppgave 1
    // Hvis a har lengde på 1 vil svaret alltid bli 0 da det er eneste indexen, som også da vil være den største.
    // Hvis a har lengde på 0 vil vi få feilmelding da det ikke er noen verdier og dermed er ingen størst.
}
