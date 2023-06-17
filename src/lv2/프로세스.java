package lv2;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 프로세스 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            queue.add(priority);
        }
        while (!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == queue.peek()) {
                    queue.poll();
                    answer++;
                    if (i == location) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

@Test
    public void test() {

        assertEquals(1, solution(new int[]{2, 1, 3, 2}, 2));
        assertEquals(5, solution(new int[]{1, 1, 9, 1, 1, 1}, 0));

    }


}
