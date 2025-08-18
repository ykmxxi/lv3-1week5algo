import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2624
// 동전 바꿔주기
public class BOJ2624 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] p = new int[k];
        int[] n = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            n[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[T + 1];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            for (int money = T; money > 0; money--) {
                for (int j = 1; j <= n[i] && money - j * p[i] >= 0; j++) {
                    dp[money] += dp[money - j * p[i]];
                }
            }
        }

        bw.write(String.valueOf(dp[T]));
        bw.flush();
    }
}
