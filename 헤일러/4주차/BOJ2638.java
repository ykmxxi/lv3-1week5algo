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

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int MAXN = 100;
    static int CHEESE = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[MAXN + 2][MAXN + 2];
        List<Node> cheeses = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == CHEESE) {
                    cheeses.add(new Node(i, j));
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int time = 0;

        while (!cheeses.isEmpty()) {
            time++;

            Deque<Node> dq = new ArrayDeque<>();
            boolean[][] visited = new boolean[MAXN + 2][MAXN + 2];
            dq.addLast(new Node(0, 0));
            visited[0][0] = true;

            while (!dq.isEmpty()) {
                Node cur = dq.pollLast();

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if (!isIn(N, M, nr, nc) || visited[nr][nc] || board[nr][nc] == CHEESE) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    dq.addLast(new Node(nr, nc));
                }
            }

            List<Node> notMeltedCheeses = new ArrayList<>();
            for (Node cheese : cheeses) {
                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = cheese.r + dr[d];
                    int nc = cheese.c + dc[d];
                    if (visited[nr][nc]) {
                        cnt++;
                    }
                }
                if (cnt >= 2) {
                    board[cheese.r][cheese.c] = 0;
                } else {
                    notMeltedCheeses.add(cheese);
                }
            }
            cheeses = new ArrayList<>(notMeltedCheeses);
        }

        bw.write(String.valueOf(time));
        bw.flush();
    }

    static boolean isIn(int n, int m, int nr, int nc) {
        return !(nr < 0 || nr > n + 1 || nc < 0 || nc > m + 1);
    }

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}