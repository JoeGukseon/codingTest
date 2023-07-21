import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 내적 {

    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .sum();
    }
    @Test
    public void test() {

        assertEquals(3, solution(new int[]{1,2,3,4},new int[]{-3,-1,0,2}));
    }


}
