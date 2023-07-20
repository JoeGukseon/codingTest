import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1차 푼건 효율성 x O(n)의 시간 복잡도 (constains이 리스트를 다 써치하기때문에)
O(1)으로 변경 (맵에 키워드 카운트를 넣고 카운트로 찾는 방식 1회)
 */
public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        List<String> completionList = new ArrayList<>(Arrays.asList(completion));
//        List<String> participantList = new ArrayList<>(Arrays.asList(participant));
//        for (String s : participantList) {
//            if (completionList.contains(s)) {
//                completionList.remove(s);
//            } else {
//                answer = s;
//                break;
//            }
//        }
//        return answer;
        Map<String, Integer> map = new HashMap<>();

        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {
            int count = map.getOrDefault(s, 0);
            if (count == 0) {
                return s;
            }
            map.put(s, count - 1);
        }
        return null;
    }

    @Test
    public void test() {

        assertEquals("leo", solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"}));
        assertEquals("vinko", solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},new String[]{"josipa", "filipa", "marina", "nikola"}));
        assertEquals("mislav", solution(new String[]{"mislav", "stanko", "mislav", "ana"},new String[]{"stanko", "ana", "mislav"}));
    }


}
