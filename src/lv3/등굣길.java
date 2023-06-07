package lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 등굣길 {
        public int solution(int m,int n, int[][]puddles) {
            int mod = 1_000_000_007;
            int[][] map = new int[n][m];

            for (int[] puddle : puddles) {
                map[puddle[1] - 1][puddle[0] - 1] = -1;
            }

            map[0][0] = 1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == -1) {
                        continue;
                    }
                    // 위쪽 경로 수
                    if (i > 0 && map[i - 1][j] != -1) {
                        map[i][j] += map[i - 1][j] % mod;
                    }
                    // 왼쪽 경로 수
                    if (j > 0 && map[i][j - 1] != -1) {
                        map[i][j] += map[i][j - 1] % mod;
                    }
                }
            }

            return map[n-1][m-1] % mod;
        }

        @Test
        public void test() {
            Assertions.assertEquals(4, solution(4, 3, new int[][]{{2,2}}));
        }


}
