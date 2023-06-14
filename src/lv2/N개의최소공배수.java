package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }
    public int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return (a / gcd) * b;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    @Test
    public void test() {

        assertEquals(168, solution(new int[]{2, 6, 8, 14}));
    }


}
