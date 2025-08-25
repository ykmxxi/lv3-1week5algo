
import java.awt.print.Pageable;
import java.util.*;
import java.lang.*;
import java.io.*;

// 웰컴 키트
// https://www.acmicpc.net/problem/30802
class BOJ30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int shirts[] = new int[6];
        shirts[0] = Integer.parseInt(st.nextToken());
        shirts[1] = Integer.parseInt(st.nextToken());
        shirts[2] = Integer.parseInt(st.nextToken());
        shirts[3] = Integer.parseInt(st.nextToken());
        shirts[4] = Integer.parseInt(st.nextToken());
        shirts[5] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tAnswer = 0;
        int idx;
        for (int i = 0; i < 6; i++) {
            idx = 1;
            if (shirts[i] % t == 0) {
                tAnswer += shirts[i] / t;
            } else {
                tAnswer += (shirts[i] / t) + 1;
            }
        }
        int pAnswer = n / p;
        int pAnswerM = n % p;
        System.out.println(tAnswer);
        System.out.println(pAnswer + " " + pAnswerM);
    }
}