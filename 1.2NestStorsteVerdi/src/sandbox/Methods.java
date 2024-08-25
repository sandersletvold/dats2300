package sandbox;

import java.util.Random;

public class Methods {
    public static int[] fillArray(int l) {
        Random random = new Random();
        int[] a = new int[l];
        for (int i = 0; i<a.length; i++) {
            a[i] = random.nextInt(1, l+1);
        }
        return a;
    }

    public static void print(int[] a) {
        for (int i = 0; i<a.length; i++) {
            System.out.print(a[i]+", ");
            if (i % 25 == 0 && i != 0) {
                System.out.println();
            }
        }
    }

    public static void sort(int[] a) {
        for (int i = a.length; i>0; i--) {
            int maxNumber = index(a, 0, i);
            changeIndex(a, maxNumber, i-1);
        }
    }

    public static int index(int[] a, int start, int end) {
        int maxIndex = start;
        int max = a[start];
        for (int i = start+1; i<end; i++) {
            if (max < a[i]) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void changeIndex(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // [1,1,2,3,4,6,7,8,9,10]
    // 4

    public static String binarySearch(int[] a, int s) {
        int low = 0;
        int high = a.length - 1;
        int depth = 0;

        while (low <= high) {
            depth++;
            int index = low + (high - low) / 2; // Finn midtpunktet

            if (a[index] == s) {
                return s + " ble funnet etter " + depth + " søk";
            } else if (a[index] > s) {
                high = index - 1; // Søk i venstre halvdel
            } else {
                low = index + 1; // Søk i høyre halvdel
            }
        }

        return s + " ble ikke funnet etter " + depth + " søk";
    }

    public static String normalSearch(int[] a, int s) {
        for (int i = 0; i<a.length; i++) {
            if (a[i] == s) {
                return s+" ble funnet på index: "+i;
            }
        }
        return s+" ble ikke funnet";
    }
}
