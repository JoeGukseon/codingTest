import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 푸드파이트대회 {

    public String solution(int[] food) {
        int max = 1;

        for (int i = 1; i < food.length; i++) {
            food[i] /= 2;
            max += food[i] * 2;
        }

        int[] answer = new int[max];


        int idx = 1;
        for (int i = 0; i < (max-1) / 2; i++) {
            while (food[idx] == 0) {
                idx++;
            }
            answer[i] = idx;
            answer[(max - 1) - i] = idx;
            food[idx]--;
        }
        StringBuilder sb = new StringBuilder(max);
        for (int num : answer) {
            sb.append(num);
        }

        return sb.toString();
    }

    @Test
    public void test() {

        assertEquals("1223330333221", solution(new int[]{1, 3, 4, 6}));
        assertEquals("111303111", solution(new int[]{1, 7, 1, 2}));
    }


}

//다른사람 예제
// String answer = "0";
//
//        for (int i = food.length - 1; i > 0; i--) {
//            for (int j = 0; j < food[i] / 2; j++) {
//                answer = i + answer + i;
//            }
//        }
//
//        return answer;
//public String solution(int[] food) {
//    StringBuilder builder = new StringBuilder();
//    for (int i=1; i<food.length; i++) {
//        int result = food[i] / 2;
//        builder.append(String.valueOf(i).repeat(result));
//    }
//    String answer = builder + "0";
//    return answer + builder.reverse();
//}