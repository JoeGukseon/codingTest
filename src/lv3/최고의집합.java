package lv3;

import java.util.Arrays;

public class 최고의집합 {
    public static void main(String[] args) {
            int[] answer = solution(2,9);
            System.out.println(Arrays.toString(answer));
        }

    public static int[] solution(int n, int s) {

        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = s / n;
            s -= answer[i];
            n--;
        }

        return answer;
    }
}
