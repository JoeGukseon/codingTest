package lv2;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 짝지어제거하기 {

    public int solution(String s) {
        if (s.length() % 2 != 0) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty() ? 1 : 0;
    }

    @Test
    public void test() {

        assertEquals(1, solution("baabaa"));
        assertEquals(0, solution("cdcd"));
    }


}
