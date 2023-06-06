package lv3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 네트워크 {
    public static void main(String[] args) {
        int answer = solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
            System.out.println(answer);
        }

//    public static int solution(int n,int[][] computers) {
//        int answer = 0;
//        boolean[] visited = new boolean[n];
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                dfs(n, computers, visited, i);
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//
//    static void dfs(int n, int[][] computers, boolean[] visited, int i) {
//        System.out.println("컴퓨터수 = " + n + ", computers = " + Arrays.deepToString(computers) + ", visited = " + Arrays.toString(visited) + ", 인덱스 = " + i);
//        visited[i] = true;
//        for(int j=0;j<n;j++){
//            System.out.println("인덱스2 = " + j);
//            if(computers[i][j]==1 && !visited[j] && j!=i){
//                dfs(n,computers,visited,j);
//
//            }
//        }
//    }

    public static int solution(int n,int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(n, computers, visited, queue, i);
                answer++;
            }
        }

        return answer;
    }
    static void bfs(int n, int[][] computers, boolean[] visited, Queue<Integer> queue, int i) {
        System.out.println("컴퓨터수 = " + n + ", computers = " + Arrays.deepToString(computers) + ", visited = " + Arrays.toString(visited) + ", 인덱스 = " + i);
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int value = queue.poll();

            for(int j=0;j<n;j++){
                System.out.println("인덱스2 = " + j);
                if(computers[value][j]==1 && !visited[j] && j!=i){
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }

    }
}
