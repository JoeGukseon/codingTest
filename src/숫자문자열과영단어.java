import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 숫자문자열과영단어 {

    public int solution(String s) {
        Map<String, Integer> wordToNumber = new HashMap<>();
        wordToNumber.put("zero", 0);
        wordToNumber.put("one", 1);
        wordToNumber.put("two", 2);
        wordToNumber.put("three", 3);
        wordToNumber.put("four", 4);
        wordToNumber.put("five", 5);
        wordToNumber.put("six", 6);
        wordToNumber.put("seven", 7);
        wordToNumber.put("eight", 8);
        wordToNumber.put("nine", 9);

        StringBuilder currentWord = new StringBuilder();
        int result = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result = result * 10 + (c - '0');
            } else {
                currentWord.append(c);
                if (wordToNumber.containsKey(currentWord.toString())) {
                    result = result * 10 + wordToNumber.get(currentWord.toString());
                    currentWord.setLength(0);
                }
            }
        }

        return result;
    }
    @Test
    public void test() {
        assertEquals(1478, solution("one4seveneight"));
        assertEquals(234567, solution("23four5six7"));
        assertEquals(234567, solution("2three45sixseven"));
        assertEquals(123, solution("123"));
    }


}
