import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2636
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        int last = 0;
        int depth = 0;
        while (true) {
            int c = BFS(map);

            if(c == 0){
                break;
            }
            last = c;
            depth++;
        }

        System.out.println(depth);
        System.out.println(last);

    }

    public static int BFS(int[][] map){
        Deque<Point> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];

        q.addFirst(new Point(0, 0));
        visit[0][0] = true;
        int c = 0;

        while (!q.isEmpty()) {
            Point now = q.pollFirst();

            if(map[now.x][now.y] == 1){
                map[now.x][now.y] = 0;
                c++;
                continue;
            }

            for(int i=0; i<4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if(!(x >= 0 && x < N && y >= 0 && y < M)) continue;

                if(map[now.x][now.y] == 0 && !visit[x][y]){
                    visit[x][y] = true;
                    q.addLast(new Point(x, y));
                }
            }



        }

        return c;
    }


    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
}
