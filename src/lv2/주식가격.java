package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 주식가격 {
    //처음에 i기준으로 떨어졌다 올라가도 시간을 + 하는 조건으로 넣었는데 안되서 보니
    //떨어지는 시간 까지 계산하는거 였다.. 수정된 코드
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                answer[i]++;

                if(prices[i] > prices[j]) break;
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{4, 3, 1, 1, 0},solution(new int[]{1, 2, 3, 2, 3}));
        assertArrayEquals(new int[]{3, 2, 1, 1, 0},solution(new int[]{2, 2, 3, 1, 5}));
        assertArrayEquals(new int[]{4, 3, 2, 1, 0},solution(new int[]{1, 2, 3, 4, 1}));
    }


}
