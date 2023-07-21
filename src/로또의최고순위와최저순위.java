import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 로또의최고순위와최저순위 {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        //검색 효율을 위해 HashSet설정
        Set<Integer> winNumbers = new HashSet<>();
        //0카운트
        int zeroCnt = 0;
        //맞은 수 카운트
        int cnt = 0;
        //당첨숫자 넣고
        for (int winNum : win_nums) {
            winNumbers.add(winNum);
        }
        //적은 숫자 0제외 hashset에서 확인
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
            } else if (winNumbers.contains(lotto)) {
                cnt++;
            }
        }

        //등수는 7 - (카운트이고) 6,7은 6으로
        answer[0] = 7 - (cnt + zeroCnt) == 7 ? 6:7 - (cnt + zeroCnt);
        answer[1] = 7 - (cnt) == 7 ? 6:7 - (cnt);

        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{3, 5}, solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));
    }


}
