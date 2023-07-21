import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 과일장수 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : score) {
            if (i <= k) {
                queue.add(i);
            }
        }
        while (queue.size() >= m) {
            int minScore = 0;
            for (int i = 0; i < m; i++) { // 내림차순으로 정렬된 과일을 숫자만큼 뺌 마지막이 최소값
                minScore = queue.poll();
            }
            answer += minScore * m; //최소값 x 박스에 담을수있는 갯수
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(8, solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1}));
        assertEquals(33, solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }


}
