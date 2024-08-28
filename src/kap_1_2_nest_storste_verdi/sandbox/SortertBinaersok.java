package kap_1_2_nest_storste_verdi.sandbox;

import lib.Metoder;
import lib.Sandbox;

public class SortertBinaersok {
    public static void main(String[] args) {
        int[] a = Metoder.randPerm(1000);
        Metoder.bobleSortering(a);
        System.out.println(Sandbox.binaerSok(a, 467));
    }
}
