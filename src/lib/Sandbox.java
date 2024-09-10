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
        System.out.print("["+a[1]+"] ");
        int j = a[1];
        int i = 2;
        for ( ; i<a.length; i*=2) {
            if (a[i] == j) {
                System.out.print("["+a[i]+", "+a[i+1]+"] ");
            } else if (a[i+1] == j) {
                System.out.print("["+a[i]+", "+a[i+1]+"] ");
                i++;
            }
        }
    }

    public static int binærsok(int[] a, int x) {
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

    public static void quicksort(int[] a, int fra, int til) {
        if (til <= fra) {
            return;
        }
        int pivot = partisjon(a, fra, til);
        quicksort(a, fra, pivot-1);
        quicksort(a, pivot+1, til);
    }

    public static void quicksort(int[] a) {
        quicksort(a, 0, a.length-1);
    }

    private static int partisjon(int[] a, int fra, int til) {
        int pivot = a[til];
        int i = fra-1;

        for (int j = fra; j <= til-1; j++) {
            if (a[j] < pivot) {
                i++;
                Tabell.bytt(a, j, i);
            }
        }

        i++;
        Tabell.bytt(a, i, til);

        return i;
    }

    public static void mergesort(int[] a) {
        if (a.length <= 1) {
            return;
        }

        int m = a.length / 2;

        int[] v = new int[m];
        int[] h = new int[a.length-m];

        int i = 0;
        int j = 0;

        for ( ; i < a.length; i++) {
            if (i < m) {
                v[i] = a[i];
            } else {
                h[j] = a[i];
                j++;
            }
        }
        mergesort(v);
        mergesort(h);
        merge(a, v, h);
    }

    public static void merge(int[] a, int[] venstre, int[] høyre) {
        int venstreLengde = a.length/2;
        int høyreLengde = a.length - venstreLengde;

        int i = 0;
        int j = 0;
        int k = 0;

        while (j < venstreLengde && k < høyreLengde) {
            if (venstre[j] < høyre[k]) {
                a[i] = venstre[j];
                i++;
                j++;
            } else {
                a[i] = høyre[k];
                i++;
                k++;
            }
        }
        while (j < venstreLengde) {
            a[i] = venstre[j];
            i++;
            j++;
        }
        while (k < høyreLengde) {
            a[i] = høyre[k];
            i++;
            k++;
        }
    }
}
