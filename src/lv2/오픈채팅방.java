package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class 오픈채팅방 {

    public String[] solution(String[] record) {
        final int ACT = 0;
        final int ID = 1;
        final int NICK = 2;

//        맵에 최종 닉네임을 업데이트
        Map<String, String> idMap = new HashMap<>();
//        for (String s : record) {
//                String[] strings = s.split(" ");
//                if (strings.length > 2) {
//                        idMap.put(strings[ID], strings[NICK]);
//                }
//            }
//        스트림처리
        Arrays.stream(record)
                .map(s -> s.split(" "))
                .filter(strings -> strings.length > 2)
                .forEach(strings -> idMap.put(strings[ID], strings[NICK]));

        //최종닉네임을 토대로 메시지들을 업데이트
//        List<String> message = new ArrayList<>();
//        for (String s : record) {
//            String[] strings = s.split(" ");
//            if (strings[ACT].equals("Enter")) {
//                message.add(idMap.get(strings[ID])+"님이 들어왔습니다.");
//            } else if (strings[ACT].equals("Leave")) {
//                message.add(idMap.get(strings[ID])+"님이 나갔습니다.");
//            }
//
//        }
//        return message.toArray(new String[0]);
        //스트림으로 처리
        return Arrays.stream(record)
                .map(s -> s.split(" "))
                .filter(strings -> strings[ACT].equals("Enter") || strings[ACT].equals("Leave"))
                .map(strings -> {
                    String action = strings[ACT];
                    String nickname = idMap.get(strings[ID]);
                    if (action.equals("Enter")) {
                        return nickname + "님이 들어왔습니다.";
                    } else {
                        return nickname + "님이 나갔습니다.";
                    }
                }).toArray(String[]::new);

    }


    @Test
    public void test() {

        assertArrayEquals(new String[]{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."},
                solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
    }


}
