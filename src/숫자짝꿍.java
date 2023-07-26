import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 숫자짝꿍 {

    public String solution(String X, String Y) {
        //리스트 처리 후 시간 초과로 Hash로 처리
//        List<Integer> set1 = new ArrayList<>();
//        for (char ch : X.toCharArray()) {
//            set1.add(Character.getNumericValue(ch));
//        }
//
//        List<Integer> set2 = new ArrayList<>();
//        for (char ch : Y.toCharArray()) {
//            set2.add(Character.getNumericValue(ch));
//        }
//
//        List<Integer> result = new ArrayList<>();
//        for (Integer integer : set1) {
//            if (set2.contains(integer)) {
//                result.add(integer);
//                set2.remove(integer);
//            }
//        }
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        for (String key : X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0) + 1);
        }

        for (String key : Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0) + 1);
        }

        List<String> list = new ArrayList<>();

        for (String key : xMap.keySet()) {
            if (!yMap.containsKey(key)) continue;

            int length = Math.min(xMap.get(key), yMap.get(key));
            for (int i = 0; i < length; i++) {
                list.add(key);
            }
        }

        String result = list.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
        if (result.isEmpty()) {
            return "-1";
        } else if (result.replaceAll("0", "").isEmpty()) {
            return "0";
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals("-1", solution("100", "2345"));
        assertEquals("0", solution("100", "203045"));
        assertEquals("10", solution("100", "123450"));
        assertEquals("321", solution("12321", "42531"));
        assertEquals("552", solution("5525", "1255"));
    }


}
