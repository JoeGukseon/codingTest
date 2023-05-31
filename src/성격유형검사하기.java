import java.util.*;

public class 성격유형검사하기 {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        String answer = solution(survey, choices);
        System.out.println(answer);
    }

    private static String solution(String[] survey, int[] choices) {
        //["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
        //5 - 네오형 1점
        //3 - 콘형 1점
        //2 - 무지형 2점
        //7 - 튜브형 3점
        //5 - 어피치형 1점
        String result = "";
        //A N 3 2 1 0 1 2 3 // 5 -> N1 // 4점을 기준으로 A / N 이 나누어짐
        Map<Character, Integer> surveyChoice = new LinkedHashMap<>();
        int[] score = {3, 2, 1, 0, 1, 2, 3};
        surveyChoice.put('R', 0);
        surveyChoice.put('T', 0);
        surveyChoice.put('C', 0);
        surveyChoice.put('F', 0);
        surveyChoice.put('J', 0);
        surveyChoice.put('M', 0);
        surveyChoice.put('A', 0);
        surveyChoice.put('N', 0);

        int updateScore = 0;

        //초이스로 알파벳과 점수 뽑아내기
        for (int i = 0; i < choices.length; i++) {
            updateScore = score[choices[i] - 1];
            if (choices[i] == 4) {
            } // 0 점인 경우
            else if (choices[i] < 4) {
                if (surveyChoice.containsKey(survey[i].charAt(0))) updateScore += surveyChoice.get(survey[i].charAt(0));

                surveyChoice.put(survey[i].charAt(0), updateScore);
            } else {
                if (surveyChoice.containsKey(survey[i].charAt(1))) updateScore += surveyChoice.get(survey[i].charAt(1));

                surveyChoice.put(survey[i].charAt(1), updateScore);
            }
        }
        //점수대로 정렬하기
        result += indicators(surveyChoice, 'R', 'T');
        result += indicators(surveyChoice, 'C', 'F');
        result += indicators(surveyChoice, 'J', 'M');
        result += indicators(surveyChoice, 'A', 'N');

        return result;
    }

    private static Character indicators(Map<Character, Integer> surveyChoice, Character c1, Character c2) {
        if (surveyChoice.get(c1) >= surveyChoice.get(c2)) {
            return c1;
        }
        else
            return c2;
    }
}


