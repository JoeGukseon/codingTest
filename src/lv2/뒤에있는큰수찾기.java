package lv2;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 뒤에있는큰수찾기 {
    //처음에 O(N^2)으로 풀었다가 시간 초과
    //스택으로 비교하여 O(N)으로 변경
    public int[] solution(int[] numbers) {

//
//        for (int i = 0; i < numbers.length; i++) {
//            int val = -1;
//            for (int j = i; j < numbers.length; j++) {
//                if (numbers[i] < numbers[j]) {
//                    val = numbers[j];
//                    break;
//                }
//            }
//            answer[i] = val;
//        }

        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        // 스택에 역순으로 인덱스를 넣어주고
        // 비교값이 스택에 있는 수보다 클때만 스택을 빼준다
        // stack이 빈 경우는 큰수가 없으므로 -1을 해준다
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && numbers[stack.peek()] <= numbers[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = numbers[stack.peek()];
            }
            stack.push(i);
        }

        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{3, 5, 5, -1}, solution(new int[]{2, 3, 3, 5}));
        assertArrayEquals(new int[]{-1, 5, 6, 6, -1, -1}, solution(new int[]{9, 1, 5, 3, 6, 2}));
    }


}
