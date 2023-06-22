package lv3;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
DFS 문제
여행경로를 모든 경우의 수로 찾아야한다.
스타트는 "ICN" , return 의 정렬은 알파벳순

String은 따로 지워주지 않아도 해당 문자열로 찾기에 지워줄 필요가 없어 적합하다.
처음에 List<String>으로 구현하였다 초기화에서 막힘.
 */
public class 여행경로 {
    public String[] solution(String[][] tickets) {
        //알파벳순으로 정렬하기 위해 우선순위 큐를 만든다.
        Queue<String> route = new PriorityQueue<>();
        //DFS 구현을 위해 방문배열 선언 (모두 false로 초기화)
        boolean[] visited = new boolean[tickets.length];
        //스타트값 초기화
        String start = "ICN";
        //DFS 탐색 시작
        dfs(tickets, visited, 0, start, start, route);

        //경로를 ","으로 나누어 리턴
        return route.poll().split(",");
    }

    private void dfs(String[][] tickets, boolean[] visited, int depth, String ticketName, String path, Queue<String> route) {
        //재귀의 탈출조건 깊이가 tickets의 크기와 같아지면 탈출 depth 0~ 이고 length 는 수가 1부터임으로 배열이 완성된뒤에 호출
        if (depth == tickets.length) {
            //우선순위큐에 추가
            route.add(path);
            System.out.println("path = " + path);
            return ;
        }

        //티켓의 수대로 반복문
        for (int i = 0; i < tickets.length; i++) {
            //사용하지 않은 티켓 확인
            if (!visited[i]) {
                //해당 티켓이 있으면
                if (Objects.equals(tickets[i][0], ticketName)) {
                    //티켓사용남기고 하고 다음 티켓찾아 DFS 호출, 경로에 ",다음경로" 추가
                    visited[i] = true;
                    dfs(tickets, visited, depth + 1, tickets[i][1], path + "," + tickets[i][1], route);
                    //남은경로가 있는 경우 다음 루프에서 찾아주기 위해 사용이력 초기화
                    visited[i] = false;
                }
            }
        }
    }

    @Test
    public void test() {

        assertArrayEquals(new String[]{"ICN", "JFK", "HND", "IAD"}, solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        assertArrayEquals(new String[]{"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"}, solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
    }


}
