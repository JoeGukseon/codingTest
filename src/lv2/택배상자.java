package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
문제가 너무 이해가 안가서 블로그 참조함
https://sillon-coding.tistory.com/475
 */
public class 택배상자 {
    public int solution(int[] order) {
        //보조 컨베이너
        Stack<Integer> aux = new Stack<>();
        //보조 컨베이너에 넣을 택배 상자번호
        int idx = 1;
        //트럭에 넣을수 있는 상자수
        int cnt = 0;
        //while 조건 자체가 보조에 넣을 상자번호 1,2,3,4,5,6...
        while (idx < order.length+1) {
            aux.push(idx); //상자를 차례대로 보조에 넣고
            //트럭에 넣는 순서가 맞는지 확인 4번째는 1,2,3,4가 들어가고 나서 트럭에 들어가짐 그동안 1,2,3이 넣어짐
            while (!aux.isEmpty() && aux.peek() == order[cnt]) {
                //트럭에 넣는 순서 업데이트
                cnt++;
                //보조의 맨앞 상자 빼기
                aux.pop();
            }
            //상자 업데이트
            idx++;
        }

        return cnt;
    }


    @Test
    public void test() {

        assertEquals(2, solution(new int[]{4, 3, 1, 2, 5}));
        assertEquals(5, solution(new int[]{5, 4, 3, 2, 1}));
        assertEquals(10, solution(new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9}));
    }


}
