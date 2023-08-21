import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 크레인인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                int pick = board[i][move-1];
                if (pick != 0) {
                    if (stack.isEmpty() || stack.peek() != pick) {
                        stack.push(pick);
                        board[i][move-1] = 0;
                    } else if (stack.peek() == pick) {
                        stack.pop();
                        answer+=2;
                        board[i][move-1] = 0;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    @Test
    public void test() {

//        assertEquals(4, solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
        assertEquals(6, solution(new int[][]{{0, 0, 0, 0},{0, 0, 0, 0},{0, 4, 4, 0},{1, 2, 2, 1}}, new int[]{2, 3, 1, 4, 2, 3}));
    }


}
