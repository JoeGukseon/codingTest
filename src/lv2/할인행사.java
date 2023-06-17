package lv2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                discountMap.put(discount[i + j], discountMap.getOrDefault(discount[i + j], 0) + 1);
            }
            boolean check = true;
            for (String key : map.keySet()) {
                if (!discountMap.containsKey(key) || discountMap.get(key) < map.get(key)) {
                    check = false;
                    break;
                }
            }
            answer += check ? 1 : 0;
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(3, solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                        "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
    }
}
