package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 카펫 {

    public int[] solution(int brown, int yellow) {

        int row = 0;
        int col = 0;

        //전체 칸수
        int total = brown + yellow; //총사이즈

        //약수를 구하는데 최소 크기가 3이상인 약수만 구한다.
        for (int i = 3; i < total; i++) {
            if (total % i == 0) {
                // 가로 세로 구하기
                col = total / i;
                row = i;

                //옐로우 색의 크기 확인
                if (((col - 2) * (row - 2)) == yellow) {
                    break;
                }
            }
        }

        //가로가 크다 했으니 가로는 큰수 세로는 작은수
        return new int[]{Math.max(col,row), Math.min(col,row)};
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{4, 3}, solution(10, 2));
        assertArrayEquals(new int[]{3, 3}, solution(8, 1));
        assertArrayEquals(new int[]{8, 6}, solution(24, 24));
        assertArrayEquals(new int[]{6,4}, solution(16, 8));
    }


}
