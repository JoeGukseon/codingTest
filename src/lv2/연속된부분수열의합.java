package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
투포인터를 이용하여 수열을 계산
기본 right를 이동시켜 더해주고
목표값을 넘으면 left를 이동으로 수열을 찾는다
두개의 포인터를 사용하여 찾으면 O(N)
 */
public class 연속된부분수열의합 {
    public int[] solution(int[] sequence, int k) {
        //왼쪽 포인터
        int left = 0;

        //구한 수열의 크기(초기화 가장큰크기)
        int size = sequence.length;

        int[] answer = new int[]{0,0};

        int sum = 0;

        //오른쪽 포인터
        for (int right = 0; right < sequence.length; right++) {
            //오른쪽 값을 더해가며
            sum += sequence[right];

            //값이 목표값을 초과하는 경우 left를 빼준다 left 인덱스 증가 작아질때까지 포인터 이동
            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            //값이 같은경우 (목표값) 수열크기를 비교하여 수열크기가 작은경우 size,answer에 할당
            if (sum == k) {
                if (size > right - left) {
                    size = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        return answer;
    }
    @Test
    public void test() {

        assertArrayEquals(new int[]{2,3}, solution(new int[]{1, 2, 3, 4, 5},7));
        assertArrayEquals(new int[]{6,6}, solution(new int[]{1, 1, 1, 2, 3, 4, 5},5));
        assertArrayEquals(new int[]{0,2}, solution(new int[]{2, 2, 2, 2, 2},6));

    }


}
