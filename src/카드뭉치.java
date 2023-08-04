import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int cIdx1 = 0;
        int cIdx2 = 0;
        for (String s : goal) {
            if (cards1[cIdx1].equals(s)) {
                if (cIdx1 < cards1.length-1) {
                    cIdx1++;
                }
            } else if (cards2[cIdx2].equals(s)) {
                if (cIdx2 < cards2.length-1) {
                    cIdx2++;
                }
            } else {
                return "No";
            }
        }
        return "Yes";
    }

    @Test
    public void test() {

//        assertEquals("Yes", solution(new String[]{"i", "drink", "water"},
//        new String[]{"want", "to"},
//        new String[]{"i", "want", "to", "drink", "water"}));
        assertEquals("No", solution(new String[]{"i", "water", "drink"},
                new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"}));
    }


}
