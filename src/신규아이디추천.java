import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 신규아이디추천 {

    public String solution(String new_id) {
        //1.대문자 소문자로
        String step1 = new_id.toLowerCase();

        //2.소문자 숫자 - , _ , .
        String step2 = step1.replaceAll("[^a-z0-9-_.]", "");

        //3. 마침표 2번이상은 .으로
        String step3 = step2.replaceAll("\\.{2,}", ".");

        //4. 문자열의 처음, 마지막이 마침표이면 제거
        String step4 = step3;
        if (step3.startsWith(".")) {
            step4 = step3.substring(1);
        }
        if (step4.endsWith(".")) {
            step4 = step4.substring(0, step4.length() - 1);
        }

        //5: 빈 문자열이면 "a" 대입
        String step5 = step4.isEmpty() ? "a" : step4;

        //6: 길이가 16 이상이면 처음 15개 문자만 남기기, 마지막 마침표 제거
        String step6 = step5;
        if (step5.length() >= 16) {
            step6 = step5.substring(0, 15);
            if (step6.endsWith(".")) {
                step6 = step6.substring(0, step6.length() - 1);
            }
        }

        //7: 길이가 2 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 붙이기
        StringBuilder step7 = new StringBuilder(step6);
        while (step7.length() <= 2) {
            step7.append(step7.charAt(step7.length() - 1));
        }

        return step7.toString();
    }
    @Test
    public void test() {

        assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
    }


}
