import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 배열뒤집기 {

    public int[] solution(long n) {
        List<Integer> reversedList = new ArrayList<>();

        while (n > 0) {
            int digit = (int) (n % 10);
            reversedList.add(digit);
            n /= 10;
        }

        return reversedList.stream().mapToInt(Integer::intValue).toArray();
    }
    @Test
    public void test() {

        assertArrayEquals(new int[]{5,4,3,2,1}, solution(12345));
    }


}
