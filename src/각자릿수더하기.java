import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 각자릿수더하기 {


    public int solution(int n) {
        int answer = 0;
        for (char c : String.valueOf(n).toCharArray()) {
            answer += (int) c - '0';
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(6, solution(123));
    }


}
