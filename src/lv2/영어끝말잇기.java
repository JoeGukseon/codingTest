package lv2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        int turn = 0;
        int count = 0;

        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String previousWord = words[i - 1];
            String currentWord = words[i];

            if (usedWords.contains(currentWord) || previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)) {
                turn = ((i + 1) % n) == 0 ? n : (i + 1) % n;
                count = (int) Math.ceil((i + 1.0) / n);
                break;
            }

            usedWords.add(currentWord);
        }

        return new int[]{turn, count};
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{3, 3}, solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        assertArrayEquals(new int[]{0, 0}, solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
        assertArrayEquals(new int[]{1, 3}, solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));
    }


}
