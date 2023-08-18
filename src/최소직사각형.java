import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
명함의 정보를 int[][]로 줌
주어진 명함에서 가장 큰 가로와 세로로 지갑을 만듬 80,70
-> 30,70 명함을 가로 세로 바꾸면 80,50으로 모든 명함을 넣을수 있는 지갑을 만들수있음.
이 최소 직사각형을 반환 해야함
80*50 = 4000

문제풀이는 x,y중 큰쪽을 한쪽으로 몰면 x는 모든명함의 긴쪽, y는 모든 명함 짧은수가 된다. 그중에서 가장큰길이로 곱

 */
public class 최소직사각형 {
    public int solution(int[][] sizes) {

        int maxX = 0;
        int maxY = 0;

        for (int[] size : sizes) {
            if (size[0] > size[1]) {
                maxX = Math.max(maxX, size[0]);
                maxY = Math.max(maxY, size[1]);
            } else {
                maxX = Math.max(maxX, size[1]);
                maxY = Math.max(maxY, size[0]);
            }
        }
        return maxX * maxY;
    }

    @Test
    public void test() {

        assertEquals(4000, solution(new int[][]{{60, 50},{30, 70},{60, 30},{80, 40}}));
    }


}
