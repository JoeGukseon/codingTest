package lv2;

public class 최대값과최소값 {
    public static void main(String[] args) {
        String answer = solution("1 2 3 4");
            System.out.println(answer);
        }
    
        public static String solution(String s) {
            String answer = "";
            String[] strings = s.split(" ");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (String string : strings) {
                int num = Integer.parseInt(string);
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
            answer = min + " " + max;

            //가장 좋을것같은 코드
//            StringBuffer sb = new StringBuffer();
//            sb.append(Arrays.stream(arrInt).min().getAsInt());
//            sb.append(" ");
//            sb.append(Arrays.stream(arrInt).max().getAsInt());
            return answer;
        }
}
