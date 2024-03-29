import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");
        int right = s.length()-1;
        for (int i = 0; i < s.length(); i++) {
//            char ch1 = Character.toLowerCase(s.charAt(i));
//            char ch2 = Character.toLowerCase(s.charAt(right));
//            if (ch1 != ch2) {
//                return false;
//            }
            if (s.charAt(i) != s.charAt(right)) {
                return false;
            }
            right--;
        }
        return true;
    }

    @Test
    public void test() {

        assertEquals(true, isPalindrome("A man, a plan, a canal: Panama"));
    }


}
