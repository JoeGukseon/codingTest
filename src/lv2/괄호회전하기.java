package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
괄호 회전하여 올바른지 확인
 */
public class 괄호회전하기 {

    public int solution(String s) {
        int answer = 0;
        //괄호 회전하기
        for (int i = 0; i < s.length(); i++) {
            //처음에만 s 그대로
            if (i != 0) {
                // 1~ 한글자찍 회전하기
                s = s.substring(1) + s.charAt(0);
            }
            // true로 셋팅
            answer++;
            //괄호를 구별하기 위한 스택선언
            Stack<Character> stack = new Stack<>();
            //괄호 루프
            for (char ch : s.toCharArray()) {
                //여는괄호가들어오면 stack에 푸시
                if (ch == '(' || ch == '[' || ch == '{') {
                    stack.push(ch);
                }
                //닫는괄호가 들어오면 푸시 하지 않고 stack 안 확인
                else if (ch == ')' || ch == ']' || ch == '}') {
                    //stack이 비어있으면 에러 (뒤에 여는게 온다해도 방향에러)
                    //에러시 false로 셋팅 후 다음 괄호문으로
                    if (stack.isEmpty()) {
                        answer--;
                        break;
                    }
                    //스택안에 여는 괄호 존재시 pop으로 가장 최근 값 빼기
                    char top = stack.pop();
                    //닫는괄호에 맞는 여는괄호가 바로앞에 있는지 확인
                    //clear 안할시 아래의 조건에서 한번 더 false(--)가 되어버림
                    if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                        answer--;
                        stack.clear();
                        break;
                    }
                }
            }
            //루프종료 후 스택안에 값이 남아있으면 false
            if (!stack.isEmpty()) {
                answer--;
            }
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(3, solution("[](){}"));
        assertEquals(2, solution("}]()[{"));
        assertEquals(0, solution("[)(]"));
        assertEquals(0, solution("}}}"));
        assertEquals(0, solution("{(})"));
    }


}
