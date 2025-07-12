import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/1992
// 쿼드트리
public class BOJ1992 {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static StringTokenizer st;

  static void solve(int r, int c, int width, final int[][] sum, final int[][] A) throws IOException{
    if(width == 1) {
      if(A[r][c]==1) bw.write("1");
      else bw.write("0");
      return;
    }

    int cnt1 = sum[r+width-1][c+width-1] - (sum[r-1][c+width-1] + sum[r+width-1][c-1]) + sum[r-1][c-1];
    if(cnt1 == width*width) {
      bw.write("1");
      return;
    } else if(cnt1 == 0) {
      bw.write("0");
      return;
    }

    bw.write("(");
    solve(r, c, width/2, sum, A);
    solve(r, c+width/2, width/2, sum, A);
    solve(r+width/2, c, width/2, sum, A);
    solve(r+width/2, c+width/2, width/2, sum, A);
    bw.write(")");
  }

  public static void main(String[] args) throws IOException {
    int N = Integer.parseInt(br.readLine());

    int[][] A = new int[N+1][N+1];
    int[][] sum = new int[N+1][N+1];

    for(int i=1; i<=N; i++) {
      String row = br.readLine();
      for(int j=1; j<=N; j++) {
         A[i][j] = row.charAt(j-1) - '0';
      }
    }

    for(int i=1; i<=N; i++) {
      for(int j=1; j<=N; j++) {
        sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + A[i][j];
      }
    }

    solve(1, 1, N, sum, A);
    bw.flush();
  }
}