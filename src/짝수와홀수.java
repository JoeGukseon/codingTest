import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 짝수와홀수 {

    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    @Test
    public void test() {

        assertEquals("Odd", solution(3));
        assertEquals("Even", solution(4));
    }


}
