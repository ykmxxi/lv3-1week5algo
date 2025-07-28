import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Z
public class BOJ1074 {

    static final int MAXN = 15;
    static int N;
    static List<Integer> pow2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        pow2.add(1);
        for (int i = 0; i < 15; i++) {
            pow2.add(pow2.get(pow2.size() - 1) * 2);
        }

        solve(r, c, 0, 0, N, 0);
    }

    public static void solve(int tr, int tc,
                             int cr, int cc, int n,
                             int cnt) {

        if (tr == cr && tc == cc) {
            System.out.println(cnt);
            return;
        }
        int width = pow2.get(n);

        if (isIn(cr, cr + width / 2 - 1, tr)
                && isIn(cc, cc + width / 2 - 1, tc)) {
            solve(tr, tc,
                    cr, cc, n - 1,
                    cnt);
            return;
        }

        int blockCnt = width / 2 * width / 2;
        if (isIn(cr, cr + width / 2 - 1, tr)
                && isIn(cc + width / 2, cc + width - 1, tc)) {
            solve(tr, tc,
                    cr, cc + width / 2, n - 1,
                    cnt + blockCnt);
            return;
        }

        if (isIn(cr + width / 2, cr + width - 1, tr)
                && isIn(cc, cc + width / 2 - 1, tc)) {
            solve(tr, tc,
                    cr + width / 2, cc, n - 1,
                    cnt + blockCnt * 2);
            return;
        }

        if (isIn(cr + width / 2, cr + width - 1, tr)
                && isIn(cc + width / 2, cc + width - 1, tc)) {
            solve(tr, tc,
                    cr + width / 2, cc + width / 2, n - 1,
                    cnt + blockCnt * 3);
        }
    }

    public static boolean isIn(int left, int right, int mid) {
        return left <= mid && mid <= right;
    }
}

