package kap_1_5_rekursjon;

import lib.Tabell;

import static lib.Tabell.bytt;

public class Oppgave_1_5_7 {
    public static void main(String[] args) {
        // Oppgave 1a
        int[] a = Tabell.randPerm(10);
        kvikksortering0(a, 0, a.length-1);
    }

    private static void kvikksortering0(int[] a, int v, int h) {
        System.out.println("Kallet med [" + v + ":" + h + "] starter!");
        if (v >= h) return;   // tomt eller maks ett element

        int k = sParter0(a,v,h,(v + h)/2);   // se Programkode 1.3.9 f)
        kvikksortering0(a,v,k-1);
        kvikksortering0(a,k+1,h);
        System.out.println("Kallet med [" + v + ":" + h + "] er ferdig!");
    }

    private static int sParter0(int[] a, int v, int h, int indeks) {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h - 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
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
}
