import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations); //citations를 오름차순 정렬
        int idx = 0; //편수 인덱스

        for (int i = citations.length; i > 0; i--) {
            if (citations[idx] >= i) { //인용수가 편수 이상일시
                return i; //기준 편수가 h-index
            }
            idx++;
        }

        return 0;
    }

    @Test
    public void test() {

        assertEquals(3, hIndex(new int[]{3,0,6,1,5}));
    }


}
