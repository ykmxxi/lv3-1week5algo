import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2250
// 트리의 높이와 너비
public class BOJ2250 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int MAXN = 10_000;
    static int colCnt = 0;
    static int[] colIdx = new int[MAXN + 1];
    static int[] level = new int[MAXN + 1];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        boolean[] hasParent = new boolean[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int lidx = Integer.parseInt(st.nextToken());
            int ridx = Integer.parseInt(st.nextToken());

            graph[idx].add(lidx);
            graph[idx].add(ridx);

            if (lidx != -1) {
                hasParent[lidx] = true;
            }
            if (ridx != -1) {
                hasParent[ridx] = true;
            }
        }

        // find root
        int root = 1;
        for (int i = 1; i <= N; i++) {
            if (!hasParent[i]) {
                root = i;
                break;
            }
        }

        // calculate level, colIdx
        dfs(root, 1, graph);

        // 레벨 별 가장 좌측, 우측 합 계산
        int[] minleftSum = new int[N + 1];
        int[] minRightSum = new int[N + 1];
        Arrays.fill(minleftSum, 0, N + 1, Integer.MAX_VALUE);
        Arrays.fill(minRightSum, 0, N + 1, Integer.MAX_VALUE);

        int maxLevel = 1;
        for (int i = 1; i <= N; i++) {
            minleftSum[level[i]] = Math.min(minleftSum[level[i]], colIdx[i] - 1);
            minRightSum[level[i]] = Math.min(minRightSum[level[i]], N - colIdx[i]);

            maxLevel = Math.max(maxLevel, level[i]);
        }
        
        int ansLevel = 1;
        int maxWidth = N - (minleftSum[1] + minRightSum[1]);
        for (int lv = 2; lv <= maxLevel; lv++) {
            int width = N - (minleftSum[lv] + minRightSum[lv]);
            if (width > maxWidth) {
                ansLevel = lv;
                maxWidth = width;
            }
        }

        bw.write(String.format("%d %d", ansLevel, maxWidth));
        bw.flush();
    }

    static void dfs(int idx, int lv,
                    final List<Integer>[] graph) {
        if (idx == -1) {
            return;
        }
        level[idx] = lv;

        int lidx = graph[idx].get(0);
        int ridx = graph[idx].get(1);

        dfs(lidx, lv + 1, graph);
        colIdx[idx] = ++colCnt;
        dfs(ridx, lv + 1, graph);
    }
}