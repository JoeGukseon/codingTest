package lv2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 소수찾기 {
    //조합수를 다 담을 set을 생성
    Set<Integer> hashSet = new HashSet<>();
    //dfs를 위한 배열
    boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        //depth는 찾을 숫자의 자릿수 1~ length+1 까지
        for (int i = 0; i < numbers.length(); i++) {
            dfs(i + 1, "", numbers);
        }
        for (Integer integer : hashSet) {
            if (isPrime(integer)) {
                answer++;
            }
        }
        return answer;
    }
    private void dfs(int depth,String num,String numbers) {
        //찾을 숫자의 자릿수 depth가 되면 1~ set에 추가
        if (num.length() == depth) {
            hashSet.add(Integer.parseInt(num));
            return;
        }
        //기본에 자릿수가 될때 까지 문자 하나씩을 더하며 탐색
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth, num + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {

        assertEquals(3, solution("17"));
        hashSet.clear();
        assertEquals(2, solution("011"));
    }


}
