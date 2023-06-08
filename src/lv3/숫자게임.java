package lv3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 숫자게임 {
                    public int solution(int[] A,int[] B) {
                        int answer = 0;
                        PriorityQueue<Integer> a = new PriorityQueue<>(Comparator.reverseOrder());
                        PriorityQueue<Integer> b = new PriorityQueue<>(Comparator.reverseOrder());

                        for (int i = 0; i < A.length; i++) {
                            a.offer(A[i]);
                            b.offer(B[i]);
                        }
                        while (!a.isEmpty()) {
                            int aNum = a.poll();
                            int bNum = b.peek();

                            if (aNum < bNum) {
                                b.poll();
                                answer++;
                            }
                        }
                        return answer;
                    }
                    
                        @Test
                        public void test() {
                            
                            Assertions.assertEquals(3, solution(new int[]{5,1,3,7},new int[]{2,2,6,8}));
                        }
                    
                                
                            


        
                    
}
