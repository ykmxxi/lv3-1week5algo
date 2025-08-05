import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int K = Integer.parseInt(br.readLine());

        int[][] c = new int[K+1][2];
        StringTokenizer st;
        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            c[i][0] = a;
            c[i][1] = b;

        }

        int[][] dp = new int[K+1][N+1];
        dp[0][0] = 1;

        for(int i=1; i<=K; i++){

            for(int j=0; j<=N; j++){

                for(int k=0; k<= c[i][1]; k++){
                    int val = j - c[i][0] * k;
                    if(val < 0) break;
                    dp[i][j] += dp[i-1][val];
                }
            }
        }

        System.out.println(dp[K][N]);
    }

}
