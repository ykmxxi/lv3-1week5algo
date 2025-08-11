import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/submit/1120
// 문자열
// 카테고리: Greedy
public class BOJ1120 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        if (A.length() > B.length()) {
            String C = A;
            A = B;
            B = C;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= B.length() - A.length(); i++) {

            String subB = B.substring(i, B.length());
            int diff = calculateDiff(A, subB);
            minDiff = Math.min(minDiff, diff);
        }

        bw.write(String.valueOf(minDiff));
        bw.flush();
    }

    static int calculateDiff(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int diff = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }
}
