import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/11729
class Main {
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        move(N, 1, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void move(int now, int from, int to){
        if(now == 0) return;

        if(now == 1){
            count++;
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        int empty = from + to == 4 ? 2 : (from + to) % 4;

        move(now-1, from, empty);
        move(1, from, to);
        move(now-1, empty, to);
    }
}
