import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 모의고사 {

    public int[] solution(int[] answers) {
        int[][] math_dropout = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] idx = new int[3];
        int[] answerCnt = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < math_dropout.length; j++) {
                idx[j] = math_dropout[j].length <= i ? i % math_dropout[j].length : i;
                if (answers[i] == math_dropout[j][idx[j]]) {
                    answerCnt[j]++;
                }
            }
        }
        //가장 많이 맞힌 갯수
        int maxNumber = Arrays.stream(answerCnt).max().getAsInt();

        //학생을 찾아서
        return IntStream.range(0, answerCnt.length).filter(i -> answerCnt[i] == maxNumber).map(i -> i + 1).toArray();
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{1}, solution(new int[]{1,2,3,4,5,1,2,3}));
        assertArrayEquals(new int[]{1,2,3}, solution(new int[]{1,3,2,4,2}));

    }


}
