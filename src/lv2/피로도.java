package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 피로도 {
    int answer;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(0, k, dungeons, visited);
        return answer;
    }

    private void dfs(int depth, int k, int[][] dungeons, boolean[] visited) {

        for (int i = 0; i < dungeons.length; i++) {
            System.out.println("depth = " + depth + ", k = " + k + ", dungeons = " + Arrays.deepToString(dungeons) + ", visited = " + Arrays.toString(visited)+", i = "+i);
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }

        }
        answer = Math.max(answer, depth);
    }

    @Test
    public void test() {

        assertEquals(3, solution(80, new int[][]{{80, 20}, {50, 40}, {30, 10}}));
    }


}
