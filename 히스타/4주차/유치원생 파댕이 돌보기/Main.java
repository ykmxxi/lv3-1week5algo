//  유치원생 파댕이 돌보기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 파댕이를 돌봐야 되는 시간(분)
        int N = sc.nextInt(); // 사탕의 총 개수
        int sum = 0;
        while (N-- > 0) {
            sum += sc.nextInt();
        }

        System.out.println(T > sum ? "Padaeng_i Cry" : "Padaeng_i Happy");
    }
}
