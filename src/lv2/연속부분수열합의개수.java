package lv2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 연속부분수열합의개수 {

    public int solution(int[] elements) {
        //수열을 담을 SET 생성
        Set<Integer> set = new HashSet<>();

        //수의 갯수 1 ~ 4 (5는 무조건 1개에 다른수일테니 4번만 돌린다)
        for (int i = 1; i < elements.length; i++) {
            //요소 0~4
            for (int k = 0; k < elements.length; k++) {
                //값
                int value = 0;
                //더하는 숫자 갯수 (k ~ k+i 까지) ( 0 ~ 0 / 0 ~ 1 /...)
                for (int j = k; j < k + i; j++) {
                    //수를 찾을 인덱스
                    int idx = j;
                    //수가 크기를 넘어설경우 크기만큼 - (다른사람풀이를 보니 이부분을 그냥 elements[j%elements.length]로 처리하는것이 좋아보인다.
                    if (j > elements.length - 1){
                        idx -= elements.length;
                    }
                    //값에 더하기
                    value += elements[idx];
                }
                //set에 추가
                set.add(value);
            }
        }

        //set size를 반환 set에 있는 숫자는 마지막을 제외 했기때문에 마지막 연속수열의 갯수인 1을 더해준다.
        return set.size() + 1;
    }

    @Test
    public void test() {

        assertEquals(18, solution(new int[]{7, 9, 1, 1, 4}));
    }


}
