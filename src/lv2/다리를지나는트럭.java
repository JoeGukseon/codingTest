package lv2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // Queue로 다리 생성
        Queue<Integer> bridge = new LinkedList<>();

        // 다리에 다리길이 만큼 더미 0 생성
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        // 다리의 무게 변수
        int bridge_cur_weight = 0;
        // 트럭의 인덱스
        int idx = 0;

        // 다리에 트럭이 없을때까지
        while (!bridge.isEmpty()) {
            answer++; //시간증가
            bridge_cur_weight -= bridge.poll(); //현재다리 맨앞의 더미&트럭빼기

            if (idx < truck_weights.length) { //idx가 트럭을 다 순회할때까지만 더미&트럭 넣어주기
                if (bridge_cur_weight + truck_weights[idx] <= weight) { //현재 다리의 무게 + 들어올 트럭이 weight보다 가벼울때만
                    bridge.offer(truck_weights[idx]); //트럭을 넣어줌
                    bridge_cur_weight += truck_weights[idx]; //트럭을 넣고 무게에 +
                    idx++; //다음트럭 idx
                } else {
                    bridge.offer(0); //무게가 넘고 아직 트럭이 남았을 경우엔 더미 0
                }
            }
        }

        return answer;
    }


    @Test
    public void test() {

        assertEquals(8, solution(2,10,new int[]{7,4,5,6}));
    }


}
