import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 나머지가1이되는수찾기 {

    public int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return 0;
    }
    @Test
    public void test() {

        assertEquals(3, solution(10));
        assertEquals(11, solution(12));
    }


}
