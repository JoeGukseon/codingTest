package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 땅따먹기 {

    int solution(int[][] land) {
        int answer = 0;

        for(int i = 1; i < land.length; i++) {
            land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3])); // 이전 행에서 현재칸을 제외한 칸의 최대값을 더함
            land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
            land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
            land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
        }
        for(int score : land[land.length-1]){
            answer = Math.max(answer, score);
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(16, solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}));

    }


}
