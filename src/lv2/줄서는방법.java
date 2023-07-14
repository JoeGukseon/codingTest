package lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
순열로 구하기
(k-1) / (n-1)!
k = (k-1) % (n-1)!
 */
public class 줄서는방법 {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>(n);

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        k--;

        for (int i = 0; i < n; i++) {
            factorial /= (n - i);
            int index = (int) (k / factorial);
            answer[i] = list.get(index);
            list.remove(index);
            k %= factorial;
        }

        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{3,1,2}, solution(3,5));
    }


}
