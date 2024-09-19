package kap_1_4_generiske_algoritmer;

import lib.eksempelklasser.*;

public class Oppgave_1_4_4 {
    public static void main(String[] args) {
        // Oppgave 1a
        Person adam = new Person("Adam", "Andersen");
        Person brage = new Person("Brage", "Bakkestad");
        System.out.println(adam.compareTo(brage));
    }
}
