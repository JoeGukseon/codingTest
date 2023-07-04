import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
단순 스트림으로 계산 idx값을 만들어 값을 뽑고 정렬후에 그수의 인덱스 값을 배열로 모아 리턴
 */
public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int sIdx = commands[i][0]-1;
            int eIdx = commands[i][1]-1;
            int selIdx = commands[i][2]-1;
            answer[i] = Arrays.stream(array, sIdx, eIdx+1)
                    .boxed()
                    .sorted()
                    .toArray(Integer[]::new)[selIdx];
        }
        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{5, 6, 3}, solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
    }


}
