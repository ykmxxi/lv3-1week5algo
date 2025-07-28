import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1759
class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] values = br.readLine().split(" ");
        Arrays.sort(values);
        dfs(values, new boolean[M], 0, 0, "", 0, 0);

        System.out.println(sb);
    }

    public static void dfs(String[] values, boolean[] visit, int now, int depth, String val, int c1, int c2){
        if(N - depth > values.length - now){
            return;
        }

        if(depth == N){
            if(c1 < 1 || c2 < 2) return;
            sb.append(val).append("\n");
            return;
        }

        for(int i=now; i<values.length; i++){
            if(!visit[i]){
                boolean is모음 = is모음(values[i]);
                visit[i] = true;
                dfs(values, visit, i, depth + 1, val + values[i], c1 + (is모음 ? 1 : 0), c2 + (is모음 ? 0 : 1));
                visit[i] = false;
            }
        }
    }

    public static boolean is모음(String val){
        return val.equals("a") || val.equals("e") || val.equals("i") ||
            val.equals("o") || val.equals("u");
    }
}
