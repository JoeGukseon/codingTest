import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int goal = nums.length;
        int max = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if ((i + 1) + nums[i] >= goal) {
                return true;
            } else if (i > max && nums[i] == 0) {
                return false;
            }
            max = Math.max(max,nums[i] + i - 1);//갈수 있는 최대 범위
        }
        return false;
    }

    @Test
    public void test() {

//        assertTrue(canJump(new int[]{2, 3, 1, 1, 4}));
//        assertFalse(canJump(new int[]{3, 2, 1, 0, 4}));
//        assertFalse(canJump(new int[]{0, 2, 3}));
//        assertTrue(canJump(new int[]{3, 0, 8, 2, 0, 0, 1}));
//        assertFalse(canJump(new int[]{1, 0, 1, 0}));
        assertTrue(canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}));
    }


}
