import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateArray {

//    public void rotate(int[] nums, int k) {
//        int[] temp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            temp[(i + k) % nums.length] = nums[i];
//        }
//        System.arraycopy(temp,0,nums,0,nums.length);
//        System.out.println(Arrays.toString(nums));
//    }

    public static void reverse(int nums[], int start, int end){
        // While start index is less than end index
        while(start < end){
            // Swap elements at start and end indices
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            // Increment start index and decrement end index
            start++;
            end--;
        }
    }

    public void rotate(int[] nums, int k) {
        // Ensure k is within array bounds
        k %= nums.length;
        // Reverse entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }
    @Test
    public void test() {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{-1,-100,3,99}, 2);
    }


}
