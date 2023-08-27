import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class nQueen {

    static int n;
    static int[] map;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=1; i<n+1; i++) {
            map = new int[n+1];
            map[1] = i; // (1,i)에 queen
            dfs(2);
        }

        System.out.println(count);
    }



    static void dfs(int depth) {

        if(depth > n) {
            count++;
        }
        else {
            for(int i=1; i<n+1; i++) {
                map[depth] = i; // (depth,i)에 queen
                if(check(depth)) {
                    dfs(depth+1);
                }
                // 없어도 됨. 이미 map[depth] = i에서 부모 퀸의 위치가 초기화 되었기 때문이다.
                // map[depth] = 0;
            }
        }
    }

    static boolean check(int depth) {

        for(int i=1; i<depth; i++) {
            // 열이 같으면 false
            if(map[i] == map[depth]) return false;

            // 00 01 02 03
            // 10 11 12 13
            // 20 21 22 23
            // 30 31 32 33

            // (/\) 양방향 대각선
            if(Math.abs(i-depth) == Math.abs(map[i]-map[depth])) return false;

        }
        return true;
    }

}
