import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/7576
// 토마토
public class BOJ7576 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int MAXN = 1000;
    static int WALL = -1;
    static int HOT = 1;
    static int NOT_HOT = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new ArrayDeque<>();
        int[][] board = new int[MAXN][MAXN];
        int[][] steps = new int[MAXN][MAXN];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == HOT) {
                    dq.addLast(new Node(i, j));
                    steps[i][j] = 1;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (!isIn(M, N, nr, nc) || board[nr][nc] == WALL || steps[nr][nc] != 0) {
                    continue;
                }

                dq.addLast(new Node(nr, nc));
                steps[nr][nc] = steps[cur.r][cur.c] + 1;
            }
        }

        boolean isSuccess = true;
        int maxStep = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == NOT_HOT && steps[i][j] == 0) {
                    isSuccess = false;
                }
                maxStep = Math.max(maxStep, steps[i][j] - 1);
            }
        }
        if (isSuccess) {
            bw.write(String.valueOf(maxStep));
        } else {
            bw.write(String.valueOf(-1));
        }
        bw.flush();
    }

    static boolean isIn(int M, int N, int nr, int nc) {
        return !(nr < 0 || nr >= M || nc < 0 || nc >= N);
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}