package lv2;

public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        String answer = solution("3people  unFollowed me");
            System.out.println(answer);

        answer = solution("3333333333");
            System.out.println(answer);
        }
    
        public static String solution(String s) {
            String answer = "";
            String[] strings = s.split(" ");
            StringBuilder sb = new StringBuilder();

            for (String string : strings) {
                if (string.length() > 0) {
                    sb.append(string.substring(0, 1).toUpperCase());
                }
                if (string.length() > 1) {
                    sb.append(string.substring(1).toLowerCase());
                }
                sb.append(" ");
            }

            if (s.charAt(s.length() - 1) != ' ' && sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            answer = sb.toString();
            return answer;
        }
        //좋은 예제
//    public String solution(String s) {
//        String answer = "";
//        String[] sp = s.toLowerCase().split("");
//        boolean flag = true;
//
//        for(String ss : sp) {
//            answer += flag ? ss.toUpperCase() : ss;
//            flag = ss.equals(" ") ? true : false;
//        }
//
//        return answer;
//    }
}
