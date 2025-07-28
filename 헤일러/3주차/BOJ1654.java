import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1654
// 랜선 자르기
public class BOJ1654 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int K, N;
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] cable = new int[K];
        for (int i = 0; i < K; i++) {
            cable[i] = Integer.parseInt(br.readLine());
        }

        long l = 1, r = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (isPossible(mid, K, N, cable)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        bw.write(String.valueOf(r));
        bw.flush();
    }

    static boolean isPossible(long len,
                              final int K, final int N, final int[] cable) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += cable[i] / len;
        }
        return cnt >= N;
    }
}
