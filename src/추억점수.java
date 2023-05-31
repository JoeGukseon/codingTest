import java.util.Arrays;
import java.util.HashMap;

public class 추억점수 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5,10,1,3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = solution(name,yearning,photo);
        System.out.println(Arrays.toString(answer));
    }

    private static int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> mappingNameYearing = new HashMap<>();
        int[] answer = new int[photo.length];

        for (int i = 0; i < name.length; i++) {
            mappingNameYearing.put(name[i], yearning[i]);    //name-yearing 맵핑
        }


        for (int i = 0; i < photo.length; i++) {
            int result = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if(mappingNameYearing.containsKey(photo[i][j])) result += mappingNameYearing.get(photo[i][j]);
            }
            answer[i] = result;
        }

        return answer;
    }

}
