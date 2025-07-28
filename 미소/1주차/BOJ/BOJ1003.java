import java.io.*;
import java.util.*;

class BOJ1003 {
    private static final int[][] dp = new int[42][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(dp[input][0] + " " + dp[input][1]);
        }
    }
}
