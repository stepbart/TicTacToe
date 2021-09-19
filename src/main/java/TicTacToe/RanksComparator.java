package TicTacToe;

import java.util.Comparator;

public class RanksComparator implements Comparator<String> {

    @Override
    public int compare(String string1, String string2) {
        int win1 = string1.charAt(0);
        int los1 = string1.charAt(2);
        int draw1 = string1.charAt(4);

        int win2 = string2.charAt(0);
        int los2 = string2.charAt(2);
        int draw2 = string2.charAt(4);

        if (string1.equals(string2)) {
            return 0;
        } else if (win1 < win2) {
            return 1;
        } else if (win1 == win2 && los1 < los2) {
            return 1;
        } else if (win1 == win2 && los1 == los2 && draw1 < draw2) {
            return 1;
        } else
            return -1;
    }
}
