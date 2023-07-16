package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
https://seongho96.tistory.com/38
참조
10,11 시간초과
짝수일 경우 +1만 하면되고
홀수일경우 01을 10으로 바꿔주고
01일 없을경우 최상위 1을 10으로 변경
 */
public class 두개이하로다른비트 {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder binary = new StringBuilder(Long.toBinaryString(numbers[i]));
                int lastIndexOf01 = binary.lastIndexOf("01");
                if (lastIndexOf01 >= 0) {
                    binary.setCharAt(lastIndexOf01, '1');
                    binary.setCharAt(lastIndexOf01 + 1, '0');
                } else { //"01"이 없는경우
                    binary.deleteCharAt(0);
                    binary.insert(0, "10");
                }
                answer[i] = Long.valueOf(binary.toString(), 2);
            }
        }
        return answer;
    }
//    public long[] solution(long[] numbers) {
//
////        long[] answer = numbers.clone();
////        for(int i = 0; i< answer.length; i++){
////            answer[i]++;
////            answer[i] += (answer[i]^numbers[i])>>2;
////        }
////        return answer;
//
////        for (int i = 0; i < numbers.length; i++) {
////            long originalNumber = numbers[i];
////            long modifiedNumber = originalNumber + 1;
////
////            while (true) {
////                long diff = originalNumber ^ modifiedNumber;
////                int bitCnt = Long.bitCount(diff);
////                if (bitCnt <= 2) {
////                    answer[i] = modifiedNumber;
////                    break;
////                }
////                modifiedNumber++;
////            }
////        }
////        return answer;
//
//        long[] answer = new long[numbers.length];
//
//        for (int i = 0; i < numbers.length; i++) {
//            String binaryString = Long.toBinaryString(numbers[i]);
//            long l = numbers[i];
//            while (true) {
//                l++;
//                String binaryStringNew = Long.toBinaryString(l);
//
//                int length1 = binaryString.length();
//                int length2 = binaryStringNew.length();
//
//                int maxLength = Math.max(length1, length2);
//                binaryString = String.format("%" + maxLength + "s", binaryString).replace(' ', '0');
//                binaryStringNew = String.format("%" + maxLength + "s", binaryStringNew).replace(' ', '0');
//
//                int diffCnt = 0;
//                boolean difFlag = false;
//                for (int j = 0; j < maxLength; j++) {
//                    if (binaryString.charAt(j) != binaryStringNew.charAt(j)) {
//                        diffCnt++;
//                    }
//                    if (diffCnt > 2) {
//                        difFlag = true;
//                        break;
//                    }
//                }
//                if (!difFlag) {
//                    answer[i] = l;
//                    break;
//                }
//            }
//        }
//        return answer;
//    }

    @Test
    public void test() {
        assertArrayEquals(new long[]{3, 11}, solution(new long[]{2, 7}));
    }


}
