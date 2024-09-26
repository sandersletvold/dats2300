package kap_1_4_generiske_algoritmer;

import lib.Tabell;
import lib.eksempelklasser.*;

import java.util.Arrays;

public class Oppgave_1_4_4 {
    public static void main(String[] args) {
        //oppgave1();
        oppgave2();
    }

    private static void oppgave1() {
        // Oppgave 1a
        int[] a = {5,2,7,3,9,1,8,10,4,6};          // en int-tabell
        Heltall[] h = new Heltall[a.length];       // en Heltall-tabell

        for (int i = 0; i < h.length; i++) {
            h[i] = new Heltall(a[i]);
        }
        Tabell.innsettingssortering(h);           // generisk sortering
        System.out.println(Arrays.toString(h));   // utskrift

        // Oppgave 1b
        Heltall heltall1 = new Heltall(8);
        Heltall heltall2 = new Heltall(5);
        System.out.println(heltall1.compareTo(heltall2));

        // Oppgave 1d
        Heltall x = new Heltall(3), y = new Heltall(3);  // x og y er like
        System.out.println(x.compareTo(y) + "  " + x.equals(y));

        // Oppgave 1e
        Heltall h1 = new Heltall(3), h2 = new Heltall(3);  // x og y er like
        System.out.println(h1.hashCode() + "  " + h2.hashCode());
        /*  Hvis vi fjerner hashCode metoden får vi feks 1534030866  664223387 som utskrift
            Dette er fordi metoden vi arver fra class Object ikke blir brukt.
            Her returneres da minneadressen til pcen for tallene.
        */
    }

    private static void oppgave2() {
        Person[] p = new Person[7];                   // en persontabell
        p[0] = new Person("Kari","Svendsen");         // Kari Svendsen
        p[1] = new Person("Boris","Zukanovic");       // Boris Zukanovic
        p[2] = new Person("Ali","Kahn");              // Ali Kahn
        p[3] = new Person("Azra","Zukanovic");        // Azra Zukanovic
        p[4] = new Person("Kari","Pettersen");        // Kari Pettersen

        // Oppgave 2a
        p[5] = new Person("Per", "Knutsen");
        p[6] = new Person("Ole", "Hansen");

        int m = Tabell.maks(p);                       // posisjonen til den største
        System.out.println(p[m] + " er størst");      // skriver ut den største

        Tabell.innsettingssortering(p);               // generisk sortering
        System.out.println(Arrays.toString(p));       // skriver ut sortert

        // Oppgave 2d
        /*  Endret konstruktøren til Person slik at fornavn og etternavn ikke kan være null
        */

        // Oppgave 2e
        /*  Alternativ equals metode i Personklassen.
        */
    }
}
