package lv3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 단어변환 {
    static int answer=0;
    public static void main(String[] args) {
        int answer = solution("hit","cog",new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
            System.out.println(answer);
        }
        public static int solution(String begin, String target, String[] words) {
            if(words.length == 51) return 0;
            boolean[] visited = new boolean[words.length];
            dfs(begin, target, words, 0, visited);
            return answer;
        }

    static void dfs(String now, String target, String[] words, int n, boolean[] visited) {
        System.out.println("now = " + now + ", target = " + target + ", words = " + Arrays.toString(words) + ", n = " + n + ", visited = " + Arrays.toString(visited));
        //현재값이 같은지 확인 같으면 현재값을 리턴
        if (now.equals(target)){ answer = n;}

        //deps가 word size보다 크면 리턴
        if (n > words.length) return;

        //알파벳 하나만 변환 //맨처음부터 변환 //같지 않은 알파벳만 변경 //target 탐색도 해야함
        IntStream.range(0, words.length)
                .filter(i -> !visited[i])
                .forEach(i -> {
                    int check = 0;
                    for (int j = 0; j < now.length(); j++) {
                        if (now.charAt(j) != words[i].charAt(j)) {
                            check++;
                        }
                    }
                    if (check == 1) {
                        visited[i] = true;
                        dfs(words[i], target, words, n + 1, visited);
                        visited[i] = false;
                    }
                });
    }
}
