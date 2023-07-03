import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 같은숫자는싫어 {

    public int[] solution(int []arr) {
        if (arr.length == 0) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        for (int j : arr) {
            if (stack.isEmpty() || stack.peek() != j) {
                stack.push(j);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{1,3,0,1}, solution(new int[]{1,1,3,3,0,1,1}));
    }


}
