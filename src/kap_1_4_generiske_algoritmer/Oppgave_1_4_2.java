package kap_1_4_generiske_algoritmer;

import lib.Tabell;

import java.util.Arrays;

public class Oppgave_1_4_2 {
    public static void main(String[] args) {
        // Oppgave 1
        String[] a = {"Sohil","Per","Thanh","Fatima","Kari","Jasmin"};
        int m = Tabell.maks(a);        // hvilken maks-metode?
        System.out.println(a[m]);      // Utskrift:  Thanh

        // Oppgave 2
        String[] b = {"Per","Kari","Ole","Anne","Ali","Eva"};
        Tabell.innsettingssortering(b);
        System.out.println(Arrays.toString(b));  // [Ali, Anne, Eva, Kari, Ole, Per]

        // Oppgave 3
        int i = 5;
        Integer k = i;
        Number n = k;
        Object o = n;

        Testprogram3.skriv(i);
        Testprogram3.skriv(k);
        Testprogram3.skriv(n);
        Testprogram3.skriv(o);
        Testprogram3.skriv(3.14);

        // Oppgave 4
        Testprogram4.f(new C());

        // Oppgave 5
        Testprogram5.f(1,1);

        // Oppgave 6
        D[] d = new D[1];
        E[] e = new E[1];
        F[] f = new F[1];

        Testprogram6.maks(d);
        Testprogram6.maks(e);
        Testprogram6.maks(f);
    }
}

// Oppgave 3
class Testprogram3 {
    public static <T> void skriv(T t) { // 1. versjon
        System.out.println("1. versjon " + t);
    }
}

// Oppgave 4
class Testprogram4 {
    public static void f(A a) { System.out.println("A"); }   // 1
    public static void f(B b) { System.out.println("B"); }   // 2
    public static void f(C c) { System.out.println("C"); }   // 3
}

class A {}                          // A er en klasse
interface B {}                      // B et grensesnitt
class C extends A implements B {}   // C er subtype til både A og B

// Oppgave 5
class Testprogram5 {
    public static void f(int a, float b){}

    // public static void f(float a, int b){}
}

// Oppgave 6
class Testprogram6 {
    public static <T extends Comparable<? super T>> int maks(T[] a) { // Her må <? super T> være med
        return 0;
    }
}

class D implements Comparable<D> {
    public int compareTo(D d) {
        return 0;
    }
}

class E extends D {}

class F implements Comparable<Object> {
    public int compareTo(Object o) {
        return 0;
    }
}
