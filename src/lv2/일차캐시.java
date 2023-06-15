package lv2;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 일차캐시 {

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        int answer = 0;
        LinkedHashSet<String> cache = new LinkedHashSet<>(cacheSize);

        for (String city : cities) {
            String cityUp = city.toUpperCase();
            if (cache.contains(cityUp)) {
                answer++;
                cache.add(cityUp);
            } else {
                answer += 5;
                if (cache.size() == cacheSize) {
                    cache.remove(cache.iterator().next());
                }
                cache.add(cityUp);
            }
        }

        return answer;
    }

    @Test
    public void test() {

        assertEquals(50, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }


}
