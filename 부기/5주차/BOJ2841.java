import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2841
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer>[] s = new Deque[7];
        for(int i=1; i<=6; i++){
            s[i] = new ArrayDeque<>();
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(s[a].isEmpty()){
                answer++;
                s[a].addLast(b);
            } else if(s[a].peekLast() < b){
                answer++;
                s[a].addLast(b);
            } else {
                while (!s[a].isEmpty() && s[a].peekLast() > b) {
                    answer++;
                    s[a].pollLast();
                }
                if(s[a].isEmpty() || s[a].peekLast() < b){
                    answer++;
                    s[a].addLast(b);
                }
            }
        }

        System.out.println(answer);

    }
}
