import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 가장가까운같은글자 {

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            boolean zero = true;
            int cnt = 0;
            for (int j = i; j > 0; j--) {
                cnt--;
                if (s.charAt(i + cnt) == s.charAt(i)) {
                    zero = false;
                    break;
                }
            }
            if (!zero) {
                answer[i] = Math.abs(cnt);
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }
    @Test
    public void test() {

        assertArrayEquals(new int[]{-1, -1, -1, 2, 2, 2}, solution("banana"));
        assertArrayEquals(new int[]{-1, -1, 1, -1, -1, -1}, solution("foobar"));

    }


}
