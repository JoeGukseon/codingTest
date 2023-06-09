package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 이진변환반복하기 {

    public int[] solution(String s) {
        int[] answer = new int[2];

        int cnt = 0;
        int zCnt = 0;

        while (!s.equals("1")) {
            cnt++;
            zCnt += (int) s.chars()
                    .filter(c -> c != '1')
                    .count();
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
        }

        answer[0] = cnt;
        answer[1] = zCnt;
        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{3, 8}, solution("110010101001"));
    }


}
