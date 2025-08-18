import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/21736
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        int x = 0;
        int y = 0;
        for(int i=0; i<N; i++){
            char[] value = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(value[j] == 'I'){
                    x = i;
                    y = j;
                }
                map[i][j] = value[j];
            }
        }

        int answer = bfs(map, x, y);
        System.out.println(answer == 0 ? "TT" : answer);
    }



    public static int bfs(char[][] map, int x, int y){
        Deque<int[]> q = new ArrayDeque<>();

        boolean[][] visit = new boolean[map.length][map[0].length];
        visit[x][y] = true;

        q.addLast(new int[]{x, y});

        int answer = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0; i<4; i++){
                int X = now[0] + dx[i];
                int Y = now[1] + dy[i];

                if(X < 0 || X >= map.length || Y < 0 || Y >= map[0].length) continue;

                if(map[X][Y] == 'X' || visit[X][Y]) continue;
                else if (map[X][Y] == 'P') answer++;

                visit[X][Y] = true;
                q.addLast(new int[]{X, Y});
            }

        }
        return answer;
    }
}
