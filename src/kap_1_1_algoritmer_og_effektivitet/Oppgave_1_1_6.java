package kap_1_1_algoritmer_og_effektivitet;

public class Oppgave_1_1_6 {
    public static void main(String[] args) {
        // Oppgave 4
        System.out.println("n = 5 blir: "+euler(5));
        euler();
    }

    public static double euler(int n) {
        double Hn = 1;
        for (int i = 2; i<=n; i++) {
            Hn += (double) 1 / i;
        }
        return Hn-Math.log(n);
    }

    public static void euler() {
        double Hn = 1;
        int i = 2;
        boolean b = true;
        while (b) {
            Hn += (double) 1 / i;
            if (String.valueOf(Hn-Math.log(i)).startsWith("0.577")) { // Hva sol helst etter 0.577
                double r = Hn-Math.log(i);
                System.out.println("Ved n = "+i+" ble resultatet: "+r);
                b = false;
            }
            i++;
        }
    }
}
