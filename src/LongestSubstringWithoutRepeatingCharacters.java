import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 1;

        int len = Integer.MIN_VALUE;
        StringBuilder sub = new StringBuilder();
        sub.append(s.charAt(0));
        while (right < s.length()) {
            char rChar = s.charAt(right);
            while (sub.indexOf(String.valueOf(rChar)) != -1) {
                sub.deleteCharAt(0);
                left++;
            }
            sub.append(rChar);
            int cnt = right - left + 1;
            len = Math.max(cnt, len);
            right++;
        }

        return len;
    }

    @Test
    public void test() {

//        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
//        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }


}
