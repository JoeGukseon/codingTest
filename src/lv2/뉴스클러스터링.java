package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {

        List<String> str1List = IntStream.range(0, str1.length())
                .filter(i -> i + 1 < str1.length())
                .mapToObj(i -> str1.substring(i, i + 2).toLowerCase())
                .filter(s -> s.matches("[a-zA-Z]+"))
                .collect(Collectors.toList());
        List<String> str2List = IntStream.range(0,str2.length())
                .filter(i -> i + 1 < str2.length())
                .mapToObj(i->str2.substring(i,i+2).toLowerCase())
                .filter(s -> s.matches("[a-zA-Z]+"))
                .collect(Collectors.toList());

        System.out.println("str2List = " + str2List);
        System.out.println("str1List = " + str1List);

//        Map<String, Integer> str1Count = new HashMap<>();
//        for (String element : str1List) {
//            str1Count.put(element, str1Count.getOrDefault(element, 0) + 1);
//        }
//
//        Map<String, Integer> str2Count = new HashMap<>();
//        for (String element : str2List) {
//            str2Count.put(element, str2Count.getOrDefault(element, 0) + 1);
//        }
        Map<String, Integer> str1Count = str1List.stream()
                .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));

        Map<String, Integer> str2Count = str2List.stream()
                .collect(Collectors.toMap(Function.identity(), s -> 1, Integer::sum));

        Map<String, Integer> strMerge = new HashMap<>(str1Count);
        for (String s : str2Count.keySet()) {
            Integer s2 = str2Count.get(s);
            Integer s1 = strMerge.getOrDefault(s, 0);
            Integer cnt = Math.max(s1, s2);
            strMerge.put(s, cnt);
        }

        List<String> union = new ArrayList<>();
        for (String s : strMerge.keySet()) {
            Integer cnt = strMerge.get(s);
            for (int i = 0; i < cnt; i++) {
                union.add(s);
            }
        }

        System.out.println(union);

        Set<String> unique = new HashSet<>(str1List);
        unique.retainAll(str2List);

        List<String> intersection = new ArrayList<>();
        for (String s : unique) {
            int cnt = Math.min(str1Count.getOrDefault(s, 0), str2Count.getOrDefault(s, 0));
            for (int i = 0; i < cnt; i++) {
                intersection.add(s);
            }
        }

        System.out.println(intersection);

        if (intersection.size() == union.size()) {
            return 65536;
        }
        double v = (double) intersection.size() / union.size();
        System.out.println("intersection = " + intersection.size());
        System.out.println("union = " + union.size());
        double roundedRatio = Math.round(v * 100.0) / 100.0;
        System.out.println("roundedRatio = " + roundedRatio);

        return (int)(((double) intersection.size() / union.size()) * 65536);
    }

    @Test
    public void test() {

//        assertEquals(16384, solution("FRANCE","french"));
//        assertEquals(65536, solution("handshake","shake hands"));
        assertEquals(43690, solution("aa1+aa2","AAAA12"));
//        assertEquals(65536, solution("E=M*C^2","e=m*c^2"));
    }


}
