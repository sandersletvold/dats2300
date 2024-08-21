package algoritmer_og_effektivitet;

public class A112 {
    public static void main(String[] args) {
        int[] tabell = {3,6,1,5,8,1,6,9,8,9};
        System.out.println("Oppgave 2: "+min(tabell));
        System.out.println("Oppgave 3: "+minIndex(tabell));
    }

    // Oppgave 1
    // min metoden ville returnert 1

    // Oppgave 2
    public static int min(int[] tabell) {
        if (tabell.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }
        int minstIndex = 0;
        for (int i = 1; i<tabell.length; i++) {
            if (tabell[i]<tabell[minstIndex]) {
                minstIndex = i;
            }
        }
        return minstIndex;
    }

    // Oppgave 3
    public static int minIndex(int[] tabell) {
        if (tabell.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen er tom");
        }
        int minst = tabell[0];
        for (int i = 1; i<tabell.length; i++) {
            if (tabell[i]<minst) {
                minst = i;
            }
        }
        return minst;
    }
}



