package lv2;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
분할
https://devdange.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BF%BC%EB%93%9C%EC%95%95%EC%B6%95-%ED%9B%84-%EA%B0%9C%EC%88%98-%EC%84%B8%EA%B8%B0-for-JAVA-%EB%B6%84%ED%95%A0%EC%A0%95%EB%B3%B5
참조
 */
public class 쿼드압축후개수세기 {

    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        int totalSize = arr.length;
        dq(0, 0, totalSize, arr);

        return answer;
    }

    // 전체값 부터 2로 나눈값 .... 넣어서 사이즈칸이 다 같은 값이면 1만 올리고 return
    // 아니면 계속 쪼개서 넣고 1이면 +1씩 증가
    private void dq(int x, int y, int size, int[][] arr) {
        boolean isAllSame = IntStream.range(x, x + size)
                .flatMap(i -> java.util.Arrays.stream(arr[i], y, y + size))
                .distinct()
                .count() == 1;
        if (isAllSame) {
            answer[arr[x][y]]++;
            return;
        }

        dq(x, y, size / 2, arr);
        dq(x + size / 2, y, size / 2, arr);
        dq(x, y + size / 2, size / 2, arr);
        dq(x + size / 2, y + size / 2, size / 2, arr);
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{4, 9}, solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}}));
    }


}
