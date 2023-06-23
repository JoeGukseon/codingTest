package lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 압축 {

    public int[] solution(String msg) {
        //색인 번호를 찾기위한 색인리스트 생성
        List<String> index = new ArrayList<>();

        //번호 맵핑을 위해 0번에 "0" 삽입
        index.add("0");
        // List 초기화 초기값 A-Z
        // 두번째가 더 직관적이고 좋은거 같음
//        for (int i = 65; i < 91; i++) {
//                index.add(String.valueOf((char)i));
//        }
        for (char i = 'A'; i <= 'Z'; i++) {
            index.add(String.valueOf(i));
        }

        //주어진 문자열을 하나씩 확인할수있게 큐를 생성
        Queue<Character> queue = new LinkedList<>();
        //큐 초기화 (msg를 char로 넣기)
        for (char c : msg.toCharArray()) {
            queue.offer(c);
        }

        //문자열넣을 sb와 색인번호를 넣을 int list 생성
        StringBuilder str = new StringBuilder();
        List<Integer> answer = new ArrayList<>();

        //큐의 첫번째 문자와 처리가 가능한문자를 합쳐 하나씩문자열을 늘려가며 확인
        //문자열이 있으면 큐에서 문자를 뺴어 처리가능문자열에 저장
        //문자열이 없으면 처리가능문자열의 색인번호를 answer에 저장
        while (!queue.isEmpty()) {
            //임시 문자열에 처리가능 문자열 + 큐에 남은 문자첫번째
            String temp = str.toString() + queue.peek();
            //문자열이 있으면
            if (index.contains(temp)) {
                //큐에서 문자를 빼어 처리가능 문자열에 저장
                str.append(queue.poll());
                //마지막 큐에서 뺀 문자는 처리가 가능하므로 리스트에 저장
                if (queue.isEmpty()) {
                    answer.add(index.indexOf(str.toString()));
                }
            }
            //문자열이 없으면
            else {
                //색인 목록에 임시 문자열을 넣어주고 (새로등록)
                index.add(temp);
                //처리가능문자열을 색인번호로 answer에 저장
                answer.add(index.indexOf(str.toString()));
                //처리가능문자열 초기화
                str.setLength(0);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{11, 1, 27, 15}, solution("KAKAO"));
        assertArrayEquals(new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}, solution("TOBEORNOTTOBEORTOBEORNOT"));
        assertArrayEquals(new int[]{1, 2, 27, 29, 28, 31, 30}, solution("ABABABABABABABAB"));

    }


}
