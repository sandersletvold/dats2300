package lib;

public class Sandbox {
    public static int[] turnering(int[] a) {
        int[] b = new int[a.length*2];      // Oppretter nytt array med plass til turneringen
        b[0] = 0;      // Setter index 0 til -1 for å markere at denne ikke brukes

        int i = b.length-1;     // Lagrer bakerste index i det nye arrayet
        for (int j = a.length-1; j >= 0; j--) {     // Kjører gjennom det gamle arrayet
            b[i] = a[j];    // Setter bakerste index i det nye arrayet til bakerste index i det gamle
            i--;    // Gjør at neste plass vi fyller inn kommer til venstre for den forrige
        }

        for (int k = b.length-1; k>2; k--) {
            if (b[k] >= b[k-1]) {
                b[(k-1)/2] = b[k];
            } else {
                b[(k-1)/2] = b[k-1];
            }
        }
        return b;
    }

    public static void turneringFormatering(int[] a) {
        int j = 1;
        for (int i = 0; i<a.length; i++) {
            if (i == j) {
                System.out.println();
                j *= 2;
            }

            if (i == 0 || i == 1) {
                System.out.print("["+a[i]+"] ");
            } else if (i % 2 != 0) {
                System.out.print(a[i]+"] ");
            } else {
                System.out.print("["+a[i]+", ");
            }
        }
    }

    public static void turneringVinner(int[] a) {

    }

    public static int binaerSok(int[] a, int x) {
        int high = a.length-1;
        int low = 0;
        int mid = (low+high)/2;

        while (low <= high) {
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                high = mid-1;
            } else {
                low = mid+1;
            }
            mid = (low+high)/2;
        }
        return -1;
    }
}
