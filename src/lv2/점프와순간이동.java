package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 점프와순간이동 {

    public int solution(int n) {
        int ans = 0;

        while(n!=0){
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }

    @Test
    public void test() {

        assertEquals(2, solution(5));
        assertEquals(2, solution(6));
        assertEquals(5, solution(5000));
    }


}
