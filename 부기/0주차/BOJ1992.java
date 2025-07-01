import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1992
class Main {
    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        search(0, 0, N);
        System.out.println(sb);
    }

    public static void search(int x, int y, int len){
        if(isOk(x, y, len)){
            sb.append(map[x][y]);
            return;
        }

        int half = len / 2;

        sb.append("(");
        search(x, y, half);
        search(x, y + half, half);
        search(x + half, y, half);
        search(x + half, y + half, half);
        sb.append(")");

    }

    public static boolean isOk(int x, int y, int len){
        for(int i=x; i<x + len; i++){
            for(int j=y; j<y + len; j++){
                if(map[x][y] != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
