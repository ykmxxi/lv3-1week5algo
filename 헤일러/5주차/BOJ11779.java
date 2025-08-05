import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/11779
// 최소비용 구하기 2
public class BOJ11779 {
    static final int MAXN = 1000 + 1;
    static final int INF = Integer.MAX_VALUE / 2 - 1;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[] distance = new int[MAXN];
    static boolean[] visited = new boolean[MAXN];
    static int[] parent = new int[MAXN];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Edge>[] graph = new ArrayList[MAXN];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0, u, v, w; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            graph[u].add(new Edge(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int sourceIdx = Integer.parseInt(st.nextToken());
        int sinkIdx = Integer.parseInt(st.nextToken());

        Arrays.fill(distance, INF);
        Arrays.fill(parent, -1);
        distance[sourceIdx] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (u, v) -> u.dis - v.dis
        );
        pq.offer(new Node(sourceIdx, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.idx == sinkIdx) {
                break;
            }
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
                    parent[nextIdx] = cur.idx;
                    distance[nextIdx] = nextDistance;
                    pq.offer(new Node(nextIdx, nextDistance));
                }
            }
        }

        Deque<Integer> trace = new ArrayDeque<>();
        int curIdx = sinkIdx;
        while (curIdx != -1) {
            trace.addFirst(curIdx);
            curIdx = parent[curIdx];
        }

        bw.write(String.format("%d\n", distance[sinkIdx]));
        bw.write(String.format("%d\n", trace.size()));
        bw.write(
                trace.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
        );
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