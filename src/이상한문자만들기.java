import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
1차 짝수로 구분하여 처리
2차 그냥 " "기준으로 flag처리
 */
public class 이상한문자만들기 {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean toUpperCase = true; // 짝수번째 문자는 대문자로 시작하도록 설정

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 공백이면 다음 단어로 넘어가도록 설정
            if (ch == ' ') {
                answer.append(" ");
                toUpperCase = true; // 다음 단어는 대문자로 시작하도록 설정
            } else {
                // 대소문자 변환 및 결과에 추가
                answer.append(toUpperCase ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
                toUpperCase = !toUpperCase; // 다음 문자의 대소문자 반전
            }
        }

        return answer.toString();
    }
    @Test
    public void test() {

        assertEquals("TrY HeLlO WoRlD", solution("try hello world"));
    }


}
