import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen
public class BOJ9663 {

    public static final int MAXN = 15;
    public static int[][] chk = new int[MAXN][MAXN];

    // 좌하, 하, 우하
    public static int[] dr = {1, 1, 1};
    public static int[] dc = {-1, 0, 1};

    public static int N;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ans = 0;
        var startTime = System.currentTimeMillis();
        dfs(0);
        var endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " seconds");
        System.out.println(ans);
    }

    public static void dfs(int r) {
        if (r == N) {
            ans++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (chk[r][c] == 0) {
                // (r, c)에 퀸 놓기
                putQueen(r, c);
                dfs(r + 1);
                removeQueen(r, c);
            }
        }
    }

    private static void putQueen(int r, int c) {
        chk[r][c]++;
        for (int d = 0; d < 3; d++) {
            addBoard(r + dr[d], c + dc[d], d, 1);
        }
    }

    private static void removeQueen(int r, int c) {
        chk[r][c]--;
        for (int d = 0; d < 3; d++) {
            addBoard(r + dr[d], c + dc[d], d, -1);
        }
    }

    private static void addBoard(int r, int c, int d, int diff) {
        while (r >= 0 && r < N && c >= 0 && c < N) {
            chk[r][c] += diff;
            r += dr[d];
            c += dc[d];
        }
    }
}
