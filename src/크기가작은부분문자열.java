import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//아래 케이스가 훨씬 빠름
//정렬도 안해서 더 빠른거 같은데 대용량일땐 위에꺼가 더 빠를려나..
public class 크기가작은부분문자열 {

    public int solution(String t, String p) {
        int answer = 0;
        List<Long> integerList = new ArrayList<>();

        for (int i = 0; i <= t.length() - p.length(); i++) {
            String subStr = t.substring(i, i + p.length());
            integerList.add(Long.parseLong(subStr));
        }

        Collections.sort(integerList);

        Long pValue = Long.parseLong(p);

        for (Long num : integerList) {
            if (num <= pValue) {
                answer++;
            } else {
                break;
            }
        }
        return answer;
        //길이가 18자리 까지 이기때문에 long으로 변경 ! int는 10자리 long은 19자리
//        int answer = 0;
//
//        for (int i = 0; i <= t.length() - p.length(); i++) {
//            String subStr = t.substring(i, i + p.length());
//            long num = Long.parseLong(subStr);
//
//            if (num <= Long.parseLong(p)) {
//                answer++;
//            }
//        }
//        return answer;
    }

    @Test
    public void test() {

        assertEquals(2, solution("3141592","271"));
    }


}
