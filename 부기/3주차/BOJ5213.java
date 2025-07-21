import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/5213

// 1. 한 타일에서 다른 타일로 넘어가려면, 두 타일이 인접해야 한다.
//    또, 같은 변을 공유하는 조각에 쓰여 있는 숫자가 같아야 한다.
// 2. 도미노 타일은 두 조각으로 나누어져있다.
class Main {
    static int[][] map;
    static int[][] path;
    static int tile;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;
    static int maxDepth = 0;
    static String maxPath;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N * 2];
        path = new int[N][N * 2];

        int size = N*N - (N / 2);
        int now = 2;
        int x = 0;
        int y = 0;
        tile = 0;

        StringTokenizer st;
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tile++;
            map[x][y] = a;
            path[x][y++] = tile;
            map[x][y] = b;
            path[x][y++] = tile;

            if(now == 2 && y == N * 2){
                x++;
                y=1;
                now=1;
            }
            else if(now == 1 && y == N * 2 - 1){
                x++;
                y=0;
                now=2;
            }

        }

        bfs();
    }

    public static void bfs(){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            return o1.depth - o2.depth;
        });
        boolean[][] visit = new boolean[map.length][map[0].length];

        q.add(new Node(0, 0, 1, "1"));

        while(!q.isEmpty()){
            Node now = q.poll();
            if(visit[now.x][now.y]) continue;

            visit[now.x][now.y] = true;

            if(path[now.x][now.y] == tile){
                System.out.println(now.depth);
                System.out.println(now.p);
                return;
            }
            if(path[now.x][now.y] >= max){
                max = path[now.x][now.y];
                maxDepth = now.depth;
                maxPath = now.p;
            }

            for(int i=0; i<4; i++){
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if(!(x >= 0 && x < map.length && y >= 0 && y<map[0].length) || map[x][y] == 0) continue;


                if(!visit[x][y] && (path[now.x][now.y] == path[x][y] || map[now.x][now.y] == map[x][y])){
                    String next = path[now.x][now.y] == path[x][y] ? now.p : now.p + " " + path[x][y];
                    int nextDepth = path[now.x][now.y] == path[x][y] ? now.depth : now.depth + 1;
                    q.add(new Node(x, y, nextDepth, next));
                }
            }
        }



        System.out.println(maxDepth);
        System.out.println(maxPath);
    }


    public static class Node{
        int x;
        int y;
        int depth;
        String p;

        public Node(int x, int y, int depth, String p){
            this.x=x;
            this.y=y;
            this.depth=depth;
            this.p=p;
        }
    }
}
