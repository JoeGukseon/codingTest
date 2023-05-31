import java.util.*;
import java.util.stream.Collectors;

public class 신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
//        String[] report = {"muzi frodo", "muzi frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] answer = solution(id_list, report, k);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        //중복제거
        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());
        //신고 적용
        //id 리스트 초기화 후 map에 저장
        int[] idInt = new int[id_list.length];
        Map<String, Integer> idMap = Arrays.stream(id_list)
                .collect(Collectors.toMap(id -> id, id -> 0));

        for (String repo : reportList) {
            String[] s = repo.split(" ");
            String from = s[0];
            String to = s[1];
        }
        //id 별 신고확인
        //muzi이면 frodo와 neo확인
        for (int i = 0; i < id_list.length; i++) {
            int temp = 0;
            Iterator<String> iterator2 = reportList.iterator();
            while (iterator2.hasNext()) {
                String repo = iterator2.next();
                String[] s = repo.split(" ");
                if (s[0].equals(id_list[i])) {
                    if (idMap.get(s[1]) >= k) {
                        temp++;
                        iterator2.remove();
                    } else {
                        iterator2.remove();
                    }
                }
            }
            idInt[i] = temp;
        }
        return idInt;
    }

}


