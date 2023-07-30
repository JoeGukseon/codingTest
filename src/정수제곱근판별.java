import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 정수제곱근판별 {

    public long solution(long n) {
        //제곱근을 구함
        long sqrtN = (long) Math.sqrt(n); //결과가 정수로 나옴

        //정수 확인 후 정수 이면 +1값의 제곱을 리턴
        if (sqrtN * sqrtN == n) {
            return (sqrtN + 1) * (sqrtN + 1);
        } else { //정수가 아니면 -1 리턴
            return -1;
        }
    }
    @Test
    public void test() {

        assertEquals(144, solution(121));
        assertEquals(-1, solution(3));
    }


}
