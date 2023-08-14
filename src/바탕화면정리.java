import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 바탕화면정리 {

    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;
        answer[2] = Integer.MIN_VALUE;
        answer[3] = Integer.MIN_VALUE;

        for (int x = 0; x < wallpaper.length; x++) {
            for (int y = 0; y < wallpaper[x].length(); y++) {
                if (wallpaper[x].charAt(y)=='#') {
                    answer[0] = Math.min(x,answer[0]);
                    answer[1] = Math.min(y,answer[1]);
                    answer[2] = Math.max(x+1,answer[2]);
                    answer[3] = Math.max(y+1,answer[3]);
                }
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertArrayEquals(new int[]{0, 1, 3, 4}, solution(new String[]{".#...", "..#..", "...#."}));
        assertArrayEquals(new int[]{1, 3, 5, 8}, solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."}));
        assertArrayEquals(new int[]{0, 0, 7, 9}, solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}));
        assertArrayEquals(new int[]{1, 0, 2, 1}, solution(new String[]{"..", "#."}));
    }


}
