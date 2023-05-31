import java.util.HashMap;

public class 달리기경주 {
    public static void main(String[] args) {
        String[] players={"mumu", "soe", "poe", "kai", "mine"};
        String[] callings={"kai", "kai", "mine", "mine"};

        String[] answer = solution(players,callings);
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> playerRank = new HashMap<>();
        HashMap<Integer, String> playerRankNum = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerRank.put(players[i], i);
            playerRankNum.put(i, players[i]);
        }

        //콜 네임 순서변경
        for (int i = 0; i < callings.length; i++) {
            int changeRank = playerRank.get(callings[i]);
            String changeName = playerRankNum.get(changeRank - 1);
            playerRank.put(callings[i],changeRank-1);
            playerRank.put(changeName, changeRank);

            playerRankNum.put(changeRank - 1, callings[i]);
            playerRankNum.put(changeRank,changeName);
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = playerRankNum.get(i);
        }

        return answer;
    }
}
