package lib;

import java.util.Arrays;
import java.util.Random;

public class Metoder {
    /* KAPITTEL 1.2 */

    // Finner indexen til det største tallet i ett heltallsarray innenfor fra og til intervall
    public static int maks(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;
        int maksverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;
                maksverdi = a[m];
            }
        }
        return m;
    }

    // Bruker metoden over til å finne indexen til det største tallet i ett heltallsarray
    public static int maks(int[] a) {
        return maks(a,0,a.length);
    }

    // Finner indexen til det minste tallet i ett heltallsarray innenfor fra og til intervall
    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;
        int minverdi = a[fra];

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }

    // Bruker metoden over til å finne indexen til det minste tallet i ett heltallsarray
    public static int min(int[] a) {
        return min(a,0,a.length);
    }

    // Finner index til største og nest største verdi i et heltallsarray og legger det i et nytt heltallsarray
    public static int[] nestMaks(int[] a) {
        int n = a.length;
        if (n < 2) {
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = 0;
        int nm = 1;

        if (a[1] > a[0]) {
            m = 1; nm = 0;
        }

        int maksverdi = a[m];
        int nestmaksverdi = a[nm];

        for (int i = 2; i < n; i++) {
            if (a[i] > nestmaksverdi) {
                if (a[i] > maksverdi) {
                    nm = m;
                    nestmaksverdi = maksverdi;

                    m = i;
                    maksverdi = a[m];
                } else {
                    nm = i;
                    nestmaksverdi = a[nm];
                }
            }
        }

        return new int[] {m,nm};
    }

    // Finner index til minste og nest minste verdi i et heltallsarray og legger det i et nytt heltallsarray
    public static int[] nestMin(int[] a) {
        int n = a.length;
        if (n < 2) {
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = 0;
        int nm = 1;

        if (a[1] < a[0]) {
            m = 1; nm = 0;
        }

        int minVerdi = a[m];
        int nestMinVerdi = a[nm];

        for (int i = 2; i < n; i++) {
            if (a[i] < nestMinVerdi) {
                if (a[i] < minVerdi) {
                    nm = m;
                    nestMinVerdi = minVerdi;

                    m = i;
                    minVerdi = a[m];
                } else {
                    nm = i;
                    nestMinVerdi = a[nm];
                }
            }
        }

        return new int[] {m,nm};
    }

    // Trekker en tilfeldig tallrekke med n lengde uten duplikater
    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k+1);
            bytt(a,k,i);
        }

        return a;
    }

    // Stokker om på et allerede eksisterende heltallsarray
    public static void randPerm(int[] a) {
        Random r = new Random();

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a,k,i);
        }
    }

    // Bytter plass på 2 verdier i et heltallsarray
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Bytter plass på 2 verdier i et karakterarray
    public static void bytt(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Sjekker om det oppgis gyldige fra og til verdier i forbindelse med søk i array
    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0) {
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");
        }
        if (til > tablengde) {
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");
        }
        if (fra > til) {
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }



    /* KAPITTEL 1.3 */

    // Sorter en liste ved å kun sammenligne med naboverdien
    public static void bobleSortering(int[] a) {
        for (int n = a.length; n > 1; n--) {
            for (int i = 1; i < n; i++) {
                if (a[i - 1] > a[i]) {
                    bytt(a, i - 1, i);
                }
            }
        }
    }

    // Søker etter en verdi i et array og returner indexen eller hvor indexen skulle vært med - foran.
    public static int linaerSok(int[] a, int verdi) {
        if (a.length == 0 || verdi > a[a.length-1]) {
            return -(a.length + 1);
        }
        int i = 0;
        for( ; a[i] < verdi; i++);

        return verdi == a[i] ? i : -(i+1);
    }

    // Binærsøk som bruker fra og til
    public static int binaersok(int[] a, int fra, int til, int verdi) {
        fratilKontroll(a.length,fra,til);
        int v = fra;
        int h = til - 1;

        while (v < h) {
            int m = (v + h)/2;
            if (verdi > a[m]) {
                v = m + 1;
            } else {
                h = m;
            }
        }

        if (h < v || verdi < a[v]) {
            return -(v + 1);
        } else if (verdi == a[v]) {
            return v;
        } else {
            return -(v + 2);
        }
    }

    // Binærsøk for hele tabeller
    public static int binaersok(int[] a, int verdi) {
        return binaersok(a, 0, a.length, verdi);
    }

    // Parter med fra og til intervall
    public static int parter(int[] a, int fra, int til, int skilleverdi) {
        fratilKontroll(a.length, fra, til);
        return parter0(a, fra, til - 1, skilleverdi);
    }

    // Parter hvor hele tabellen kalles
    public static int parter(int[] a, int skilleverdi) {
        return parter0(a, 0, a.length - 1, skilleverdi);
    }

    // Privat parter metode med logikken bak hvordan det funker
    private static int parter0(int[] a, int v, int h, int skilleverdi) {
        while (true) {
            while (v <= h && a[v] < skilleverdi) v++;
            while (v <= h && a[h] >= skilleverdi) h--;

            if (v < h) bytt(a,v++,h--);
            else  return v;
        }
    }
}
