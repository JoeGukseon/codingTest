import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 기사단원의무기 {

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int result = 0;
            for (int j = 1; j*j <= i; j++) {
                if (j * j == i) {
                    result ++;
                } else if (i % j == 0) {
                    result += 2;
                }
            }
            answer += result > limit ? power : result;
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(10, solution(5,3,2));
    }


}
