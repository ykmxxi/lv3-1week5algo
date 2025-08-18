import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10573
// 증가하는 수
public class BOJ10573 {

    static final int MAX_LEN = 80;
    static final int MAX_NUMBER = 9;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        // cache[i][j]: 오른쪽부터 i자리이고, j로 시작하는 증가하는 수의 개수
        long[][] cache = new long[MAX_LEN + 1][MAX_NUMBER + 1];

        for (int i = 0; i <= MAX_NUMBER; i++) {
            cache[1][i] = 1;
        }

        for (int i = 2; i <= MAX_LEN; i++) {
            for (int j = 0; j <= MAX_NUMBER; j++) {
                for (int k = j; k <= MAX_NUMBER; k++) {
                    cache[i][j] += cache[i - 1][k];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String n = br.readLine();
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < n.length(); i++) {
                numbers.add(n.charAt(i) - '0');
            }

            if (!isNoneDecreasing(numbers)) {
                sb.append(-1)
                        .append("\n");
                continue;
            }

            long ans = 0;
            int startNumber = 0;
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = startNumber; j < numbers.get(i); j++) {
                    ans += cache[numbers.size() - i][j];
                }
                startNumber = numbers.get(i);
            }
            sb.append(ans)
                    .append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static boolean isNoneDecreasing(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) > numbers.get(i)) {
                return false;
            }
        }

        return true;
    }
}
