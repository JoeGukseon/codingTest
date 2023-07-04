package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
문자열로 변환 후
문자를 내림차순으로 정렬 610 < 62
String join 으로 합쳐 리턴

전부 0인경우가 예외가 발생하여 (테스트11)
예외처리

 */
public class 가장큰수 {
    public String solution(int[] numbers) {
        boolean zero = Arrays.stream(numbers).allMatch(n -> n == 0);
        if (zero) {
            return "0";
        }
        String[] arrStr = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(arrStr, (a, b) -> (b + a).compareTo(a + b));



        return String.join("",arrStr);
    }

    @Test
    public void test() {

        assertEquals("6210", solution(new int[]{6, 10, 2}));
    }


}
