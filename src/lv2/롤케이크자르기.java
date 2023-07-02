package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Map에 토핑 데이터를 다 넣어놓고 (종류 = size)
    토핑을 하나씩 Set에 넣은후 Set과 남은 Map을 비교
*/
public class 롤케이크자르기 {

    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i : topping) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        for (int i : topping) {
            countMap.put(i, countMap.get(i) - 1);
            set.add(i);
            if (countMap.get(i) == 0) {
                countMap.remove(i);
            }
            if (countMap.size() == set.size()) {
                answer++;
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(2, solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2}));
        assertEquals(0, solution(new int[]{1, 2, 3, 1, 4}));
    }


}
