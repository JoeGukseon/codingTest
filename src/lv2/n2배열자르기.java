package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class n2배열자르기 {

    public int[] solution(int n, long left, long right) {
        //값을 담을 배열 선언 (크기는 right-left 에다가 +1)
        int[] answer = new int[(int) (right - left + 1)];

        //left 에서 right 까지 반복
        //인덱스는 i 에서 - left를 빼고 0부터 idx
        //max로 찾아온값 i/n , i%n 를 +1 int로 계산
        //10^7 * 2가 최대범위 임으로 long 으로 처리 해줘야한다 left , right 의 값이
        for (long i = left; i <= right; i++) {
            answer[(int)(i - left)] = (int)(Math.max(i / n, i % n) + 1);
        }
        System.out.println("arr = " + Arrays.toString(answer));
        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{3, 2, 2, 3}, solution(3, 2, 5));
    }


}
