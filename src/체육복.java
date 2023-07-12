import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
탐욕법 문제이고
먼저 List로 작성했다가 idx 문제가 발생해 Set으로 변경
앞뒤를 확인 후 Set에서 제거 - 1차
잃어버린사람이 여벌을 가져오는 경우를 만들어 선필터링 - 2차
minus가 우선적으로 - 3차
 */
public class 체육복 {

    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        Set<Integer> lostSet = new HashSet<>();


        for (int i : lost) {
            if (reserveSet.contains(i)) {
                reserveSet.remove(i);
            } else {
                lostSet.add(i);
            }
        }

        for (int i : lostSet) {
            int plus = i + 1;
            int minus = i - 1;

            if (reserveSet.contains(minus)) {
                reserveSet.remove(minus);
            } else if (reserveSet.contains(plus)) {
                reserveSet.remove(plus);
            } else {
                n--;
            }
        }

        return n;
    }

    @Test
    public void test() {

//        assertEquals(5, solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
//        assertEquals(4, solution(5, new int[]{2, 4}, new int[]{3}));
//        assertEquals(2, solution(3, new int[]{3}, new int[]{1}));
//        assertEquals(4, solution(5, new int[]{1,2,3}, new int[]{2,3,4}));
        assertEquals(5, solution(5, new int[]{2,4}, new int[]{1,3}));
    }


}
