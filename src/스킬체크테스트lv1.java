public class 스킬체크테스트lv1 {
    public static void main(String[] args) {
        String[] survey = {"aya", "yee", "u", "maa"};

        int answer = solution(survey);
        System.out.println(answer);

        String[] survey2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};

        int answer2 = solution(survey2);
        System.out.println(answer2);
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] strings = {"aya", "ye", "woo", "ma"};

        for (String s : babbling) {
            for (String a : strings) {
                if (s.contains(a.repeat(2))) { // 연속 발음 걸러내기
                    continue;
                }
                s = s.replace(a, " "); // 삭제시 남은 글자 에러방지 위해 공백으로 변경
            }
            s = s.replace(" ", ""); // 공백제거
            if(s.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}
