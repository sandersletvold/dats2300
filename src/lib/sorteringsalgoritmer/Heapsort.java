package lib.sorteringsalgoritmer;

import lib.Tabell;

import java.util.Arrays;

public class Heapsort {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(20);
        System.out.println(Arrays.toString(a));
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
    // To heapify a subtree rooted with node i
    // which is an index in a[].
    public static void heapify(int a[], int n, int i) {
        // Initialize largest as root
        int largest = i;
        // left index = 2*i + 1
        int l = 2 * i + 1;
        // right index = 2*i + 2
        int r = 2 * i + 2;
        // If left child is larger than root
        if (l < n && a[l] > a[largest]) {
            largest = l;
        }
        // If right child is larger than largest so far
        if (r < n && a[r] > a[largest]) {
            largest = r;
        }
        // If largest is not root
        if (largest != i) {
            bytt(a, i, largest);
            // Recursively heapify the affected sub-tree
            heapify(a, n, largest);
        }
    }

    public static void bytt(int[] a, int i, int largest) {
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;
    }

    // Main function to do heap sort
    public static void heapSort(int a[]) {
        int n = a.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            // Call max heapify on the reduced heap
            heapify(a, i, 0);
        }
    }
}
