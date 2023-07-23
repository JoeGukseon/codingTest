import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 문자열나누기 {

    public int solution(String s) {
        int cnt = 0;
        int x = s.charAt(0);
        int xCnt = 0;
        int otherCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) { //끝이면 cnt 증가 후 for문 탈출;
                cnt++;
                break;
            } else if (s.charAt(i) == x) { //같은 문자면 x를 증가
                xCnt++;
            } else { //다른 문자면 other를 증가
                otherCnt++;
            }

            if (xCnt == otherCnt) { //x와 other가 같은 갯수면 문자열 분리
                cnt++; //문자열 카운트 증가
                x = s.charAt(i + 1); //다음 문자 x에 넣기
                xCnt = 0; //카운트 초기화
                otherCnt = 0;
            }
        }
        return cnt;
    }

    @Test
    public void test() {

        assertEquals(3, solution("banana"));
        assertEquals(6, solution("abracadabra"));
        assertEquals(3, solution("aaabbaccccabba"));
    }


}
