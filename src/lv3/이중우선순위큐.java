package lv3;

import java.util.*;

public class 이중우선순위큐 {
    public static void main(String[] args) {
            int[] answer = solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
            System.out.println(Arrays.toString(answer));
        }
    
        public static int[] solution(String[] s) {
            PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();
            PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Collections.reverseOrder());

            Arrays.stream(s)
                    .map(str -> str.split(" "))
                    .forEach(strings ->
                    {
                        if (strings[0].equals("I")) {
                            priorityQueueMax.offer(Integer.parseInt(strings[1]));
                            priorityQueueMin.offer(Integer.parseInt(strings[1]));
                        } else if (strings[0].equals("D") && strings[1].equals("1")) {  //최대값 삭제
                            priorityQueueMin.remove(priorityQueueMax.poll());
                        } else if (strings[0].equals("D") && strings[1].equals("-1")) { //최소값 삭제
                            priorityQueueMax.remove(priorityQueueMin.poll());
                        }
                    });

            List<Integer> list1 = new ArrayList<>(priorityQueueMin);
            List<Integer> list2 = new ArrayList<>(priorityQueueMax);
            list1.retainAll(list2);

            if (list1.isEmpty()) {
                return new int[]{0,0};
            }

            list1.sort(Collections.reverseOrder());
            return new int[]{list1.get(0),list1.get(list1.size()-1)};
        }
}
