import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[idx] = nums[i];
                idx++;
            }
        }

        nums = Arrays.copyOfRange(nums,0,idx);
        return idx;
    }

    @Test
    public void test() {
        int[] nums = {0,1,2,2,3,0,4,2}; // Input array
        int val = 2; // Value to remove
        int[] expectedNums = {0,0,1,3,4}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElement(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
