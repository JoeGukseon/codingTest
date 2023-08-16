import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 시저암호 {

    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                answer.append((char)(c + n > 'Z' ? c + n - 26 : c + n));
            } else if (c >= 'a' && c <= 'z') {
                answer.append((char)(c + n > 'z' ? c + n - 26 : c + n));
            } else {
                answer.append(" ");
            }
        }

        return answer.toString();
    }

    @Test
    public void test() {
        assertEquals("BC", solution("AB", 1));
        assertEquals("a", solution("z", 1));
        assertEquals("e F d", solution("a B z", 4));
    }


}
