package lv2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 피보나치수 {
    Map<Integer, Integer> memo = new HashMap<>();

    public int solution(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            int result = (solution(n - 1) + solution(n - 2)) % 1234567;
            memo.put(n, result);
            return result;
        }
    }

    @Test
    public void test() {
        assertEquals(2, solution(3));
        assertEquals(5, solution(5));
    }


}
