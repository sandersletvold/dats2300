package kap_3_3_en_lenket_liste;

import lib.hjelpeklasser.EnkeltLenketListe;

public class Oppgave_3_3_2 {
    public static void main(String[] args) {
        Integer[] a = {2,4,1,3,7,9};
        EnkeltLenketListe<Integer> lenketListe = new EnkeltLenketListe<>(a);
        lenketListe.leggInn(8);
        lenketListe.leggInn(0, 11);
        System.out.println(lenketListe.antall());
        System.out.println(lenketListe);
        lenketListe.nullstill();
        System.out.println(lenketListe);
    }
}
