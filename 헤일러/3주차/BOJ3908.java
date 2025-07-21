import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3908
// 서로 다른 소수의 합
public class BOJ3908 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int MAXN = 1120;
    static int MAXK = 14;
    static boolean[] isNotPrime = new boolean[MAXN + 1];

    public static void main(String[] args) throws IOException {

        isNotPrime[1] = true;
        for (int i = 2; i <= MAXN; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= MAXN; j += i) {
                isNotPrime[j] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= MAXN; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            solve(n, k, primes);
        }
    }

    static void solve(int n, int k, final List<Integer> primes) throws IOException {
        // 0~i prime을 이용해서, 서로 다른 소수 j개의 합이 sum인 경우의 수
        // dp[j][sum] = dp[j-1][sum-prime[i]]
        int[][] dp = new int[MAXK + 1][MAXN + 1];

        dp[0][0] = 1;
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            if (prime > n) {
                break;
            }

            for (int j = k; j > 0; j--) {
                for (int sum = 2; sum <= n; sum++) {
                    if (sum - prime < 0) {
                        continue;
                    }
                    dp[j][sum] += dp[j - 1][sum - prime];
                }
            }
        }
        bw.write(String.format("%d\n", dp[k][n]));
        bw.flush();
    }
}