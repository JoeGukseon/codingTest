package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
필수한 갯수 만큼 인덱스를 돌려 그중에 가장 큰수를 모아 리턴
4개의 숫자중 2개의 숫자의 큰수이면 4-2를 하고
4개의 숫자를 0부터 +1씩증가하여 2번에 다 순회하게끔 3개씩 묶어서 계산(대신 기존 가장큰수의 인덱스 이후 부터 검색
 */
public class 큰수만들기 {

    public String solution(String number, int k) {
        int length = number.length() - k;
        char[] result = new char[length];
        int idx = 0;

        for(int i = 0; i < length; i++) {
            char max = 0;
            for(int j = idx; j <= i + k; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            result[i] = max;
        }

        return new String(result);
    }

    @Test
    public void test() {

        assertEquals("94", solution("1924",2));
    }


}
