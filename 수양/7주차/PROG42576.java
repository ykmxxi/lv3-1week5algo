import java.util.*;

// 프로그래머스 - 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String, Integer> part = new HashMap<>();

        for(int i=0;i<participant.length; i++){
            if (!part.containsKey(participant[i])) {
                part.put(participant[i], 1);
            } else {
                part.put(participant[i], part.get(participant[i])+ 1);
            }
        }

        for(int i=0;i<completion.length;i++){
            part.put(completion[i], part.get(completion[i]) - 1);
        }
        String answer = "";
        for(int i=0;i<part.size();i++){
            if (part.get(participant[i]) > 0){
                answer = participant[i];
            }
        }

        return answer;
    }
}
