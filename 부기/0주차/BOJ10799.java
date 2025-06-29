import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/10799
class Main {
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] values = br.readLine().toCharArray();

        Deque<Character> q = new ArrayDeque<>();

        int answer = 0;
        for(int i=0; i<values.length; i++){
            char now = values[i];

            if(now == '('){
                q.addLast(now);
            }
            else{
                q.pollLast();
                if(values[i-1] == '('){
                    // 현재 중첩되어 있는 쇠막대기 수
                    answer += q.size();
                }
                else {
                    // 현재 쇠막대기 (+1)
                    answer++;
                }
            }
        }

        // 쇠막대기의 개수는 (쇠막대기 내부에 있는 레이저 + 1)
        System.out.println(answer);
    }
}
