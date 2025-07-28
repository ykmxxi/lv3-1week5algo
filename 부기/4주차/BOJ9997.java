import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/9997
class Main {
    static int isPossible = (1 << 26) - 1;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] values = new int[N];
        for(int i=0; i<N; i++){
            values[i] = calculate(br.readLine());
        }

        dfs(values, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int[] values, int now, int visit){
        if(visit == isPossible){
            answer++;
        }

        for(int i=now; i<values.length; i++){
            dfs(values, i+1, visit | values[i]);
        }

    }

    public static int calculate(String value){
        char[] v = value.toCharArray();
        int visit = 0;
        for(int i=0; i < v.length; i++){
            int c = v[i] - 'a';
            visit = visit | (1 << c);
        }
        return visit;
    }
}
