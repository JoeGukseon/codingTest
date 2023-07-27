import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 문자열을정수로바꾸기 {

    public int solution(String s) {
        return Integer.parseInt(s);
    }

    @Test
    public void test() {

        assertEquals(1234, solution("1234"));
        assertEquals(-1234, solution("-1234"));
    }


}
