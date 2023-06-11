package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 다음큰숫자 {

    public int solution(int n) {
        int answer = n + 1;
        int count = Integer.bitCount(n);

        while (Integer.bitCount(answer) != count) {
            answer++;
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(83, solution(78));
        assertEquals(23, solution(15));
    }


}
