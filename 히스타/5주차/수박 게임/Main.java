//  수박 게임

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int waterMelonLevel = sc.nextInt();
        int cherries = sc.nextInt();

        // 2^N-1 = N 단계를 만드는 데 필요한 체리 개수
        int requiredCherries = (int)Math.pow(2, waterMelonLevel - 1);

        // 즉 requiredCherries = 수박 1개 이므로.
        // 현재 cherries에 requiredCherries를 나누면 답이 나옴.
        System.out.println((int)cherries / requiredCherries);
    }
}
