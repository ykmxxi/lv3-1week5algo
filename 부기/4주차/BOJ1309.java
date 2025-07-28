import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1309
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(3);
            return;
        }

        int[][] dp = new int[N+1][2];
        dp[1][0] = 1;
        dp[1][1] = 2;

        for(int i=2; i<=N; i++){
            // 이전 우리 경우의 수에서 사자를 추가하지 않는 경우
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % 9901;
            // 이전 우리 경우의 수에서 사자를 추가하려는 경우 (이전 우리가 빈 경우는 2가지 가능, 이전 우리가 비어있지 않은 경우는 1가지만 가능)
            dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1]) % 9901;
        }

        System.out.println((dp[N][0] + dp[N][1]) % 9901);
    }
}
