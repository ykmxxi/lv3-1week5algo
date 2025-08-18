import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7579
// 앱
public class BOJ7579 {

    static final int MAXN = 100;
    static final int MAXC = 100;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] m = new int[N + 1];
        int[] c = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        // M 이상의 메모리를 확보해야 함. 최소의 비용으로.
        // N<=100, M,m<=1e7, c<=100
        // dp[i][j]: 1~i까지의 앱을 이용해 비용 j로 확보할 수 있는 최대 메모리
        // dp[i][j] = max(dp[i-1][j], dp[0][j - c[i]] + m[i]);
        int[][] dp = new int[MAXN + 1][MAXN * MAXC + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < c[i]; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            for (int j = N * MAXC; j >= c[i]; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - c[i]] + m[i]);
            }
        }

        for (int i = 0; i <= N * MAXC; i++) {
            if (dp[N][i] >= M) {
                bw.write(String.valueOf(i));
                break;
            }
        }
        bw.flush();
    }
}
