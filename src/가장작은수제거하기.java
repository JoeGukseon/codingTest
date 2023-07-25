import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 가장작은수제거하기 {

    public int[] solution(int[] arr) {
        if (arr.length - 1 == 0) {
            return new int[]{-1};
        }

        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                minIdx = i;
            }
        }

        int[] answer = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != minIdx) {
                answer[j++] = arr[i];
            }
        }
        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{4,3,2}, solution(new int[]{4,3,2,1}));
        assertArrayEquals(new int[]{-1}, solution(new int[]{10}));
    }


}
