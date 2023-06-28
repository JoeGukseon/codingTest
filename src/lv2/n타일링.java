package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//2n 타일링
public class n타일링 {

    public int solution(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 1;
        int b = 2;
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1_000_000_007;
            a = b;
            b = sum;
        }

        return sum;
    }

    @Test
    public void test() {

        assertEquals(5, solution(4));
    }


}
