import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10986
// 나머지 합
// 카테고리: DP
public class BOJ10986 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        int[] sum = new int[N + 1];
        int[] remCnt = new int[M];

        long ans = 0;
        remCnt[0] = 1;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            sum[i] = (sum[i - 1] + A[i]) % M;

            ans += remCnt[sum[i]];
            remCnt[sum[i]]++;
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}
