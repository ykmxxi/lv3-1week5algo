import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2504
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int c = 0;
        for(int i=0; i<N; i++){
            char[] values = br.readLine().toCharArray();

            if(values.length % 2 != 0) continue;

            if(isOk(values)){
                c++;
            }
        }
        System.out.println(c);
    }

    public static boolean isOk(char[] values){
        Deque<Character> q = new ArrayDeque<>();

        for(int i=0; i<values.length; i++){
            char now = values[i];

            if(q.isEmpty()) q.addLast(now);
            else if(q.peekLast() == now){
                q.pollLast();
            }
            else {
                q.addLast(now);
            }
        }

        return q.isEmpty();
    }

}
