package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
bfs 로 풀이 너비 탐색

큐에 기본으로 값,카운트를 넣고
빼서 같으면 카운트값을 리턴
작으면 큐에 3가지 조건을 추가
 */
public class 숫자변환하기 {

    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> chkVal = new HashSet<>();
        queue.offer(new int[]{x, 0});
        chkVal.add(x);

        while (!queue.isEmpty()) {
            int[] values = queue.poll();
            int curVal = values[0];
            int steps = values[1];
            System.out.println("curVal = " + curVal);
            if (curVal == y) {
                answer = steps;
                break;
            } else if (curVal < y){
                int[] nextValues = {curVal + n, curVal * 2, curVal * 3};
                for (int nextValue : nextValues) {
                    if (nextValue <= y && !chkVal.contains(nextValue)) {
                        queue.offer(new int[]{nextValue, steps + 1});
                        chkVal.add(nextValue);
                    }
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(2, solution(10,40,5));
        assertEquals(1, solution(10,40,30));
        assertEquals(-1, solution(2,5,4));
    }


}
