import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 삼총사 {
        int answer = 0;
    public int solution(int[] number) {
        List<Integer> list = new ArrayList<>();
        generateCombinations(number, list, 0, 3);
        return answer;
    }

    private void generateCombinations(int[] number, List<Integer> list, int start, int depth) {
        System.out.println("number = " + Arrays.toString(number) + ", list = " + list + ", start = " + start + ", depth = " + depth + ", answer = " + answer);
        if (depth == 0) {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            if (sum == 0) {
                answer++;
            }
            return;
        }

        for (int i = start; i < number.length; i++) {
            list.add(number[i]);
            generateCombinations(number, list, i + 1, depth - 1);
            list.remove(list.size() - 1);
        }
    }

    @Test
    public void test() {
        assertEquals(2, solution(new int[]{-2, 3, 0, 2, -5}));
    }
}
