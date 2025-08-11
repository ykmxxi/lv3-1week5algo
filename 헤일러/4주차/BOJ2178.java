import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;


// https://www.acmicpc.net/problem/2178
// 미로 탐색
public class Main {

    static final int MAXN = 100;
    static final int MAXM = 100;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    private static int WALL = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> inp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            inp.add(s);
        }
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = inp.get(i).charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[MAXN][MAXM];
        int[][] step = new int[MAXN][MAXM];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                step[i][j] = -1;
            }
        }

        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};

        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(0, 0));
        step[0][0] = 0;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + cur.r;
                int nc = dc[d] + cur.c;
                if (!(isIn(0, N - 1, nr) && isIn(0, M - 1, nc))
                        || board[nr][nc] == WALL
                        || step[nr][nc] != -1
                ) {
                    continue;
                }
                step[nr][nc] = step[cur.r][cur.c] + 1;
                dq.addLast(new Node(nr, nc));
            }
        }
        bw.write(String.valueOf(step[N - 1][M - 1] + 1));
        bw.flush();
    }

    static boolean isIn(int st, int ed, int x) {
        return !(x < st || x > ed);
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
