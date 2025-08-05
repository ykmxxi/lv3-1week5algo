import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2839
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 100_000_000;
        dp[2] = 100_000_000;
        for(int i=3; i<=N; i++){
            dp[i] = Math.min(i < 5 ? 100_000_000 : dp[i-5] + 1, dp[i-3] + 1);
        }

        System.out.println(dp[N] >= 100_000_000 ? -1 : dp[N]);
    }

}

