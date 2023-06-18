package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 타겟넘버 {
    public int solution(int[] numbers, int target) {

        return dfs(0, numbers, target, 0);
    }

    private int dfs(int depth, int[] numbers, int target, int result) {
        int answer = 0;
        if (depth == numbers.length) {
            if(result == target){
                System.out.println("depth = " + depth + ", numbers = " + Arrays.toString(numbers) + ", target = " + target + ", result = " + result);
                answer++;}
        } else {
            answer += dfs(depth + 1, numbers, target, result + numbers[depth]);
            answer += dfs(depth + 1, numbers, target, result - numbers[depth]);
        }
        return answer;
    }
    @Test
    public void test() {
        assertEquals(5, solution(new int[]{1, 1, 1, 1, 1}, 3));
        assertEquals(2, solution(new int[]{4, 1, 2, 1}, 4));
    }


}
