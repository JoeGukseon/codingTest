package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 모음사전 {

    public int solution(String word) {
        //숫자의 자릿수별 값 (*5 +1)
        int[] val = {781, 156, 31, 6, 1};
        //응답값 , word의 자리값으로 초기화
        int answer = word.length();

        //word를 하나씩 받아 문자별로 값을 넣어주고 val 값 인덱스에 곱해준다.
        for (int i = 0; i < word.length(); i++) {
            int idx;
            switch (word.charAt(i)) {
                case 'A':
                    idx = 0;
                    break;
                case 'E':
                    idx = 1;
                    break;
                case 'I':
                    idx = 2;
                    break;
                case 'O':
                    idx = 3;
                    break;
                case 'U':
                    idx = 4;
                    break;
                default:
                    idx = -1;
                    break;
            }
            //val 인덱스값에 구해진 인덱스값을 곱하여 더해준다.
            if (idx != -1) {
                answer += val[i] * idx;
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(6, solution("AAAAE"));
    }


}
