package lv2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
/*
하나씩 차례대로
files를 정규식으로 나누어
1 : 첫번째 문자열
2 : 0
3 : 나머지 숫자
4 : 나머지 문자열
List에 넣고
정렬을 문자열을 소문자로 바꾸고 정렬,
다음정렬은 숫자로 바꾸고 정렬
다시 String으로 바꾸고 배열로 저장 후 리턴
 */
public class 파일명정렬 {
    public String[] solution(String[] files) {
        final int HEAD = 0;
        final int NUMBER = 1;
        final int TAIL = 2;
        final int NUMBER_ORIGIN = 3;


        List<String[]> fileList = new ArrayList<>();

        for (String str : files) {
            String[] fileName = new String[4];
            fileName[HEAD] = "";
            fileName[NUMBER] = "";
            fileName[TAIL] = "";
            fileName[NUMBER_ORIGIN] = "";

            Pattern pattern = Pattern.compile("(\\D+)(0*)(\\d+)(.*)");
            Matcher matcher = pattern.matcher(str);

            if (matcher.matches()) {
                fileName[HEAD] = matcher.group(1);
                fileName[NUMBER] = matcher.group(3);
                fileName[TAIL] = matcher.group(4);
                fileName[NUMBER_ORIGIN] = matcher.group(2)+matcher.group(3);
            }

//            System.out.println("fileNameHEAD = " + fileName[HEAD]);
//            System.out.println("fileNameNUMBER = " + fileName[NUMBER]);
//            System.out.println("fileNameTAIL = " + fileName[TAIL]);
//            System.out.println("fileNameTAIL = " + fileName[NUMBER_ORIGIN]);
            fileList.add(fileName);
        }

        fileList.sort(Comparator.comparing((String[] strArr) -> strArr[HEAD].toLowerCase())
                .thenComparing((strArr1, strArr2) -> {
                    Integer integer1 = Integer.parseInt(strArr1[NUMBER]);
                    Integer integer2 = Integer.parseInt(strArr2[NUMBER]);
                    return integer1.compareTo(integer2);
                }));


//        for (String[] strings : fileList) {
//            System.out.println("HEAD: " + strings[HEAD] + ", NUMBER: " + strings[NUMBER] + ", TAIL: " + strings[TAIL]);
//        }
        return fileList.stream()
                .flatMap(strings -> Stream.of(strings[HEAD] + strings[NUMBER_ORIGIN] + strings[TAIL]))
//                .peek(System.out::println)
                .toArray(String[]::new);
    }

    @Test
    public void test() {

        assertArrayEquals(new String[]{
                "img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"
        }, solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
        assertArrayEquals(new String[]{
                "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"
        }, solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}));
    }


}
