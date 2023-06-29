package lv2;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
HashSet에다가 좌표를 넣기
처음에 String으로 넣었다가 반대방향 처리가 안되서 테스트 실패
좌표 기록을 String이 아니라 전 좌표 + 현좌표를 더해서 숫자로 계산해 반대방향 제거
 */
public class 방문길이 {
    public int solution(String dirs) {
        Set<Integer> set = new HashSet<>();
        int[] map = new int[]{-5, 5};
        int x = 0;
        int y = 0;
        Integer pre = 0;
        for (int i = 0; i < dirs.length(); i++) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if (map[0] <= y - 1) {
                        y--;
                    }
                    break;
                case 'D':
                    if (map[1] >= y + 1) {
                        y++;
                    }
                    break;
                case 'L':
                    if (map[0] <= x - 1) {
                        x--;
                    }
                    break;
                case 'R':
                    if (map[1] >= x + 1) {
                        x++;
                    }
                    break;
            }
            if (pre == (x * 100 + y)) {
                continue;
            }
            set.add(pre + (x * 100 + y));
//            System.out.println("pre + \">\" + x + \",\" + y = " + pre + ">" + x + "," + y);
            pre = x * 100 + y;
//            System.out.println("Arrays.toString(set.stream().toArray()) = " + Arrays.toString(set.toArray()));
        }
        return set.size();
    }

    @Test
    public void test() {

        assertEquals(7, solution("ULURRDLLU"));
        assertEquals(7, solution("LULLLLLLU"));
        assertEquals(5, solution("RRRRRLLLLL"));//반대방향 중복제거
    }


}
