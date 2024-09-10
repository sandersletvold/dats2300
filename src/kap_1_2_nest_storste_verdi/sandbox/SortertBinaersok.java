package kap_1_2_nest_storste_verdi.sandbox;

import lib.Tabell;
import lib.Sandbox;

public class SortertBinaersok {
    public static void main(String[] args) {
        int[] a = Tabell.randPerm(1000);
        Tabell.boblesortering(a);
        System.out.println(Sandbox.binærsok(a, 467));
    }
}
