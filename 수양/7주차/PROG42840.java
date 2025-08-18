import java.util.*;

// 프로그래머스 - 모의고사
// https://school.programmers.co.kr/learn/courses/30/lessons/42840?language=java
class Solution {
    public int[] solution(int[] answers) {
        int[][] member = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int p = 0; p < 3; p++) {
                if (answers[i] == member[p][i % member[p].length]) {
                    scores[p]++;
                }
            }
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> winners = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                winners.add(i + 1);
            }
        }

        int[] result = new int[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            result[i] = winners.get(i);
        }
        return result;
    }
}
