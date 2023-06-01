package lv2;

import java.util.Stack;

public class 올바른괄호 {
    public static void main(String[] args) {
        boolean answer = solution("(()))");
            System.out.println(answer);
        }
    
        public static boolean solution(String s) {
            Stack<Character> stack = new Stack<>();


            try {
                for (Character c : s.toCharArray()) {
                    if (c == '(') {
                        stack.push(c);
                    } else {
                        stack.pop();
                    }

                }
            } catch (Exception e) {
                return false;
            }

            return stack.empty();
        }
}

/*

좋은풀이
class Solution {
    boolean solution(String s) {
        boolean answer = false;
        int count = 0;
        for(int i = 0; i<s.length();i++){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0){
                break;
            }
        }
        if(count == 0){
            answer = true;
        }

        return answer;
    }
}
 */