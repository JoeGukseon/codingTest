import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int cnt = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                cnt = 1;
                nums[i] = nums[j];

            } else if (nums[i] == nums[j] && cnt == 1) {
                cnt++;
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    @Test
    public void test() {
        int[] nums = {1,1,1,2,2,3}; // Input array
        int[] expectedNums = {1,1,2,2,3}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    @Test
    public void test2() {
        int[] nums = {0,0,1,1,1,1,2,3,3}; // Input array
        int[] expectedNums = {0,0,1,1,2,3,3}; // The expected answer with correct length

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }


}
