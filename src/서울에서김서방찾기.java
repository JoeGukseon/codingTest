import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 서울에서김서방찾기 {

    public String solution(String[] seoul) {

//        return String.format("김서방은 %d에 있다", Arrays.asList(seoul).indexOf("Kim")); //List를 만들기에 효율이 안좋음
        int idx = IntStream.range(0, seoul.length).filter(i -> seoul[i].equals("Kim")).findFirst().orElse(-1);
        return String.format("김서방은 %d에 있다", idx);
    }

    @Test
    public void test() {

        assertEquals("김서방은 1에 있다", solution(new String[]{"Jane", "Kim"}));
    }


}
