package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
* https://dlee0129.tistory.com/156
* 블로그 참조
* */
public class 전력망을둘로나누기 {
    public List<Integer>[] list;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            list[wire[0]].add(wire[1]);
            list[wire[1]].add(wire[0]);
        }

        for (int[] wire : wires) {
            int n1 = bfs(wire[0], wire[1]);
            int n2 = bfs(wire[1], wire[0]);

            answer = Math.min(answer, Math.abs(n1 - n2));
        }

        return answer;
    }

    public int bfs(int v1, int v2) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[list.length];

        int cnt = 0;

        queue.add(v1);
        visit[v1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int cur = queue.poll();
                cnt++;

                for (int next : list[cur]) {
                    if (next != v2 && !visit[next]) {
                        queue.add(next);
                        visit[next] = true;
                    }
                }
            }
        }

        return cnt;
    }

    @Test
    public void test() {

        assertEquals(3, solution(9,new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }


}
