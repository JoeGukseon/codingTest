package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 피로도 {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        return dfs(0, k, dungeons, visited);
    }

    private int dfs(int depth, int k, int[][] dungeons, boolean[] visited) {
        int answer=0;
        for (int i = 0; i < dungeons.length; i++) {
            System.out.println("depth = " + depth + ", k = " + k + ", dungeons = " + Arrays.deepToString(dungeons) + ", visited = " + Arrays.toString(visited)+", i = "+i);
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                answer = Math.max(answer, dfs(depth + 1, k - dungeons[i][1], dungeons, visited));
                visited[i] = false;
            }

        }
        System.out.println("answer = " + answer);
        return Math.max(answer, depth);
    }

    @Test
    public void test() {

        assertEquals(3, solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }


}
