package kap_1_2_nest_storste_verdi.sandbox;

import lib.Metoder;

public class SortertBinaersok {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(1000);
        Metoder.bobleSortering(a);
        System.out.println(binaerSok(a, 467));
    }

    private static int binaerSok(int[] a, int x) {
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
