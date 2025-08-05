import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11657
// 타임머신
public class BOJ11657 {
    static final int MAXN = 500 + 1;
    static final long INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long[] distance = new long[MAXN];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        for (int i = 0, u, v, w; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, w));
        }

        Arrays.fill(distance, INF);
        distance[1] = 0;

        boolean isLoopExist = false;
        for (int i = 0; i < N; i++) {
            for (Edge edge : edges) {
                if (distance[edge.u] == INF) {
                    continue;
                }
                long nextDistance = distance[edge.u] + edge.w;

                if (nextDistance < distance[edge.v]) {
                    if (i == N - 1) {
                        isLoopExist = true;
                        break;
                    }
                    distance[edge.v] = nextDistance;
                }
            }
        }

        if (isLoopExist) {
            bw.write(String.valueOf(-1));
        } else {
            for (int i = 2; i <= N; i++) {
                bw.write(String.format("%d\n", distance[i] == INF ? -1 : distance[i]));
            }
        }

        bw.flush();
    }

    static class Edge {
        int u;
        int v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}