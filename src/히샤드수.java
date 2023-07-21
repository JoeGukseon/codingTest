import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class 히샤드수 {

    public boolean solution(int x) {
        int num = x;
        int res = 0;

        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return x % res == 0;
    }

    @Test
    public void test() {

        assertTrue(solution(10));
        assertTrue(solution(12));
    }


}
