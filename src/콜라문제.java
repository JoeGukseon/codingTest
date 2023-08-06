import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 콜라문제 {

    public int solution(int a, int b, int n) {
        int answer = 0;
        int cnt = n;
        int mod = 0;
        while (true) {
            if (cnt < a) { //현재 바꾼 병수가 바꿀수있는 병수보다 작을때
                if (cnt + mod < a) { //못바꿨던 나머지를 더해도 작으면 종료
                    break;
                }
                cnt += mod; //나머지를 병에 더하고
                mod = 0; //나머지 초기화
            }
            if (cnt >= a) { //나머지값 계산할수있을때
                mod += (cnt % a);//다시 나머지값 구하고
            }
            cnt = (cnt / a) * b;//병을 바꾸고
            answer += cnt;//바꾼병을 더해주고
        }

        return answer;

    }

    @Test
    public void test() {

        assertEquals(19, solution(2, 1, 20));
        assertEquals(9, solution(3, 1, 20));
    }


}
