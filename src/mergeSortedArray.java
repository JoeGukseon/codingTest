import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class mergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (n == 0) {
//            return;
//        }
//
////        for (int i = 0; i < n; i++) {
////            nums1[m+i] = nums2[i];
////        }
//        if (n >= 0) System.arraycopy(nums2, 0, nums1, m + 0, n);
//
//        Arrays.sort(nums1);
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }


    @Test
    public void test() {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }


}
