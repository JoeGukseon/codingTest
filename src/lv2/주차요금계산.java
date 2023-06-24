package lv2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 주차요금계산 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, ParkingInfo> parkingInfoMap = new HashMap<>();
        for (String record : records) {
            String[] parkingData = record.split(" "); // 0 : 시간 / 1 : 차번호 / 2 : 내역

            int time = Integer.parseInt(parkingData[0].split(":")[0]) * 60; // 시간 : 시
            time += Integer.parseInt(parkingData[0].split(":")[1]); //시간 : 분
            String carNum = parkingData[1];
            String breakDown = parkingData[2];

            //주차 신규등록
            if (!parkingInfoMap.containsKey(carNum)) {
                ParkingInfo parkingInfo = new ParkingInfo(time, carNum, breakDown);
                parkingInfoMap.put(carNum, parkingInfo);
            }
            //등록된 차량
            else {
                //차량 정보조회
                ParkingInfo parkingInfo = parkingInfoMap.get(carNum);
                //시간 주차 시간 처리
                parkingInfo.parkingInOut(time,breakDown);
            }
        }
        //요금 정산
        List<String> sortKey = new ArrayList<>(parkingInfoMap.keySet());
        Collections.sort(sortKey);
        List<Integer> chargeList = new ArrayList<>();

        for (String key : sortKey) {
            chargeList.add(parkingInfoMap.get(key).totalCal(fees));
        }

        return chargeList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static class ParkingInfo {
        int time;
        String carNum;
        String status = "NONE";
        int parkingTime = 0;

        public String getStatus() {
            return status;
        }

        public ParkingInfo(int time, String carNum, String status) {
            this.time = time;
            this.carNum = carNum;
            this.status = status;
        }

        public void parkingInOut(int time, String check) {
            if (check.equals("IN")) {
                this.time = time;
            } else {
                parkingTime += time - this.time;
            }
            status = check;
        }

        public int totalCal(int[] fees) {
            int basicTime = fees[0];
            int charge = fees[1];
            long unitTime = fees[2];
            int unitCharge = fees[3];
            //OUT 없이 종료된경우
            if (Objects.equals(status, "IN")) {
                parkingTime += ((23*60)+59) - time;
                status = "OUT";
            }
            if (parkingTime > basicTime) {
                charge += Math.ceil((parkingTime - basicTime) / (unitTime + 0.0)) * unitCharge;
            }

            return charge;
        }
    }


    @Test
    public void test() {
        assertArrayEquals(new int[]{14600, 34400, 5000},solution(new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}));
        assertArrayEquals(new int[]{0, 591},solution(new int[]{120, 0, 60, 591},
                new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}));
        assertArrayEquals(new int[]{14841},solution(new int[]{1, 461, 1, 10},
                new String[]{"00:00 1234 IN"}));
    }

}


