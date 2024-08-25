package ordnede_tabeller;

import java.util.Arrays;
import java.util.Random;

public class _1_3_3 {
    public static void main(String[] args) {
        System.out.println(boble(randPerm(10)));
    }
    // Oppgave 1
    public static int boble(int[] a)      // legges i samleklassen Tabell
    {
        int antall = 0;                     // antall ombyttinger i tabellen
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            if (a[i - 1] > a[i])              // sammenligner to naboverdier
            {
                System.out.println(a[i-1]+" byttet med "+a[i]);
                bytt(a, i - 1, i);              // bytter om to naboverdier
                antall++;                       // teller opp ombyttingene
            }
        }
        return antall;                      // returnerer
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }


    // Oppgave 2

    // Oppgave 3
}
