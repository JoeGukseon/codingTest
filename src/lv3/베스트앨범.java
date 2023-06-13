package lv3;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playScore = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playScore.put(genres[i], playScore.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> playScoreList = new ArrayList<>(playScore.entrySet());
        playScoreList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        List<Map<Integer, Integer>> res = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : playScoreList) {
            String str = stringIntegerEntry.getKey();
            List<Map<Integer, Integer>> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(str)) {
                    Map<Integer, Integer> tempMap = new HashMap<>();
                    tempMap.put(plays[i], i);
                    list.add(tempMap);
                }
            }
            list.sort(Comparator.comparingInt((Map<Integer, Integer> map) -> map.keySet().iterator().next()).reversed());
            res.add(list.get(0));
            if (list.size() != 1) {
                res.add(list.get(1));
            }
        }
        return res.stream().mapToInt(map -> map.entrySet().iterator().next().getValue()).toArray();
//        Map<Integer, List<Object>> hashMap = new HashMap<>();
//        for (int i = 0; i < genres.length; i++) {
//            List<Object> values = new ArrayList<>();
//            values.add(genres[i]);
//            values.add(plays[i]);
//            hashMap.put(i, values);
//        }
//        return Stream.concat(
//                hashMap.entrySet().stream()
//                        .filter(integerListEntry -> integerListEntry.getValue().get(0).equals(playScoreList.get(0).getKey()))
//                        .sorted(Comparator.comparingInt((Map.Entry<Integer, List<Object>> entry) -> (int) entry.getValue().get(1))
//                                .reversed()
//                                .thenComparing(entry -> (String) entry.getValue().get(0)))
//                        .limit(2).map(Map.Entry::getKey),
//                hashMap.entrySet().stream()
//                        .filter(integerListEntry -> integerListEntry.getValue().get(0).equals(playScoreList.get(1).getKey()))
//                        .sorted(Comparator.comparingInt((Map.Entry<Integer, List<Object>> entry) -> (int) entry.getValue().get(1))
//                                .reversed()
//                                .thenComparing(entry -> (String) entry.getValue().get(0)))
//                        .limit(2).map(Map.Entry::getKey)
//        )
//                .mapToInt(Integer::intValue)
//                .toArray();
//        List<Integer> playsList = Arrays.stream(plays).boxed().collect(Collectors.toList());
//        return hashMap.entrySet().stream()
//                .filter(entry -> {
//                    String genre = (String) entry.getValue().get(0);
//                    return genre.equals(playScoreList.get(0).getKey()) || genre.equals(playScoreList.get(1).getKey());
//                })
//                .collect(Collectors.groupingBy(entry -> (String) entry.getValue().get(0)))
//                .entrySet().stream()
//                .sorted(Comparator.comparingInt(entry -> {
//                    String genre = entry.getKey();
//                    if (genre.equals(playScoreList.get(0).getKey())) {
//                        return 0;
//                    } else if (genre.equals(playScoreList.get(1).getKey())) {
//                        return 1;
//                    } else {
//                        return 2;
//                    }
//                }))
//                .flatMap(entry2 -> entry2.getValue().stream()
//                        .sorted(Comparator.comparingInt((Map.Entry<Integer, List<Object>> entry) -> (int) entry.getValue().get(1))
//                                .reversed())
//                        .limit(2))
//                .mapToInt(entry -> playsList.indexOf(entry.getValue().get(1)))
//                .toArray();
    }

    @Test
    public void test() {
//        solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
//                new int[]{500, 600, 150, 800, 2500});
        assertArrayEquals(new int[]{5, 6, 4, 1, 3, 0}, solution(new String[]{"classic", "pop", "classic", "classic", "pop", "jj", "jj"}, new int[]{500, 600, 150, 800, 2500, 10000, 1}));
//        assertArrayEquals(new int[]{0,3,1}, solution(new String[]{"classic", "pop", "classic", "classic"},
//                new int[]{800, 600, 150, 800}));
    }


}
