package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 행렬의곱셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int i = 0 ; i < arr1.length ; ++i){
            for(int j = 0 ; j < arr2[0].length ; ++j){
                for (int k = 0; k < arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[][]{{15, 15},{15, 15},{15, 15}}, solution(new int[][]{{1, 4},{3, 2},{4, 1}},new int[][]{{3, 3},{3, 3}}));
    }


}
