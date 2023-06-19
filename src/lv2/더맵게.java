package lv2;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            int lowestScoville = queue.poll();
            if (lowestScoville >= K) {
                return answer;
            }

            if (queue.isEmpty()) {
                return -1;
            }

            int secondLowestScoville = queue.poll();
            int mixedScoville = lowestScoville + (secondLowestScoville * 2);
            queue.add(mixedScoville);
            answer++;
        }

        return -1;
    }

    @Test
    public void test() {

        assertEquals(2, solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }


}
