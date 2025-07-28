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

// https://www.acmicpc.net/problem/5213
// 과외맨
public class BOJ5213 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    
    static final int MAXN = 500;
    static int[] steps = new int[MAXN * MAXN];
    static int[] parent = new int[MAXN * MAXN];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 홀수줄: N개의 타일, 짝수줄: N-1개 타일
        int tileCnt = (N + 1) / 2 * N + N / 2 * (N - 1);

        List<Tile> tiles = new ArrayList<>();

        for (int i = 0; i < tileCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tiles.add(new Tile(i, left, right));
        }

        List<Integer>[] graph = new ArrayList[tileCnt + 1];
        for (int i = 0; i < tileCnt; i++) {
            graph[i] = new ArrayList<>();
        }

        // 홀수줄
        for (int r = 0; r < N; r += 2) {
            for (int c = 0; c < N; c++) {
                Tile cur = tiles.get(getTileIdx(N, r, c));

                int nextIdx = getTileIdx(N, r, c - 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.left == next.right) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r, c + 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.right == next.left) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r - 1, c - 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.left == next.right) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r - 1, c);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.right == next.left) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r + 1, c - 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.left == next.right) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r + 1, c);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.right == next.left) {
                        graph[cur.idx].add(next.idx);
                    }
                }
            }
        }

        // 짝수줄
        for (int r = 1; r < N; r += 2) {
            for (int c = 0; c < N - 1; c++) {
                Tile cur = tiles.get(getTileIdx(N, r, c));

                int nextIdx = getTileIdx(N, r, c - 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.left == next.right) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r, c + 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.right == next.left) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r - 1, c);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.left == next.right) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r - 1, c + 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.right == next.left) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r + 1, c);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.left == next.right) {
                        graph[cur.idx].add(next.idx);
                    }
                }

                nextIdx = getTileIdx(N, r + 1, c + 1);
                if (nextIdx != -1) {
                    Tile next = tiles.get(nextIdx);
                    if (cur.right == next.left) {
                        graph[cur.idx].add(next.idx);
                    }
                }
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        parent[0] = -1;
        steps[0] = 1;
        dq.addLast(0);

        while (!dq.isEmpty()) {
            int curIdx = dq.pollFirst();

            for (int nextIdx : graph[curIdx]) {
                if (steps[nextIdx] != 0) {
                    continue;
                }
                parent[nextIdx] = curIdx;
                steps[nextIdx] = steps[curIdx] + 1;
                dq.addLast(nextIdx);
            }
        }

        // 번호가 큰 타일부터 이동 가능한지 검사
        int endTileIdx = 0;
        for (int i = tileCnt - 1; i >= 0; i--) {
            if (steps[i] != 0) {
                endTileIdx = i;
                break;
            }
        }

        Deque<Integer> path = new ArrayDeque<>();
        int curIdx = endTileIdx;
        while (curIdx != -1) {
            path.addFirst(curIdx);
            curIdx = parent[curIdx];
        }

        bw.write(String.format("%d\n", path.size()));
        for (int tileIdx : path) {
            bw.write(String.valueOf(tileIdx + 1) + " ");
        }
        bw.flush();
    }

    static int getTileIdx(int N, int r, int c) {
        if (r < 0 || r >= N) {
            return -1;
        }

        // 짝수줄
        if ((r & 1) == 0) {
            if (c < 0 || c >= N) {
                return -1;
            }
            return (r + 1) / 2 * N + (r / 2) * (N - 1) + c;
        }
        // 홀수줄
        else {
            if (c < 0 || c >= N - 1) {
                return -1;
            }
            return r * N - (r / 2) + c;
        }
    }

    static class Tile {
        int idx;
        int left, right;

        public Tile(int idx, int left, int right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }
    }
}