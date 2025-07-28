import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1300
// K번째 수
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long l = 1, r = (long) N * N;
        while (l <= r) {
            long mid = (r - l) / 2 + l;
            if (isEnough(mid, N, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        bw.write(String.valueOf(l));
        bw.flush();
    }

    static boolean isEnough(long x,
                            final int N, final int k) {
        long cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt += Math.min(N, x / i);
        }
        return cnt >= k;
    }
}
