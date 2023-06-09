package lv2;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 최솟값만들기 {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            q1.offer(A[i]);
            q2.offer(B[i]);
        }

        for (int i=0; i < A.length; i++) {
            answer = answer + (q1.poll()*q2.poll());
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(29, solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
        assertEquals(10, solution(new int[]{1, 2}, new int[]{3, 4}));
    }


}
