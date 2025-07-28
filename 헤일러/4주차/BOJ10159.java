import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10159
// 저울
public class BOJ10159 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int MAXN = 100;
    static int[] sum = new int[MAXN];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[MAXN];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u - 1].add(v - 1);
        }

        boolean[] visited = new boolean[MAXN];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            visited[i] = true;
            sum[i] += dfs(i, graph, visited);
        }

        for (int i = 0; i < N; i++) {
            bw.write(String.format("%d\n", N - 1 - sum[i]));
        }
        bw.flush();
    }

    static int dfs(int idx, final List<Integer>[] graph, final boolean visited[]) {
        int ret = 0;
        for (int nextIdx : graph[idx]) {
            if (visited[nextIdx]) {
                continue;
            }

            visited[nextIdx] = true;
            sum[nextIdx]++;
            ret += dfs(nextIdx, graph, visited) + 1;
        }
        return ret;
    }
}