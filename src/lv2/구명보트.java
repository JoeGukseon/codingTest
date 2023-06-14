package lv2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int first = 0;
        int last = people.length - 1;

        while (first <= last) {
            if (people[first] + people[last] <= limit) {
                first++;
                last--;
            } else {
                last--;
            }
            answer++;
        }
        return answer;
    }

    @Test
    public void test() {

        assertEquals(3, solution(new int[]{70, 50, 80, 50},100));
    }


}
