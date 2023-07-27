import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 덧칠하기 {

    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int idx = section[0]; //초기 시작
        int limit = idx + m; //초기 칠 끝
        for (int i : section) { //안칠한부분이
            if (i >= limit) { //끝보다 크면
                answer++; //칠 횟수증가
                idx = i; //칠 업데이트
                limit = idx + m;
            }
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(2, solution(8, 4, new int[]{2, 3, 6}));
        assertEquals(1, solution(5, 4, new int[]{1,3}));
        assertEquals(4, solution(4, 1, new int[]{1,2,3,4}));
    }


}
