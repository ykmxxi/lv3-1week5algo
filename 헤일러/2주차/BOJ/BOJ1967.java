import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1967 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        // 지름 노드 1개 탐색
        calcDistances(1,
                visited, distance, graph);
        int maxIdx = 1;
        for (int i = 2; i <= n; i++) {
            if (distance[maxIdx] < distance[i]) {
                maxIdx = i;
            }
        }

        // 나머지 1개 탐색
        Arrays.fill(visited, 1, n + 1, false);
        Arrays.fill(distance, 1, n + 1, 0);
        calcDistances(maxIdx,
                visited, distance, graph);
        int ans = Arrays.stream(distance)
                .max()
                .getAsInt();

        bw.write(String.format("%d", ans));
        bw.flush();
    }

    private static void calcDistances(int idx,
                                      boolean[] visited, int[] distance, List<Edge>[] graph) {
        if (visited[idx]) {
            return;
        }

        visited[idx] = true;
        for (Edge nextEdge : graph[idx]) {
            if (visited[nextEdge.to]) {
                continue;
            }
            distance[nextEdge.to] = distance[idx] + nextEdge.w;
            calcDistances(nextEdge.to,
                    visited, distance, graph);
        }
    }

    static class Edge {
        int to;
        int w; // < 100

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }
}