import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1726
class Main {
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};
    static boolean[][][] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        visit = new boolean[N][M][5];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int dir = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int tx = Integer.parseInt(st.nextToken()) - 1;
        int ty = Integer.parseInt(st.nextToken()) - 1;
        int tdir = Integer.parseInt(st.nextToken());

        System.out.println(bfs(x, y, dir, tx, ty, tdir, map));
    }

    public static int bfs(int x, int y, int dir, int tx, int ty, int tdir, int[][] map){
        Deque<Robot> q = new ArrayDeque<>();

        q.add(new Robot(x, y, dir, 0));

        while (!q.isEmpty()) {
            Robot now = q.pollFirst();

            if(now.x == tx && now.y == ty && now.dir == tdir){
                return now.depth;
            }

            if(now.canLeft()){
                Robot next = now.left();
                q.addLast(next);
                visit[next.x][next.y][next.dir] = true;
            }
            if(now.canRight()){
                Robot next = now.right();
                q.addLast(next);
                visit[next.x][next.y][next.dir] = true;
            }
            for(int i=1; i<=3; i++){
                if(now.canGo(i, map)){
                    Robot next = now.go(i);
                    q.addLast(next);
                    visit[next.x][next.y][next.dir] = true;
                }
            }


        }
        return -1;

    }

    public static class Robot{
        int x;
        int y;
        int dir;
        int depth;

        public Robot(int x, int y, int dir, int depth){
            this.x=x;
            this.y=y;
            this.dir=dir;
            this.depth = depth;
        }

        public Robot left(){
            if(dir == 1) return new Robot(x, y, 4, depth + 1);
            else if(dir == 2) return new Robot(x, y, 3, depth + 1);
            else if(dir == 3) return new Robot(x, y, 1, depth + 1);
            else return new Robot(x, y, 2, depth + 1);
        }

        public Robot right(){
            if(dir == 1) return new Robot(x, y, 3, depth + 1);
            else if(dir == 2) return new Robot(x, y, 4, depth + 1);
            else if(dir == 3) return new Robot(x, y, 2, depth + 1);
            else return new Robot(x, y, 1, depth + 1);
        }

        public Robot go(int l){
            return new Robot(nextX(l), nextY(l), dir, depth + 1);
        }

        public boolean canGo(int l, int[][] map){
            int nextX = x;
            int nextY = y;

            for(int i=1; i<=l; i++){
                nextX += dx[dir];
                nextY += dy[dir];

                if(!(nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[0].length)) return false;
                if(map[nextX][nextY] == 1) return false;
            }

            return !visit[nextX][nextY][dir];
        }

        public boolean canLeft(){
            int nextDir = 0;
            if(dir == 1) nextDir = 4;
            else if(dir == 2) nextDir = 3;
            else if(dir == 3) nextDir = 1;
            else nextDir = 2;

            return !visit[x][y][nextDir];
        }

        public boolean canRight(){
            int nextDir = 0;
            if(dir == 1) nextDir = 3;
            else if(dir == 2) nextDir = 4;
            else if(dir == 3) nextDir = 2;
            else nextDir = 1;

            return !visit[x][y][nextDir];
        }

        private int nextX(int l){
            return x + dx[dir] * l;
        }

        private int nextY(int l){
            return y + dy[dir] * l;
        }

    }

}
