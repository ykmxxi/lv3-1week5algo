import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2630
//색종이 만들기
public class BOJ2630 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int ans0 = 0;
    static int ans1 = 0;

    static void solve(int r, int c, int width, final int[][] sum, final int[][] A) {
        if(width == 1) {
            if(A[r][c] == 0) ans0++;
            else ans1++;
            return;
        }

        // (r, c) ~ (r+width-1, c+width-1)
        int cnt1 = sum[r+width-1][c+width-1] - (sum[r-1][c+width-1] + sum[r+width-1][c-1]) + sum[r-1][c-1];
        if(cnt1 == width*width) {
            ans1++;
            return;
        } else if(cnt1 == 0) {
            ans0++;
            return;
        }

        solve(r, c, width/2, sum, A);
        solve(r+width/2, c, width/2, sum, A);
        solve(r, c+width/2, width/2, sum, A);
        solve(r+width/2, c+width/2, width/2, sum, A);
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[][] A = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + A[i][j];
            }
        }
        solve(1, 1, N, sum, A);
        bw.write(String.format("%d\n%d", ans0, ans1));
        bw.flush();
    }
}