import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 모든정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {

            answer += i;
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(12, solution(3,5));
    }


}
