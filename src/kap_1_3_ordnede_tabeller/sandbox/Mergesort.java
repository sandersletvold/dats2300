package kap_1_3_ordnede_tabeller.sandbox;

import lib.Sandbox;
import lib.Tabell;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(1000000);
        Sandbox.mergesort(a);
        System.out.println(Arrays.toString(a));
    }
}
