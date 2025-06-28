import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/22869
class BOJ22869 {

    static final int MAXN = 5000;
    static int[] A = new int[MAXN + 1];
    static boolean[] dp = new boolean[MAXN + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = true;
        for (int i = 0; i < N; i++) {
            if (!dp[i]) {
                continue;
            }

            for (int j = i + 1; j < N; j++) {
                int force = calcForce(i, j);
                if (force <= K) {
                    dp[j] = true;
                }
            }
        }

        System.out.printf("%s", dp[N - 1] ? "YES" : "NO");
    }

    public static int calcForce(int i, int j) {
        return (j - i) * (1 + Math.abs(A[i] - A[j]));
    }
}