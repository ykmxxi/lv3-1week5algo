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

    static final int MAXN = 1120;
    static final int MAXK = 14;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[MAXN + 1];
        for (int i = 2; i <= MAXN; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= MAXN; j += i) {
                isNotPrime[j] = true;
            }
        }
        // 187개
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= MAXN; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }

        int[][] dp = new int[MAXK + 1][MAXN + 1];
        dp[0][0] = 1;
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            for (int j = MAXK; j > 0; j--) {
                for (int number = MAXN; number > 0 && number - prime >= 0; number--) {
                    dp[j][number] += dp[j - 1][number - prime];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sb.append(dp[k][n])
                    .append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
