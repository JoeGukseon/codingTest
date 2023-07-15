package lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 호텔대실 {

    public int solution(String[][] book_time) {
        List<BookTime> timeList = new ArrayList<>();
        //시간 넣기
        for (String[] time : book_time) {
            BookTime bt = new BookTime(time[0].split(":")[0], time[0].split(":")[1], time[1].split(":")[0], time[1].split(":")[1]);
            timeList.add(bt);
        }
        //시간순 정렬
        timeList.sort(Comparator.comparingInt(o -> o.startTime));

        //방갯수를 셀 리스트를 만들고
        List<BookTime> rooms = new ArrayList<>();

        //정렬된 시간을 체크
        for (BookTime nowRoom : timeList) {
            //방이 없으면 추가
            if (rooms.isEmpty()) {
                rooms.add(nowRoom);
            } else {
                boolean roomChk = false;
                //이전방 시간의 청소 후 타임이 현재방 시간의 시작시간보다 작거나 같으면 같은방에 배정
                for (int i = 0; i < rooms.size(); i++) {
                    BookTime preRoom = rooms.get(i);
                    if (preRoom.endTime <= nowRoom.startTime) {
                        rooms.set(i, nowRoom);
                        roomChk = true;
                        break;
                    }
                }
                //룸 체크 완료후에도 없어야 새로운 룸을 추가
                if (!roomChk) {
                    rooms.add(nowRoom);
                }
            }
        }
        return rooms.size();
    }

    public class BookTime {
        int startTime;
        int endTime;

        public BookTime(String startHour, String startMin, String endHour, String endMin) {
            this.startTime = (Integer.parseInt(startHour) * 60) + Integer.parseInt(startMin);
            this.endTime = (Integer.parseInt(endHour) * 60) + Integer.parseInt(endMin) + 10;
        }
    }

    @Test
    public void test() {

        assertEquals(3, solution(new String[][]{{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
        assertEquals(1, solution(new String[][]{{"09:10", "10:10"}, {"10:20", "12:20"}}));
        assertEquals(3, solution(new String[][]{{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}}));
    }


}
