import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2293
// 동전 1
public class BOJ2293 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int MAXK = 100_000;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[MAXK + 1];
        dp[0] = 1;
        for (int ci = 0; ci < n; ci++) {
            for (int won = 1; won <= k; won++) {
                if (won - coin[ci] < 0) {
                    continue;
                }
                dp[won] += dp[won - coin[ci]];
            }
        }

        bw.write(String.valueOf(dp[k]));
        bw.flush();
    }
}