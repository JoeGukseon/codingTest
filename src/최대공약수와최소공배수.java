import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 최대공약수와최소공배수 {
    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (a * b) / gcd;
    }


    public int[] solution(int n, int m) {
        return new int[]{calculateGCD(n,m),calculateLCM(n,m)};
    }
    @Test
    public void test() {

        assertArrayEquals(new int[]{3,12}, solution(3,12));
    }


}
