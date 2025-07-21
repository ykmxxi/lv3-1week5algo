// https://www.acmicpc.net/problem/15651
// 중복 순열
// 시간 복잡도: O(N^M)

import java.io.*;
import java.util.*;

public class BOJ15651 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static int[] sel;

    public static void main(String[] args) throws IOException {
        input();
        pro();
        bw.flush();
    }

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sel = new int[N];
    }

    static void pro() throws IOException {
        rec(0);
    }

    static void rec(int depth) throws IOException {
        if (depth == M) { // M개를 다 선택했으면
            for (int i = 0; i < M; i++) {
                bw.write(sel[i] + " ");
            }
            bw.write("\n");
        } else {
            for (int cand = 1; cand <= N; cand++) {
                sel[depth] = cand;
                rec(depth + 1);
                sel[depth] = 0; // 초기화
            }
        }
    }
}
