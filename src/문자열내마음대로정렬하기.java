import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {
        List<String> stringList = Arrays.asList(strings);

        stringList.sort(Comparator.comparing((String o) -> o.charAt(n)).thenComparing(Comparator.naturalOrder()));

        return stringList.toArray(new String[0]);
    }

    @Test
    public void test() {

        assertArrayEquals(new String[]{"car", "bed", "sun"}, solution(new String[]{"sun", "bed", "car"},1));
        assertArrayEquals(new String[]{"abcd", "abce", "cdx"}, solution(new String[]{"abce", "abcd", "cdx"},2));
    }


}
