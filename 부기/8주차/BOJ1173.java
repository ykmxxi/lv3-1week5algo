import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1173
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }

            return o2[0] - o1[0];
        });
        q.add(new int[]{0, 0, m});

        boolean[][] visit = new boolean[201][201];
        while (!q.isEmpty()) {
            int[] now = q.poll();

            visit[now[0]][now[2]] = true;
            if(now[0] == N){
                System.out.println(now[1]);
                return;
            }

            if(now[2] + T <= M && !visit[now[0] + 1][now[2] + T]){
                q.add(new int[]{now[0] + 1, now[1] + 1, now[2] + T});
            }

            int nextM = now[2] - R >= m ? now[2] - R : m;
            if(!visit[now[0]][nextM]){
                q.add(new int[]{now[0], now[1] + 1, nextM});
            }
        }

        System.out.println(-1);

    }
}
