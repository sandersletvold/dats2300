package kap_1_3_ordnede_tabeller;

import lib.Metoder;

public class Oppgave_1_3_6 {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(100);
        Metoder.bobleSortering(a);
        // Oppgave 1
        System.out.print("Oppgave 1\n"+Metoder.binaersok(a, 63)+" ");
        System.out.print(binærsøk1(a, 0, a.length, 63)+" ");
        System.out.print(binærsøk2(a, 0, a.length, 63)+"\n");

        // Oppgave 2
        int[] b = {2, 5, 6, 9, 10, 12, 15, 17, 19, 19, 19, 19, 22, 23, 25};
        System.out.println("\nOppgave 2");
        System.out.println(binærsøk1(b, 0, 10, 26));

        // Oppgave 3
        int[] c = {1, 3, 4, 4, 5, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15};
        System.out.println("\nOppgave 3");
        System.out.print(binærsøk1(c, 0, c.length, 4)+" "); // Siste
        System.out.print(binærsøk1(c, 0, c.length, 7)+" "); // Første
        System.out.print(binærsøk1(c, 0, c.length, 10)+" "); // Første
        System.out.print(binærsøk1(c, 0, c.length, 15)+" "); // Midterste

        // Oppgave 4
        System.out.println("\n\nOppgave 4");
        System.out.print(Metoder.binaersok(c, 0, c.length, 4)+" "); // Første
        System.out.print(Metoder.binaersok(c, 0, c.length, 15)+" "); // Første

        // Oppgave 5
        /* Ved (v+h+1)/2 og tabellen er 11 vil midten bli:
           (0+10+1)/2 = 5.5
           m vil bli index 5 som er helt midt på midten

           Ved (v+h+1)/2 og tabellen er 10 vil midten bli:
           (0+9+1)/2 = 5
           m vil bli index 5 som nå er til høyre for midten
        */
    }

    // 1, 3, 4, 4, 5, 7, 7, 7, 7, 8, 9, 10, 10, 12, 15, 15, 15
    public static int binærsøk1(int[] a, int fra, int til, int verdi)
    {
        Metoder.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk2(int[] a, int fra, int til, int verdi)
    {
        Metoder.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            int midtverdi = a[m];  // hjelpevariabel for  midtverdien

            if (verdi > midtverdi) v = m + 1;        // verdi i a[m+1:h]
            else if (verdi < midtverdi) h = m - 1;   // verdi i a[v:m-1]
            else return m;                           // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }
}
