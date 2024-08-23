package nest_storste_verdi;

public class SortAndSearch {
    public static void main(String[] args) {
        int[] a = Methods.fillArray(10000);
        System.out.println("Tilfeldig tabell");
        Methods.print(a);

        System.out.println("\n\nNormalt søk\n"+Methods.normalSearch(a, 22));

        Methods.sort(a);

        System.out.println("\nSortert tabell");
        Methods.print(a);

        System.out.println("\n\nBinært søk\n"+Methods.binarySearch(a, 22));
    }
}
