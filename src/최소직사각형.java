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

처음에 풀려던게 dfs 사용해 풀려고 했는데 이걸 해보고 싶어서 추가 구현 (당연히 시간 초과)
 */
public class 최소직사각형 {
//    public int solution(int[][] sizes) {
//
//        int maxX = 0;
//        int maxY = 0;
//
//        for (int[] size : sizes) {
//            if (size[0] > size[1]) {
//                maxX = Math.max(maxX, size[0]);
//                maxY = Math.max(maxY, size[1]);
//            } else {
//                maxX = Math.max(maxX, size[1]);
//                maxY = Math.max(maxY, size[0]);
//            }
//        }
//        return maxX * maxY;
        int minWidth = 1000;
        int minHeight = 1000;

        public int solution(int[][] sizes) {
            searchMinArea(0, 0, 0, sizes);
            return minWidth * minHeight;
        }

        private void searchMinArea(int index, int currentWidth, int currentHeight, int[][] sizes) {
            System.out.println("index = " + index + ", currentWidth = " + currentWidth + ", currentHeight = " + currentHeight + ", sizes = " + Arrays.deepToString(sizes));
            if (index == sizes.length) {
                if (minWidth * minHeight > currentWidth * currentHeight) {
                    minWidth = currentWidth;
                    minHeight = currentHeight;
                }
                return;
            }

            int width = sizes[index][0];
            int height = sizes[index][1];

            // 현재 명함을 그대로 배치한 경우
            searchMinArea(index + 1, Math.max(currentWidth, width), Math.max(currentHeight, height),sizes);
            // 명함을 가로로 눕혀 배치한 경우
            searchMinArea(index + 1, Math.max(currentWidth, height), Math.max(currentHeight, width),sizes);
        }
//    }

    @Test
    public void test() {

//        assertEquals(4000, solution(new int[][]{{60, 50},{30, 70},{60, 30},{80, 40}}));
        assertEquals(3500, solution(new int[][]{{60, 50},{30, 70}}));
    }


}
