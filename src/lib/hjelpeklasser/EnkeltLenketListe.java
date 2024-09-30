package lib.hjelpeklasser;

import java.util.Iterator;
import java.util.Objects;

public class EnkeltLenketListe<T> implements Liste<T> {
    private static final class Node<T> {      // en indre nodeklasse
        private T verdi;                       // nodens verdi
        private Node<T> neste;                 // den neste noden

        private Node(T verdi,Node<T> neste)    // konstruktør
        {
            this.verdi = verdi;
            this.neste = neste;
        }
    }  // Node

    private Node<T> hode, hale;  // pekere til første og siste node

    private int antall;          // antall verdier/noder i listen

    public EnkeltLenketListe() {   // standardkonstruktør
        hode = hale = null;        // hode og hale til null
        antall = 0;                // ingen verdier - listen er tom
    }

    public EnkeltLenketListe(T[] a) {
        if (a == null) {
            throw new NullPointerException("Tabellen a er null.");
        }

        for (T i : a) {
            Objects.requireNonNull(i, "Nullverdier er ikke lovlig");
            if (antall == 0) {
                Node<T> første = new Node<>(i, null);
                hode = første;
                hale = første;
            } else {
                Node<T> node = new Node<>(i, null);
                hale.neste = node;
                hale = node;
            }
            antall++;
        }
    }

    @Override
    public boolean leggInn(T verdi)   // verdi legges bakerst
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        if (antall == 0)  hode = hale = new Node<>(verdi, null);  // tom liste
        else hale = hale.neste = new Node<>(verdi, null);         // legges bakerst

        antall++;        // en mer i listen
        return true;     // vellykket innlegging
    }

    @Override
    public void leggInn(int indeks, T verdi)    // verdi til posisjon indeks
    {
        Objects.requireNonNull(verdi, "Ikke tillatt med null-verdier!");

        indeksKontroll(indeks, true);        // true: indeks = antall er lovlig

        if (indeks == 0)                     // ny verdi skal ligge først
        {
            hode = new Node<>(verdi, hode);    // legges først
            if (antall == 0) hale = hode;      // hode og hale peker på samme node
        }
        else if (indeks == antall)           // ny verdi skal ligge bakerst
        {
            hale = hale.neste = new Node<>(verdi, null);  // legges bakerst
        }
        else
        {
            Node<T> p = hode;                  // p flyttes indeks - 1 ganger
            for (int i = 1; i < indeks; i++) p = p.neste;

            p.neste = new Node<>(verdi, p.neste);  // verdi settes inn i listen
        }

        antall++;                            // listen har fått en ny verdi
    }

    @Override
    public boolean inneholder(T t)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T hent(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public int indeksTil(T t)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T oppdater(int indeks, T t)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public T fjern(int indeks)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public boolean fjern(T t)
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall == 0;
    }

    @Override
    public void nullstill() {
        Node<T> node = hode;
        while (node != null) {
            Node<T> neste = node.neste;
            node.verdi = null;
            node.neste = null;
            node = neste;
        }
        hode = null;
        hale = null;
        antall = 0;
    }

    @Override
    public Iterator<T> iterator()
    {
        throw new UnsupportedOperationException("Ikke laget ennå!");
    }

    @Override
    public String toString() {
        if (tom()) {  // Hvis listen er tom, returner "[]"
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> node = hode;
        while (node != null) {
            sb.append(node.verdi);
            node = node.neste;
            if (node != null) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

}  // EnkeltLenketListe