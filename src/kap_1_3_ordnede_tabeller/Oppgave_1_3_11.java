package kap_1_3_ordnede_tabeller;

public class Oppgave_1_3_11 {
    public static void main(String[] args) {
        // Oppgave 1b
        System.out.println(enkelFletting("SNESEVLD", "ADRLTO"));
    }

    // Oppgave 1a


    // Oppgave 1b
    public static String enkelFletting(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] stringA = a.toCharArray();
        char[] stringB = b.toCharArray();

        int lengde = stringA.length;
        if (stringB.length > stringA.length) {
            lengde = stringB.length;
        }

        for (int i = 0; i < lengde; i++) {
            if (i < stringA.length) {
                stringBuilder.append(stringA[i]);
            }
            if (i < stringB.length) {
                stringBuilder.append(stringB[i]);
            }
        }
        return String.valueOf(stringBuilder);
    }
}
