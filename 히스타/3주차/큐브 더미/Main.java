//  큐브 더미

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int sum = 0;
        boolean[][][] map = new boolean[N + 1][N + 1][N + 1];

        // 큐브 정보 등록
        while (M-- > 0) {
            int i, j, k;
            i = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextInt();

            map[i][j][k] = true;
        }

        // 검색
        for (int i = 2; i < N; ++i) {
            for (int j = 2; j < N; ++j) {
                for (int k = 2; k < N; ++k) {
                    if (isCube(i, j, k, map)) sum++;
                }
            }
        }

        System.out.println(sum);
    }

    private static boolean isCube(int i, int j, int k, boolean[][][] map) {
        // (i ± 1), (j ± 1), (k ± 1) 총 6곳 모두에 큐브가 존재한다.
        return
            map[i - 1][j][k] && map[i + 1][j][k] &&
            map[i][j-1][k] && map[i][j+1][k] &&
            map[i][j][k-1] && map[i][j][k+1] &&
            map[i][j][k];
    }
}
