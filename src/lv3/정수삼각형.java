package lv3;

import java.util.Arrays;

public class 정수삼각형 {
    public static void main(String[] args) {
        int answer = solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
            System.out.println(answer);
        }
    
        public static int solution(int[][] triangle) {
            int answer = 0;
            int size = triangle.length;
            int[][] dp = new int[size][size];

            dp[0][0] = triangle[0][0];

            for (int i = 1; i < size; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if(j==0){ dp[i][0] = dp[i - 1][0] + triangle[i][j];}
                    else if (j == i) {
                        dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                    }

                    if (i == size - 1) {
                        answer = Math.max(dp[i][j], answer);
                    }
                }
            }

            return answer;
        }
}

/*좋은풀이*/
//
//    public int solution(int[][] triangle) {
//        for (int i = 1; i < triangle.length; i++) {
//            triangle[i][0] += triangle[i-1][0];
//            triangle[i][i] += triangle[i-1][i-1];
//            for (int j = 1; j < i; j++)
//                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
//        }
//
//        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
//    }