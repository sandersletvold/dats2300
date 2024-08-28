package kap_1_2_nest_storste_verdi.sandbox;

import lib.Sandbox;

import java.util.Arrays;

public class Turnering {
    public static void main(String[] args) {
        int[] a = {2,5,9,5,8,6,5,4,1,7,6,8,4,2,5,7};
        int[] b = Sandbox.turnering(a);
        System.out.println(Arrays.toString(b));
        Sandbox.formaterTurnering(b);
    }
}