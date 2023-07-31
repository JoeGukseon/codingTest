import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 폰켓몬 {

    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(set.size(), nums.length / 2);
    }
    @Test
    public void test() {
        assertEquals(2, solution(new int[]{3,1,2,3}));
        assertEquals(3, solution(new int[]{3,3,3,2,2,4}));
        assertEquals(2, solution(new int[]{3,3,3,2,2,2}));
    }


}
