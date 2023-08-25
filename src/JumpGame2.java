import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGame2 {

    public int jump(int[] nums) {
//        int cnt = 0; //점프 뛴 횟수
//        int max = nums[0]; //현재 인덱스에서 갈수 있는 최대거리
//        int goal = nums.length-1; //목표 인덱스
//        int goalCnt = Integer.MAX_VALUE;
//        boolean isGoal = false;
//        for (int i = 0; i < goal; i++) { // 현재 위치 배열
//            if (i > max) { //현재 위치이 최대거리를 넘으면 cnt 반환
//                return cnt;
//            }
//            else {//현재 배열이 최대거리를 넘지 않으면
//                cnt++; //횟수를 높이고
//                if (nums[i]+i >= goal) { //갈수 있는지 확인 현재 위치에서 뛸수있는 거리가 goal에 닿는지 확인
//                    isGoal = true;
//                    cnt = Math.min(goalCnt, cnt);
//                }
//            }
//            max = Math.max(max,nums[i] + i); //최대 갈수있는 거리를 갱신
//        }
//
//        if (isGoal) {
//            return cnt;
//        } else {
//            return 0;
//        }
        int cnt = 0; //점프 횟수
        int cur = 0; //점프로 이동한 위치
        int max = 0; //갈수있는 최대치
        int goal = nums.length - 1; //골지점

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]); //현재 위치 + 점프거리 를 최대치에 업데이트
            if (max >= goal) { //최대치가 골지점을 넘었을때
                cnt++; //횟수 올리고 
                break;
            }
            if (i == cur) { //현재위치가 점프로 이동한 위치와 같으면 = 점프로 이동한 위치가 현재 위치인것(이때만 횟수를 증가) 항상 갈수있는 최대거리를 위치로 업데이트 해야 최소 횟수가 나옴
                cnt++; //횟수올리고
                cur = max; //점프로 이동한 위치를 업데이트
            }
        }
        return cnt;

    }

    @Test
    public void test() {

//        assertEquals(2, jump(new int[]{2,3,1,1,4}));
//        assertEquals(2, jump(new int[]{2,3,0,1,4}));
//        assertEquals(0, jump(new int[]{0}));
//        assertEquals(0, jump(new int[]{1}));
//        assertEquals(3, jump(new int[]{1,1,1,1}));
        assertEquals(3, jump(new int[]{1,2,1,1,1}));
    }


}
