import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length-1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target) {
//                    return new int[]{i+1, j+1};
//                }
//            }
//        }
//        return null;
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left]+numbers[right]==target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return null;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{1,2}, twoSum(new int[]{2,7,11,15},9));
    }


}
