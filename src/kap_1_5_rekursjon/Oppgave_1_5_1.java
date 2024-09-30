package kap_1_5_rekursjon;

public class Oppgave_1_5_1 {
    public static void main(String[] args) {
        System.out.println(a(3));
        System.out.println(kvadratTall(4));
        System.out.println(fakultet(5));
        System.out.println(fib(40)); // 50 blir større enn lovlig verdi for en int
    }

    // Oppgave 1
    public static int a(int n) {          // n et ikke-negativt tall
        if (n < 0) throw new IllegalArgumentException("n er negativ!");

        int x = 0, y = 1, z = 1;

        for (int i = 0; i < n; i++) {
            z = 2*y + 3*x; x = y; y = z;
        }
        return z;
    }

    // Oppgave 7
    public static int kvadratTall(int n) {
        if (n == 1) return 1;
        return kvadratTall(n-1) + n*n;
    }

    // Oppgave 10
    public static int fakultet(int n) {
        if (n == 1) return 1;
        return fakultet(n-1) * n;
    }

    // Oppgave 11
    public static int fib(int n) {        // det n-te Fibonacci-tallet
        if (n <= 1) return n;              // fib(0) = 0, fib(1) = 1
        else return fib(n-1) + fib(n-2);   // summen av de to foregående
    }

    // Oppgave 14
}

