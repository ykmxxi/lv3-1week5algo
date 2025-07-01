import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1780
class Main {
    static int[] answer = new int[3];
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        search(0, 0, N);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }

    public static void search(int x, int y, int len){

        boolean flag = true;
        for(int i=x; i<x + len && flag; i++){
            for(int j=y; j<y + len && flag; j++){
                if(map[i][j] != map[x][y]){
                    flag = false;
                }
            }
        }

        if(flag) {
            answer[map[x][y]]++;
            return;
        }

        for(int i=x; i<x + len; i += len / 3){
            for(int j=y; j<y + len; j += len / 3){
                search(i, j, len / 3);
            }
        }
    }
}
