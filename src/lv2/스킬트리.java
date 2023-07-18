package lv2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            boolean isOk = true; //가능한 여부
            int curIdx = 0; //스킬의 인덱스
            for (char sk : skillTree.toCharArray()) {
                if (sk == skill.charAt(curIdx)) {
                    //최대 스킬트리 길이만큼만 증가
                    if (curIdx < skill.length()-1) {
                        curIdx++;
                    }
                } else if (!skill.contains(Character.toString(sk))) {   //스킬트리에 속하지 않은경우 pass
                    
                } else {
                    isOk = false;
                    break;
                }
            }
            if (isOk) {
                answer++;
            }
        }
        return answer;
    }


    @Test
    public void test() {

        assertEquals(2, solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }


}
