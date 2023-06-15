package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 귤고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Integer, Integer> entry : entryList) {
            Integer value = entry.getValue();
            if(k <= 0) {
                break;
            }
            answer++;
            k -= value;
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(3, solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        assertEquals(2, solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        assertEquals(1, solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }


}
