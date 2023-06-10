package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 숫자의표현 {
    private int answer = 0;

    public int solution(int n) {
        for (int i = 1; i <= n; i++) {
            calculate(i, 0, n);
        }
        return answer;
    }

    private void calculate(int m, int sum, int target) {
        if (sum == target) {
            answer++;
            return;
        } else if (sum < target) {
            calculate(m + 1, sum + m, target);
        } else if (sum > target) {
            return;
        }
    }

    @Test
    public void test() {

        assertEquals(4, solution(15));
    }


}
