import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/9518
class Main {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, -1, 0, 1, -1, -1, 0, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        int c = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 'o'){
                    for(int k=0; k<4; k++){
                        int x = dx[k] + i;
                        int y = dy[k] + j;

                        if(!(x >= 0 && x<map.length && y >= 0 && y<map[0].length)) continue;

                        if(map[x][y] == 'o'){
                            c++;
                        }
                    }
                }
            }
        }

        int max = c;
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // 빈자리인 경우
                if(map[i][j] == '.'){
                    map[i][j] = 'o';

                    for(int k=0; k<8; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if(!(x >= 0 && x<map.length && y >= 0 && y<map[0].length)) continue;

                        if(map[x][y] == 'o'){
                            count++;
                        }

                    }
                    max = Math.max(max, c + count);

                    count = 0;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(max);
    }
}
