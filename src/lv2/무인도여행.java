package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
bfs로 풀이
'X'가 아닌 부분을 상하좌우 탐색 후에 값을 더해준다
방문맵을 만들어 방문 안한곳만 탐색으로 경로 정해줌
 */
public class 무인도여행 {
    public int[] solution(String[] maps) {
        //상하좌우 탐색
        int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        //방문 체크
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();

        //맵 만들기
        char[][] map = Arrays.stream(maps).map(String::toCharArray).toArray(char[][]::new);

        for (int y = 0; y < maps.length; y++) { //세로
            for (int x = 0; x < maps[y].length(); x++) { //가로
                if (!visited[y][x] && maps[y].charAt(x) != 'X') { //방문하지 않은곳 이고 숫자일때만 탐색시작
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{x, y});
                    visited[y][x] = true; // 큐에 넣고 방문 기록
                    int sum = 0;
                    while (!queue.isEmpty()) { //한 경로를 탐색
                        int[] pos = queue.poll();
                        int curX = pos[0];
                        int curY = pos[1];

                        sum += map[curY][curX] - '0'; //값을 빼서 더해주고
                        for (int k = 0; k < dir.length; k++) { // 경로탐색
                            int nx = curX + dir[k][0];
                            int ny = curY + dir[k][1];

                            if (ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length && !visited[ny][nx] && map[ny][nx] != 'X') {
                                queue.add(new int[]{nx, ny});
                                visited[ny][nx] = true;
                            }
                        }
                    }
                    answer.add(sum); //경로가 끝날때 리스트에 더해준다.
                }
            }
        }
        if (answer.isEmpty()) { //경로가 없을시 에느 -1 반환
            return new int[]{-1};
        }
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }


    @Test
    public void test() {

        assertArrayEquals(new int[]{1, 1, 27}, solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}));
    }


}
