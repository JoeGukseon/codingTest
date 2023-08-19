import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
case 문 에서 -> map 활용으로 변경
 */
public class 공원산책 {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        outerLoop:
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    answer[0] = i; //y
                    answer[1] = j; //x
                    break outerLoop;
                }
            }
        }

        Map<String, int[]> directions = new HashMap<>();
        directions.put("E", new int[]{0, 1});
        directions.put("W", new int[]{0, -1});
        directions.put("S", new int[]{1, 0});
        directions.put("N", new int[]{-1, 0});

        for (String s : routes) {
            String[] parts = s.split(" ");
            String dir = parts[0];
            int step = Integer.parseInt(parts[1]);

            int[] direction = directions.get(dir);
            int dy = direction[0];
            int dx = direction[1];

            boolean flag = true;
            for (int i = 1; i <= step; i++) {
                int newY = answer[0] + dy * i;
                int newX = answer[1] + dx * i;

                if (newX < 0 || newX >= park[0].length() || newY < 0 || newY >= park.length || park[newY].charAt(newX) == 'X') {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                answer[0] += dy * step;
                answer[1] += dx * step;
            }
        }

        return answer;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{2, 1}, solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"}));
        assertArrayEquals(new int[]{0, 1}, solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"}));
        assertArrayEquals(new int[]{0, 0}, solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"}));
    }


}
