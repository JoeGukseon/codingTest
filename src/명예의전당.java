import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 명예의전당 {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> scoreList = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);    //리스트에 추가 하고
            scoreList.sort(Comparator.reverseOrder()); //내림차순으로 정렬
            if (scoreList.size() > k) {
                scoreList = scoreList.subList(0, k); //큰경우 자르기
            }
            answer[i] = scoreList.get(scoreList.size() - 1); //마지막수가 k크기의 리스트에서 가장 낮은 점수이니 그점수 리스트에 더해줌
        }

        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{10, 10, 10, 20, 20, 100, 100}, solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}));
        assertArrayEquals(new int[]{0, 0, 0, 0, 20, 40, 70, 70, 150, 300}, solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}));
    }


}
