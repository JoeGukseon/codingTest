package lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 튜플 {

    public int[] solution(String s) {

        List<String> list = new ArrayList<>();
        String[] subStrings = s.split("},\\{");
        for (String subString : subStrings) {
            String trimmedString = subString.replaceAll("[{}]", ""); // 2, 2,1 , 2,1,3 , 2,1,3,4
            list.add(trimmedString);
        }
        list.sort(Comparator.comparingInt(String::length));

        List<Integer> intList = new ArrayList<>();
        for (String subString : list) {
            String[] num = subString.split(",");
            for (String numStr : num) {
                    Integer value = Integer.parseInt(numStr);
                    if (!intList.contains(value)) {
                        intList.add(value);
                    }
            }
        }

        System.out.println(intList);

        return intList.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{2, 1, 3, 4}, solution("{{2,1},{2},{2,1,3},{2,1,3,4}}"));
        assertArrayEquals(new int[]{2, 1, 3, 4}, solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
        assertArrayEquals(new int[]{111, 20}, solution("{{20,111},{111}}"));
        assertArrayEquals(new int[]{123}, solution("{{123}}"));
        assertArrayEquals(new int[]{3, 2, 4, 1}, solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"));
    }


}
