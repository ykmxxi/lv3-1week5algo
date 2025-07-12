import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1023
// 괄호 문자열
public class BOJ1023 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static long[][] po;
    static char[] ans;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        // po[len][cntOpen] = 괄호 문자열이 될 가능성이 있고, 길이가 len이면서, (의 개수가 cntOpen개 남는 문자열.
        po = new long[N + 1][N + 2];
        ans = new char[N + 1];

        po[0][0] = 1;
        for (int len = 1; len <= N; len++) {
            po[len][0] = po[len - 1][1];
            for (int cntOpen = 1; cntOpen < N; cntOpen++) {
                po[len][cntOpen] = po[len - 1][cntOpen - 1] + po[len - 1][cntOpen + 1];
            }
            po[len][N] = po[len - 1][N - 1];
        }
        long impoSum = (1L << N) - po[N][0];
        if (impoSum <= K) {
            System.out.println("-1");
            return;
        }

        solve(0, N, 0, K, true);

        for (int i = 0; i < N; i++) {
            bw.write(ans[i]);
        }
        bw.flush();
    }

    // isPossible: 아직 올바른 괄호 문자열이 될 가능성이 있으면 true
    private static void solve(int idx, int leftLen, int cntOpen, long leftK, boolean isPossible) {
        if (idx == N) {
            return;
        }

        // cnt = idx에 (를 고정했을 때, 괄호 ㄴㄴ 문자열 개수
        long cnt = (1L << (leftLen - 1));
        if (isPossible) {
            cnt -= po[leftLen - 1][cntOpen + 1];
        }

        if (leftK < cnt) {
            ans[idx] = '(';
            solve(idx + 1, leftLen - 1, cntOpen + 1, leftK, isPossible);
        } else {
            ans[idx] = ')';
            if (cntOpen - 1 < 0) {
                isPossible = false;
            }
            solve(idx + 1, leftLen - 1, cntOpen - 1, leftK - cnt, isPossible);
        }
    }
}