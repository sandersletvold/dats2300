package algoritmer_og_effektivitet;

import java.util.Arrays;

public class _1_1_3 {
    public static void main(String[] args) {
        int[] tabell = {6,3};
        int fakultet = 5;
        System.out.println("Oppgave 5 "+Arrays.toString(minmaks(tabell)));
        System.out.println("Oppgave 6 "+fakultet(fakultet));
    }

    // Oppgave 5
    public static int[] minmaks(int[] tabell) {
        int m1 = 0;
        int m2 = 1;
        if (tabell[m1] < tabell[m2]){
            int[] b = {m1, m2};
            return b;
        } else {
            int[] b = {m2, m1};
            return b;
        }
        // Metoden bruker kun 1 sammenligning da den sjekker om m1 er mindre enn m2. Hvis ikke dette stemmer vet vi m1 er større enn m2.
    }

    // Oppgave 6
    public static long fakultet(int n) {
        long fakultet = 1;
        for (int i = 2; i<=n; i++) {
            fakultet = fakultet*i;
        }
        return fakultet;
    }
}
