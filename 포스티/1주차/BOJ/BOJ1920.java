// https://www.acmicpc.net/problem/1920
// 시간 복잡도: O(M log(N)) -> 최악의 경우
// A 요소의 범위는 int

import java.io.*;
import java.util.*;

public class BOJ1920 {

    static int N, M;
    static int[] A;
    static int[] B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        pro();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokens[i]);
        }
        M = Integer.parseInt(br.readLine());
        tokens = br.readLine().split(" ");
        B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(tokens[i]);
        }
    }

    static void pro() {
        Arrays.sort(A);

        for (int i = 0; i < M; i++) {
            boolean flag = false;
            int L = 0;
            int R = N - 1;

            while (L <= R) {
                int m = (L + R) / 2;
                if (A[m] == B[i]) {
                    flag = true;
                    break;
                } else if (A[m] > B[i]) {
                    R = m - 1;
                } else {
                    L = m + 1;
                }
            }
            if (flag) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
