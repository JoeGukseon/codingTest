package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 타겟넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }

    private void dfs(int depth, int[] numbers, int target, int result) {
        if (depth == numbers.length) {
            if(result == target){
                System.out.println("depth = " + depth + ", numbers = " + Arrays.toString(numbers) + ", target = " + target + ", result = " + result);
                answer++;}
        } else {
            dfs(depth + 1, numbers, target, result + numbers[depth]);
            dfs(depth + 1, numbers, target, result - numbers[depth]);
        }
    }
    @Test
    public void test() {
        assertEquals(5, solution(new int[]{1, 1, 1, 1, 1}, 3));
        answer = 0;
        assertEquals(2, solution(new int[]{4, 1, 2, 1}, 4));
    }


}
