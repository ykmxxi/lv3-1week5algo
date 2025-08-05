import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11404
// 플로이드
public class BOJ11404 {
    static final int MAXN = 1000;
    static final int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] distance = new int[MAXN][MAXN];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for (int i = 0, u, v, w; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken()) - 1;
            v = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken());
            distance[u][v] = Math.min(distance[u][v], w);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int candidate = distance[i][k] + distance[k][j];
                    if (candidate < distance[i][j]) {
                        distance[i][j] = candidate;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(String.format("%d ", distance[i][j] == INF ? 0 : distance[i][j]));
            }
            bw.write("\n");
        }

        bw.flush();
    }
}