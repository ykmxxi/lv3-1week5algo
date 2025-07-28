//  점수계산

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 문제의 개수

        int before_score = 0; // 이전 문제에서 얻은 점수
        int sum = 0;
        while (N-- > 0) {
            int result = sc.nextInt();
            if (result == 1) {
                sum += before_score + 1;
                before_score += 1;
            } else {
                before_score = 0;
            }
        }

        System.out.println(sum);
    }
}
