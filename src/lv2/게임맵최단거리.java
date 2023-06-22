package lv2;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

//BFS 사용
//최단경로를 찾을 때 너비우선검색을 하여 찾는다.
//DFS보다 경우의 수를 더 계산하지 않아 빠르다.
//큐에 값을 넣고 빼면서 상 하 좌 우 검색
//갈수있는 경우를 이동을 탐색하다 End 지점에서 멈추고 이동한 거리를 계산 , 없을 시 -1 반환
public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        //큐 생성
        Queue<int[]> queue = new LinkedList<>();

        //이동할 좌표 순서 -> 상 하 좌 우
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        //현재 좌표 x,y / 초기좌표 0,0
        int x = 0;
        int y = 0;

        //초기좌표 0,0 큐에 넣기
        queue.offer(new int[]{x, y});

        // 큐가 비워질때 까지 // 가장 빨리 도착한 곳의 1이 업데이트 되기때문에 나머지는 그냥 연산만 들어간다 (좀 더 효율적이게 가능할듯?) - end값에 도착하면 루프 종료 업데이트 -> 업데이트 후 테스트 속도가 빨라짐.
        qLoop:
        while(!queue.isEmpty()){
            //큐의 첫번째값 꺼내기(계산할 위치)
            int[] now = queue.poll();
            //위치 좌표 넣기(현재)
            x = now[0];
            y = now[1];

            //이동 좌표 탐색하기
            for(int i = 0 ; i < 4; i++){
                //이동 좌표 넣기 상 하 좌 우
                int nx = x + dx[i];
                int ny = y + dy[i];

                //이동한 좌표가 맵의 범위 안인지 확인하기
                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) {
                    continue;
                }

                //이동할수있는 좌표인지 확인 하기 (갈수있는 좌표는 1이기 때문에 확인한다) 이미 간곳은 +1로 구분하기 때문에 동일한 좌표는 이동하지 않음
                if (maps[nx][ny] == 1) {
                    //이동한 곳에 이동전 숫자의 +1씩 쌓기 (초기 1에서 부터 +1씩 하기때문에 End값에 들어가면 이동한 칸수가 나온다 1 -> 2 -> 3..
                    maps[nx][ny] = maps[x][y] + 1;

                    //End 지점 4,4가 업데이트 되면 루프 종료
                    if (maps[maps.length - 1][maps[0].length - 1] != 1) {
                        break qLoop;
                    }
                    //다음 이동을 찾기 위해 큐에 이동한 좌표를 넣어준다
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        //마지막 지점의 수를 확인한다.maps[nx][ny] = maps[x][y] + 1; 으로 칸수를 계산
        int answer = maps[maps.length - 1][maps[0].length - 1];

        //마지막 지점의 값이 1(초기값)이면 골에 도착을 못한거니 -1, 1이 아니면 answer 를 리턴
        return answer == 1 ? -1 : answer;
    }

    @Test
    public void test() {

        assertEquals(11, solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
//        assertEquals(-1, solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));

    }


}
