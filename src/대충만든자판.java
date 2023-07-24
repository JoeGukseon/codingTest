import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 대충만든자판 {

    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> key = new HashMap<>();
        //hash로 만들기
        for (String s : keymap) {
            for (int i = 0; i < s.length(); i++) {
                if (!key.containsKey(s.charAt(i)) || i + 1 < key.get(s.charAt(i))) {
                    key.put(s.charAt(i), i + 1);
                }
            }
        }
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {
            for (char c : targets[i].toCharArray()) {
                if (key.containsKey(c)) {
                    answer[i] += key.get(c);
                } else {
                    answer[i] = -1; //target의 키가 hash에 없을 경우 바로 -1넣고 종료 후 다른 target검색
                    break;
                }
            }
        }
        return answer;
    }

    @Test
    public void test() {

//        assertArrayEquals(new int[]{9, 4}, solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"}));
//        assertArrayEquals(new int[]{-1}, solution(new String[]{"AA"}, new String[]{"B"}));
//        assertArrayEquals(new int[]{4, 6}, solution(new String[]{"AGZ", "BSSS"}, new String[]{"ASA", "BGZ"}));
        assertArrayEquals(new int[]{-1,-1}, solution(new String[]{"ABCDE"}, new String[]{"FGHIJ","AAF"}));
    }


}
