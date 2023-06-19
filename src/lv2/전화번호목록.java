package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 전화번호목록 {

    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (set.contains(number.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(false, solution(new String[]{"97674223", "1195524421", "119"}));
//        assertEquals(true, solution(new String[]{"123","456","789"}));
//        assertEquals(false, solution(new String[]{"12","123","1235","567","88"}));
    }


}
