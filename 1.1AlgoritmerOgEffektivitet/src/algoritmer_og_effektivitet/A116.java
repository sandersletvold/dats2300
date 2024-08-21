package algoritmer_og_effektivitet;

public class A116 {
    public static void main(String[] args) {
        // Oppgave 1
        /* I en tabell med n (n > 1) forskjellige tall er i gjennomsnitt
        1/2 + 1/3 + 1/4 + . . . . + 1/n  av dem større enn det største av de foran.

        n=5 stemmer med dette fordi 24 permutasjoner av 120 har 5 som første tall. Dette tilsvarer 1/5.
        1/2 + 1/3 + 1/4 + 1/5 = 60/120 + 40/120 + 30/120 + 24/120 = 154/120 = 1,28
        Dette betyr at med n = 5 vil i snitt 1,28 tall være større enn det forrige. */

        // Oppgave 2
        boolean sokEtter0577 = false;
        int sokeTall = 1;

        while (!sokEtter0577) {
            if (euler(sokeTall) > 0.577 && euler(sokeTall) < 0.578) {
                System.out.println("n="+sokeTall+" blir "+euler(sokeTall));
                sokEtter0577 = true;
            }
            sokeTall++;
        }
    }

    // Oppgave 2
    public static double euler(int n) {
        double Hn = 0;
        for (int i = 1; i<=n; i++) {
            Hn += (double) 1 / i;
        }

        double log = Math.log(n);
        return Hn-log;
    }
}
