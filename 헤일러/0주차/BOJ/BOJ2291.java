import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Sequence
public class BOJ2291 {

    static final int MAXN = 10;
    static final int MAXM = 220;
    static final int MAXK = Integer.MAX_VALUE;

    static final int[] ans = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // dp[i][j][k]: 길이 i, 합이 j, 마지막이 k (0 base)
        int[][][] dp = new int[MAXN][MAXM][MAXM];
        for (int i = 0; i < MAXN; i++) {
            for (int j = 0; j < MAXM; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        solve(N, M, 1, 0, K - 1,
                dp);
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    public static int cache(int len, int sumM, int lastA,
                            int[][][] dp) {
        if (dp[len][sumM][lastA] != -1) {
            return dp[len][sumM][lastA];
        }
        if (len == 1) {
            return dp[len][sumM][lastA] = 1;
        }

        dp[len][sumM][lastA] = 0;
        for (int i = lastA; len * i <= sumM; i++) {
            dp[len][sumM][lastA] += cache(len - 1, sumM - i, i,
                    dp);
        }
        return dp[len][sumM][lastA];
    }

    public static void solve(int len, int sumM, int lastA, int pos, long sumK,
                             int[][][] dp) {
        if (len == 1) {
            ans[pos] = sumM;
            return;
        }

        long count = 0;
        for (int i = lastA; len * i <= sumM; i++) {
            long diff = cache(len - 1, sumM - i, i,
                    dp);

            if (count + diff > sumK) {
                ans[pos] = i;
                solve(len - 1, sumM - i, i, pos + 1, sumK - count,
                        dp);
                return;
            }
            count += diff;
        }
    }
}
