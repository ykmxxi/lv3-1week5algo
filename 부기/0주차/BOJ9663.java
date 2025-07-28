import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/9663
class Main {
    static int N;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        dfs(0, new boolean[N], new boolean[2 * N], new boolean[2 * N]);

        System.out.println(answer);
    }

    public static void dfs(int row, boolean[] col, boolean[] dia1, boolean[] dia2){
        if(row == N-1){
            for(int i=0; i<N; i++){
                int di1 = row + i;
                int di2 = row - i + N - 1;

                if(!col[i] && !dia1[di1] && !dia2[di2]){
                    answer++;
                }
            }
            return;
        }


        for(int i=0; i<N; i++){
            int di1 = row + i;
            int di2 = row - i + N - 1;

            if(!col[i] && !dia1[di1] && !dia2[di2]){
                col[i] = true;
                dia1[di1] = true;
                dia2[di2] = true;
                dfs(row + 1, col, dia1, dia2);
                col[i] = false;
                dia1[di1] = false;
                dia2[di2] = false;
            }

        }
    }
}
