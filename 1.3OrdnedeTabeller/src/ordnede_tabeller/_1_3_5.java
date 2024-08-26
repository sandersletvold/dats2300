package ordnede_tabeller;

public class _1_3_5 {
    public static void main(String[] args) {
        // 2, 15, 16, 40, 41
        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};
        System.out.print(" "+lineærsøk(a, 2));
        System.out.print(" "+lineærsøk(a, 15));
        System.out.print(" "+lineærsøk(a, 16));
        System.out.print(" "+lineærsøk(a, 40));
        System.out.print(" "+lineærsøk(a, 41));

        System.out.println();
        // 10, 12, 15, 24, 34
        System.out.print(" "+begrensetLineærsøk(a, 10, 3, 8));
        System.out.print(" "+begrensetLineærsøk(a, 12, 3, 8));
        System.out.print(" "+begrensetLineærsøk(a, 15, 3, 8));
        System.out.print(" "+begrensetLineærsøk(a, 24, 3, 8));
        System.out.print(" "+begrensetLineærsøk(a, 34, 3, 8));
    }
    // Oppgave 2
    public static int lineærsøk(int[] a, int verdi) { // legges i class Tabell
        if (a.length == 0 || verdi > a[a.length-1]) {
            return -(a.length + 1);  // verdi er større enn den største
        }
        int i = 0;
        for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    // Oppgave 4
    // Denne er litt feil tror jeg
    public static int begrensetLineærsøk(int[] a, int verdi, int fra, int til) { // legges i class Tabell
        if (til<=fra || verdi > a[til]) {
            return -(til + 1);  // verdi er større enn den største
        }
        int i = fra;
        for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    // Oppgave 5a
    public static int intervallLineærsøk(int[] a, int verdi, int k) { // legges i class Tabell
        if (a.length == 0 || verdi > a[a.length-1]) {
            return -(a.length + 1);  // verdi er større enn den største
        }
        int i = 0;
        for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    // Oppgave 5b

    // Oppgave 5c

    // Oppgave 6
}
