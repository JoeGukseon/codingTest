import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class x만큼간격이있는n개의숫자 {

    public long[] solution(int x, int n) {
        return LongStream.rangeClosed(1, n)
                .mapToObj(i -> (long) x * i)
                .mapToLong(Long::longValue)
                .toArray();
    }

    @Test
    public void test() {

        assertEquals(new long[]{2,4,6,8,10}, solution(2,5));
    }


}
