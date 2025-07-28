//  그래서 님 푼 문제 수가?

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int solveGoal = sc.nextInt();
        int solvePerDay = sc.nextInt();
        int tryingDays = sc.nextInt();

        int requiredQuota = solvePerDay *  tryingDays;

        // ANSWERS
        int minimumCountOfSolved = 0; // 현재까지 푼 문제의 최솟값
        int maximumCountOfSolved = 0; // 현재까지 푼 문제의 최댓값

        if (requiredQuota < solveGoal) { // 계획대로 풀고 나서도, 목표치에 도달하지 못했다면 이미 그만큼 풀었어야 됨.
            minimumCountOfSolved = solveGoal - requiredQuota; // 따라서 현재까지 푼 문제의 최솟값을 구할 수 있음.
            // 현재까지 푼 문제의 최댓값은, 현재 requiredQuota보다 한 단계 낮췄을 때와 비교해봐야 함.
            // K일이 지나기 전에 N 문제를 해결할 수 있는 입력은 주어지지 않음.
            int lowerRequiredQuota = solvePerDay * (tryingDays - 1);
            int diff = requiredQuota - lowerRequiredQuota;
            maximumCountOfSolved = minimumCountOfSolved + diff - 1;
        } else { // 계획대로 풀고 목표치에 도달했다면
            minimumCountOfSolved = 0; // 이전에 하나도 풀지 않았더라도 괜찮음.

            // maximum 구하기
            int lowerRequiredQuota = solvePerDay * (tryingDays - 1);
            if (lowerRequiredQuota + 1 >= solveGoal) { // 이전 Quota로 됐으면 이전껄로 말했을테니까 0
                maximumCountOfSolved = 0;
            } else { // 이전 Quota로 안된다면
                maximumCountOfSolved = solveGoal - lowerRequiredQuota - 1;
            }
        }

        System.out.println(minimumCountOfSolved + " " + maximumCountOfSolved);
    }
}
