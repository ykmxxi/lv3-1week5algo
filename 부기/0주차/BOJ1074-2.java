import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1074
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(search(0, 0, 1 << N, R, C));
    }

    public static int search(int x, int y, int len, int R, int C){
        if(len == 1){
            return 0;
        }

        int half = len / 2;
        int size = half * half;

        // 1 사분면
        if(R < x + half && C < y + half){
            return search(x, y, half, R, C);
        }
        // 2 사분면
        else if(R < x + half && C >= y + half){
            return size + search(x, y + half, half, R, C);
        }
        // 3 사분면
        else if(R >= x + half && C < y + half){
            return 2 * size + search(x + half, y, half, R, C);
        }
        // 4 사분면
        else {
            return 3 * size + search(x + half, y + half, half, R, C);
        }
    }
}
