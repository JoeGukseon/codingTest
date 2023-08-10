import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        return sortedList.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{2,3,4,5,6,7}, solution(new int[]{2,1,3,4,1}));
    }


}
