package lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
        public int solution(int[][] routes) {
                int answer = 0;
                Arrays.sort(routes, Comparator.comparingInt((int[] a) -> a[1]));

                int cameraPos = -30000;
                for (int[] route : routes) {
                    if (cameraPos < route[0]) {
                        cameraPos = route[1];
                        answer++;
                    }
                }
                return answer;
            }
        
            @Test
            public void test() {
                
                Assertions.assertEquals(2, solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));
            }
        
                    
}
