import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
문자열 처리했다가 시간 초과가 나 배열로 처리
 */
public class 햄버거만들기 {

    public int solution(int[] ingredient) {
        int answer = 0;
        int length = ingredient.length;
        int[] temp = new int[length];

        int j = 0;
        for (int i = 0; i < length; i++) {
            temp[j++] = ingredient[i];
            if (j >= 4 && temp[j - 4] == 1 && temp[j - 3] == 2 && temp[j - 2] == 3 && temp[j - 1] == 1) {
                j -= 4;
                answer++;
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(2, solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }


}
