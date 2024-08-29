package kap_1_2_nest_storste_verdi.sandbox;

import lib.Metoder;
import lib.Sandbox;

import java.util.Arrays;

public class Turnering {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(8);
        int[] b = Sandbox.turnering(a);
        // System.out.println(Arrays.toString(b));
        Sandbox.turneringVinner(b);
        System.out.println("\n"+Arrays.toString(a));
        // Sandbox.turneringFormatering(b);
    }
}