import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2439
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=N-1; i>=0; i--){
            sb.append(" ".repeat(i)).append("*".repeat(N - i)).append("\n");
        }
        System.out.println(sb);
    }
}
