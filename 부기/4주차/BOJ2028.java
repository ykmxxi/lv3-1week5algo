import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2028
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());

            sb.append(
                    String.valueOf((int)Math.pow(a, 2)).endsWith(String.valueOf(a)) ? "YES" : "NO"
            ).append("\n");
        }

        System.out.println(sb);
    }
}
