import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
/*
HASH로 풀이
스테이지 별 실패율을 담는 맵을 만들고
이상이면 스테이지 도달
같으면 스테이지 실패
계산하여 1차 값 오름차순 / 2차 같은값 내림차순 정렬하여
key값만 출력
-- 기본 계산에서 value를 Integer -> Double로 변경
-- 스테이지 도달이 없는 경우 0.0으로 초기화
 */
public class 실패율 {

    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> stageFailures = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int stageCnt = 0;
            int failCnt = 0;
            for (int stage : stages) {
                if (stage >= i) {
                    stageCnt++;
                    if (stage == i) {
                        failCnt++;
                    }
                }
            }
            if (stageCnt == 0) {
                stageFailures.put(i, 0.0);
            } else {
                stageFailures.put(i, (((double) failCnt / stageCnt) * 100));
            }
        }

        return stageFailures.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Test
    public void test() {
//        assertArrayEquals(new int[]{3, 4, 2, 1, 5}, solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        assertArrayEquals(new int[]{1, 2}, solution(2, new int[]{1, 1, 1, 1}));
    }


}
