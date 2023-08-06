import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 이2016년 {

    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().name().substring(0, 3);
    }
    @Test
    public void test() {

        assertEquals("TUE", solution(5,24));
    }


}
