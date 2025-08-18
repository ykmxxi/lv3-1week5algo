import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1253
// 좋다
public class BOJ1253 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        // N <= 2000
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        A.sort((a, b) -> a - b);

        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            valueMap.put(
                    A.get(i), valueMap.getOrDefault(A.get(i), 0) + 1
            );
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            // A[j]를 이용해서 합을 A[i]로 만들 수 있는가?
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                int target = A.get(i) - A.get(j);

                int bidx = bs(target, N, A);
                if (bidx < 0 || bidx > N - 1 || target != A.get(bidx)) {
                    continue;
                }

                if (A.get(bidx) == A.get(i) && A.get(bidx) == 0
                        && valueMap.getOrDefault(A.get(bidx), 0) <= 2) {
                    continue;
                }
                if ((A.get(bidx) == A.get(i) || A.get(bidx) == A.get(j))
                        && valueMap.getOrDefault(A.get(bidx), 0) < 2) {
                    continue;
                }
                ans++;
                break;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int bs(int a, int N, List<Integer> A) {
        int L = 0, R = N - 1;
        while (L <= R) {
            int M = (L + R) / 2;
            if (A.get(M) <= a) {
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return R;
    }
}
