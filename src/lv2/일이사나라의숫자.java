package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
규칙은 숫자가 3개 이기때문에
/3을 한다 자릿수 대수 계산
3으로 나머지가 없는경우는 4
남은 값이 4인경우는 다시 3으로 맞춰줘야하므로 -1을 하여 3으로 변경
 */
public class 일이사나라의숫자 {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        //n을 3으로 나누어 0이 나오면 자릿수가 나옴
        while (n!=0) {
            //마지막 자리 부터 값나옴
            int val = n % 3;

            //자릿수
            n = n / 3;

            //3인경우 4로 변경
            if (val == 0) {
                val = 4;
                n--; //4인경우를 다시 3으로 맞춰줌
            }
            //answer에 넣고
            answer.append(val);
        }
        //역순으로 변경
        return answer.reverse().toString();
    }

    @Test
    public void test() {

        assertEquals(1, solution(1));
        assertEquals(2, solution(2));
        assertEquals(4, solution(3));
        assertEquals(11, solution(4));
    }


}
