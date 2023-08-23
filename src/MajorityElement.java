import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            int val = hashMap.getOrDefault(num, 0) + 1;
            if (val > nums.length / 2) {
                return num;
            }
            hashMap.put(num, val);
        }
        return 0;
    }

    //다른 해답
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        return nums[n/2];
//    }
    @Test
    public void test() {

        assertEquals(3, majorityElement(new int[]{3,2,3}));
        assertEquals(2, majorityElement(new int[]{2,2,1,1,1,2,2}));
    }


}
