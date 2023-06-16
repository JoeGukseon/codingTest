package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HIndex {

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n-left;
    }

    @Test
    public void test() {

        assertEquals(3, solution(new int[]{3, 0, 6, 1, 5}));
    }


}
