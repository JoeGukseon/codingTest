import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
재귀는 오버헤드 발생(메서드호출시)
반복문이 좀 더 효율적임
 */
public class 소수만들기 {


    public int solution(int[] nums) {
        int answer=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {

        assertEquals(1, solution(new int[]{1,2,3,4}));
        assertEquals(4, solution(new int[]{1,2,7,6,4}));
    }


}
