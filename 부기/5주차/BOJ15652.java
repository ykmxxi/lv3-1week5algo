import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/15652
class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        dfs(N, M, 1, 0, "");
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int now, int depth, String val){
        if(M == depth){
            sb.append(val).append("\n");
            return;
        }

        for(int i=now; i<=N; i++){
            dfs(N, M, i, depth + 1, val + i + " ");
        }
    }
}
