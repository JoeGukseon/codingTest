import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 개인정보수집유효기간 implements TemporalAdjuster {
    @Override
    public Temporal adjustInto(Temporal temporal) {
        return temporal.with(ChronoField.MONTH_OF_YEAR, 12).with(ChronoField.DAY_OF_MONTH, 28);
    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        int[] answer = solution(today, terms, privacies);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(String today, String[] terms, String[] privacies) {
//        int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        //terms 분류 하기 A 6 > A 6달
        //A < 2칸뒤 월
        HashMap<String, Integer> termMap = new HashMap<>();
        //mapping
        for (int i = 0; i < terms.length; i++) {
            String[] splitTerm = terms[i].split(" ");
            termMap.put(splitTerm[0], Integer.parseInt(splitTerm[1]));
        }

        //privacies에서 개인정보 수집일자 , 약관 종류 구분하기
        List<String[]> dateTermList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] splitPrivacies = privacies[i].split(" ");
            dateTermList.add(splitPrivacies);
        }

        for (int i = 0; i < dateTermList.size(); i++) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd");
            String[] strings = dateTermList.get(i);
            LocalDate date = LocalDate.parse(strings[0], dtf)
                    .plusMonths(termMap.get(dateTermList.get(i)[1]))
                    .minusDays(1);
            if(date.getDayOfMonth()>28) {
                date = date.withDayOfMonth(28);
            }


            LocalDate now = (LocalDate.parse(today, dtf));
            Period period = Period.between(date, now);
            //오늘 날짜 - 현재날짜 = 유효기간월
            if (!(period.isNegative()|| period.isZero())) {
                answer.add(i+1);
            }
        }

        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }

        return answerArray;
    }

}
