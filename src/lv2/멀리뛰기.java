package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 멀리뛰기 {

    public long solution(int n) {
        if (n <= 2) {
            return n;
        }

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

    @Test
    public void test() {

        assertEquals(5, solution(4));
        assertEquals(3, solution(3));
    }


}
