import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 약수의합 {

    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer += i;

                if (i != Math.sqrt(n)) {
                    answer += n / i;
                }
            }
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(28, solution(12));
    }


}
