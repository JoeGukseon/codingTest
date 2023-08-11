import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 키패드누르기 {

    public String solution(int[] numbers, String hand) {
        char[][] keyPad = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}
        };

        Map<Character, int[]> padMap = new HashMap<>();
        int[] leftPos = {3, 0};  // 왼손 시작 위치
        int[] rightPos = {3, 2}; // 오른손 시작 위치

        for (int i = 0; i < keyPad.length; i++) {
            for (int j = 0; j < keyPad[i].length; j++) {
                padMap.put(keyPad[i][j], new int[]{i, j});
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            char curChar = (char) (number + '0');
            int[] curPos = padMap.get(curChar);

            if (curChar == '1' || curChar == '4' || curChar == '7') {
                sb.append("L");
                leftPos = curPos;
            } else if (curChar == '3' || curChar == '6' || curChar == '9') {
                sb.append("R");
                rightPos = curPos;
            } else {
                int distToLeft = Math.abs(curPos[0] - leftPos[0]) + Math.abs(curPos[1] - leftPos[1]);
                int distToRight = Math.abs(curPos[0] - rightPos[0]) + Math.abs(curPos[1] - rightPos[1]);

                if (distToLeft < distToRight || (distToLeft == distToRight && hand.equals("left"))) {
                    sb.append("L");
                    leftPos = curPos;
                } else {
                    sb.append("R");
                    rightPos = curPos;
                }
            }
        }

        return sb.toString();
    }

    @Test
    public void test() {

        assertEquals("LRLLLRLLRRL", solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
    }


}
