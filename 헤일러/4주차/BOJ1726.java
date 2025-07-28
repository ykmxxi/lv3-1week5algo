import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1726
// 로봇
public class BOJ1726 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int MAXN = 100;
    static int WALL = 1;

    static Map<Integer, Integer> directions = new HashMap<>() {{
        put(1, 1);
        put(2, 3);
        put(3, 2);
        put(4, 0);
    }};

    static int dr[] = {-1, 0, 1, 0};
    static int dc[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] board = new int[MAXN][MAXN];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken()) - 1;
        int startCol = Integer.parseInt(st.nextToken()) - 1;
        int startDir = directions.get(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        int endRow = Integer.parseInt(st.nextToken()) - 1;
        int endCol = Integer.parseInt(st.nextToken()) - 1;
        int endDir = directions.get(Integer.parseInt(st.nextToken()));

        int[][][] steps = new int[MAXN][MAXN][4];

        Deque<Node> dq = new ArrayDeque<>();
        dq.addLast(new Node(startRow, startCol, startDir));
        steps[startRow][startCol][startDir] = 1;
        while (!dq.isEmpty()) {
            Node cur = dq.pollFirst();

            // 보는 방향으로 1,2,3칸
            for (int i = 1; i <= 3; i++) {
                int nr = cur.r + dr[cur.dir] * i;
                int nc = cur.c + dc[cur.dir] * i;

                if (!isIn(M, N, nr, nc) || board[nr][nc] == WALL) {
                    break;
                }
                if (steps[nr][nc][cur.dir] != 0) {
                    continue;
                }
                steps[nr][nc][cur.dir] = steps[cur.r][cur.c][cur.dir] + 1;
                dq.addLast(new Node(nr, nc, cur.dir));
            }

            // 방향 회전
            List<Integer> nextDirs = List.of((cur.dir + 3) % 4, (cur.dir + 1) % 4);
            for (int nextDir : nextDirs) {
                if (steps[cur.r][cur.c][nextDir] != 0) {
                    continue;
                }
                steps[cur.r][cur.c][nextDir] = steps[cur.r][cur.c][cur.dir] + 1;
                dq.addLast(new Node(cur.r, cur.c, nextDir));
            }
        }

        bw.write(String.valueOf(steps[endRow][endCol][endDir] - 1));
        bw.flush();
    }

    static boolean isIn(int m, int n, int nr, int nc) {
        return !(nr < 0 || nr >= m || nc < 0 || nc >= n);
    }

    static class Node {
        int r, c, dir;

        public Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}