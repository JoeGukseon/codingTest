import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* https://wooaoe.tistory.com/50 효율적인 계산 참조
* */
public class 소수찾기 {

    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        int root = (int) Math.sqrt(n); // 제곱근 계산
        for (int i = 2; i <= root; i++) {
            if (prime[i]) {
                for (int j = i; i * j <= n; j++) //배수 체크
                    prime[i * j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i])
                answer++;
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(4, solution(10));
        assertEquals(3, solution(5));
    }


}
