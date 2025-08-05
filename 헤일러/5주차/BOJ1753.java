import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1753
// 최단경로
public class BOJ1753 {
    static final int MAXN = 20_000 + 1;
    static final int INF = Integer.MAX_VALUE / 2 - 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] distance = new int[MAXN];
    static boolean[] visited = new boolean[MAXN];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int sourceIdx = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[MAXN];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0, u, v, w; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        Arrays.fill(distance, INF);
        distance[sourceIdx] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (u, v) -> u.dis - v.dis
        );
        pq.offer(new Node(sourceIdx, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.idx]) {
                continue;
            }
            visited[cur.idx] = true;

            for (Edge edge : graph[cur.idx]) {
                int nextIdx = edge.to;
                if (visited[nextIdx]) {
                    continue;
                }

                int nextDistance = cur.dis + edge.w;
                if (distance[nextIdx] > nextDistance) {
                    distance[nextIdx] = nextDistance;
                    pq.offer(new Node(nextIdx, nextDistance));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            bw.write(
                    String.format("%s\n",
                            distance[i] == INF ? "INF" : distance[i])
            );
        }
        bw.flush();
    }

    static class Edge {
        int to;
        int w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static class Node {
        int idx;
        int dis;

        public Node(int idx, int dis) {
            this.idx = idx;
            this.dis = dis;
        }
    }
}