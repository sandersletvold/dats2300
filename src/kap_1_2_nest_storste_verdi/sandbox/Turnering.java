package kap_1_2_nest_storste_verdi.sandbox;

import lib.Metoder;
import lib.Sandbox;

public class Turnering {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(32);
        int[] b = Sandbox.turnering(a);
        Sandbox.turneringFormatering(b);
    }
}