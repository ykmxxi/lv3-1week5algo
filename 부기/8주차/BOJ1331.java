import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1331
class Main {
    static int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] dy = {-1, 1, -1, 1, 2, 2, -2, -2};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] map = new boolean[6][6];

        char[] now = br.readLine().toCharArray();
        char[] first = {now[0], now[1]};
        map[now[0] - 'A'][now[1] - '1'] = true;

        for(int i=0; i<35; i++){
            char[] next = br.readLine().toCharArray();

            boolean isValid = false;
            for(int k=0; k<dx.length; k++){
                int x = (now[0] - 'A') + dx[k];
                int y = (now[1] - '1') + dy[k];

                if(!(x >= 0 && x < map.length && y>=0 && y <map[0].length)) continue;

                if(x == (next[0] - 'A') && y == (next[1] - '1')){
                    isValid = true;
                    break;
                }
            }

            if(!isValid){
                System.out.println("Invalid");
                return;
            }

            map[next[0] - 'A'][next[1] - '1'] = true;
            now[0] = next[0];
            now[1] = next[1];
        }

        boolean isValid = false;
        for(int k=0; k<dx.length; k++){
            int x = (now[0] - 'A') + dx[k];
            int y = (now[1] - '1') + dy[k];

            if(!(x >= 0 && x < map.length && y>=0 && y <map[0].length)) continue;

            if(x == (first[0] - 'A') && y == (first[1] - '1')){
                isValid = true;
                break;
            }
        }
        if(!isValid){
            System.out.println("Invalid");
            return;
        }

        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(!map[i][j]){
                    System.out.println("Invalid");
                    return;
                }
            }
        }

        System.out.println("Valid");
    }

    // F 08 11 22 29 02 13
    // E 23 30 09 12 21 28
    // D 10 07 34 01 14 03
    // C 33 24 31 18 27 20
    // B 06 17 26 35 04 15
    // A 25 32 05 16 19 36
    //
}
