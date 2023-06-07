package lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(works).forEach(priorityQueue::offer);

        for (int i = 0; i < n; i++) {
            Integer time = priorityQueue.poll();
            if (time == 0) {
                return 0;
            }
            priorityQueue.offer(--time);
        }

        return priorityQueue.stream().mapToLong(l -> (long) Math.pow(l, 2)).sum();
    }

    @Test
    public void test() {
        Assertions.assertEquals(12, solution(4, new int[]{4, 3, 3}));
    }


}
