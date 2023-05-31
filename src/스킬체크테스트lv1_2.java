public class 스킬체크테스트lv1_2 {

    public static void main(String[] args) {
        String answer = solution("aukks","wbqd",5);
        System.out.println(answer);

    }

    public static String solution(String s, String skip, int index) {
        String answer = "";
        //소문자로만 이루어져있음
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < index; j++) {
                chars[i]++;
                if (chars[i] > 'z') {
                    chars[i] = 'a';
                }
                while (skip.contains(String.valueOf(chars[i]))) {
                    chars[i]++;
                    if (chars[i] > 'z') {
                        chars[i] = 'a';
                    }
                }
            }
        }

        return String.valueOf(chars);
    }
}


