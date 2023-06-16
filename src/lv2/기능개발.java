package lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.offer((int) Math.ceil((double) (100 - progresses[i]) / speeds[i]));
        }
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        int prev = queue.peek();
        for (int n : queue) {
            if (n > prev) {
                answer.add(cnt);
                cnt = 1;
                prev = n;
            } else {
                cnt++;
            }
        }
        answer.add(cnt);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{2, 1}, solution(new int[]{93,30,55},new int[]{1,30,5}));
    }


}
