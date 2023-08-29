import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        int cnt = Integer.MAX_VALUE;
        int sum = 0;
        boolean flag = false;

        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                flag = true;
                cnt = Math.min(cnt, (right - left)+1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        if(!flag) return 0;
        else return cnt;
    }

    @Test
    public void test() {

//        assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
//        assertEquals(1, minSubArrayLen(4, new int[]{1,4,4}));
//        assertEquals(0, minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        assertEquals(3, minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }


}
