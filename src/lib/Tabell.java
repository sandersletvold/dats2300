package lib;

import java.util.Arrays;
import java.util.Random;

public class Tabell {
    private Tabell(){}

    /* KAPITTEL 1.2 */
    public static int maks(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a) {  // bruker hele tabellen
        return maks(a,0,a.length);     // kaller metoden over
    }

    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;             // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (a[i] < minverdi) {
            m = i;               // indeks til minste verdi oppdateres
            minverdi = a[m];     // minste verdi oppdateres
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static int min(int[] a) {  // bruker hele tabellen
        return min(a,0,a.length);     // kaller metoden over
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j) {
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {                                // fra er negativ
            throw new ArrayIndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }
        if (til > tablengde) {                        // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablengde + ")");
        }
        if (fra > til) {                              // fra er større enn til
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }

    public static int[] nestMaks(int[] a) {
        int n = a.length;     // tabellens lengde
        if (n < 2) {          // må ha minst to verdier
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) {
            m = 1;
            nm = 0;
        }
        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++) {
            if (a[i] > nestmaksverdi) {
                if (a[i] > maksverdi) {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                } else {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        }
        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1
    }

    public static int[] nestMin(int[] a) {
        int n = a.length;   // tabellens lengde

        if (n < 2) {
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");
        }

        int m = Tabell.min(a);   // m er posisjonen til tabellens minste verdi

        int nm = 0;   // nm står for nestmin

        if (m == 0) {
            nm = Tabell.min(a,1,n);              // leter i a[1:n>
        } else if (m == n-1) {
            nm = Tabell.min(a,0,n-1);     // leter i a[0:n-1>
        } else {
            int mv = Tabell.min(a,0,m);                   // leter i a[0:m>
            int mh = Tabell.min(a,m+1,n);                 // leter i a[m+1:n>
            nm = a[mh] < a[mv] ? mh : mv;           // hvem er minst?
        }

        int[] b = {m,nm};
        return b;  // minste verdi i b[0], nest minste i b[1]
    }

    public static int[] randPerm(int n) {  // en effektiv versjon
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--) {  // løkke som går n - 1 ganger
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a) {  // stokker om a
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }



    /* KAPITTEL 1.3 */
    public static int inversjoner(int[] a) {
        int antall = 0;  // antall inversjoner
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) antall++;  // en inversjon siden i < j
            }
        }
        return antall;
    }

    public static boolean erSortert(int[] a) {
        for (int i = 1; i < a.length; i++) {     // starter med i = 1
            if (a[i - 1] > a[i]) {
                return false;      // en inversjon
            }
        }
        return true;
    }

    public static int boble(int[] a) {
        int antall = 0;                     // antall ombyttinger i tabellen
        for (int i = 1; i < a.length; i++) {  // starter med i = 1
            if (a[i - 1] > a[i]) {              // sammenligner to naboverdier
                bytt(a, i - 1, i);              // bytter om to naboverdier
                antall++;                       // teller opp ombyttingene
            }
        }
        return antall;                      // returnerer
    }

    public static int lineærsøk(int[] a, int verdi) {
        if (a.length == 0 || verdi > a[a.length-1]) {
            return -(a.length + 1);  // verdi er større enn den største
        }

        int i = 0;
        for( ; a[i] < verdi; i++) { // siste verdi er vaktpost

        }

        if (verdi == a[i]) {
            return i;
        } else {
            return -(i+1);
        }
    }

    public static void boblesortering(int[] a) {    // hører til klassen Tabell
        for (int n = a.length; n > 1; n--) {           // n reduseres med 1 hver gang
            for (int i = 1; i < n; i++) {                // går fra 1 til n
                if (a[i - 1] > a[i]) {
                    bytt(a, i - 1, i);  // sammenligner/bytter
                }
            }
        }
    }

    public static int binærsøk(int[] a, int fra, int til, int verdi) {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h) {  // obs. må ha v < h her og ikke v <= h
            int m = (v + h)/2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) {
                v = m + 1;   // verdi må ligge i a[m+1:h]
            } else  h = m;                   // verdi må ligge i a[v:m]
        }

        if (h < v || verdi < a[v]) {
            return -(v + 1);  // ikke funnet
        } else if (verdi == a[v]) {
            return v;            // funnet
        } else {
            return -(v + 2);     // ikke funnet
        }
    }

    public static int binærsøk(int[] a, int verdi) {
        return binærsøk(a, 0, a.length, verdi);
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering0(int[] a, int v, int h) {  // en privat metode
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) { // a[fra:til>
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    public static void kvikksortering(int[] a) {   // sorterer hele tabellen
        kvikksortering0(a, 0, a.length - 1);
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true) {                                  // stopper når v > h
            while (v <= h && a[v] < skilleverdi) {
                v++;   // h er stoppverdi for v
            }
            while (v <= h && a[h] >= skilleverdi) {
                h--;  // v er stoppverdi for h
            }

            if (v < h) {
                bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            } else {
                return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
            }
        }
    }

    public static int parter(int[] a, int fra, int til, int skilleverdi) {
        fratilKontroll(a.length, fra, til);
        return parter0(a, fra, til - 1, skilleverdi);
    }

    public static int parter(int[] a, int skilleverdi) {  // hele tabellen
        return parter0(a, 0, a.length - 1, skilleverdi);
    }

    public static int flett(int[] a, int m, int[] b, int n, int[] c) {
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            c[k++] = a[i] <= b[j] ? a[i++] : b[j++];
        }

        while (i < m) {
            c[k++] = a[i++];   // tar med resten av a
        }
        while (j < n) {
            c[k++] = b[j++];   // tar med resten av b
        }

        return k;   // antallet verdier som er lagt inn i c
    }

    public static int flett(int[] a, int[] b, int[] c) {
        return flett(a, a.length, b, b.length, c);
    }



    /* KAPITTEL 1.4 */
    public static int maks(double[] a) {     // legges i class Tabell
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi) {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdaters
            }
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static <T extends Comparable<? super T>> int maks(T[] a) {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(maksverdi) > 0) {
                maksverdi = a[i];  // største verdi oppdateres
                m = i;             // indeks til største verdi oppdaters
            }
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a) {
        for (int i = 1; i < a.length; i++) {  // starter med i = 1
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) {
                a[j+1] = a[j];
            }
            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static void bytt(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n) {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }
}