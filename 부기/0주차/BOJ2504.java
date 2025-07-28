import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2504
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] values = br.readLine().toCharArray();

        Deque<Character> q = new ArrayDeque<>();
        if(!isOk(q, values)){
            System.out.println(0);
            return;
        }

        int[] c = new int[2];
        int answer = 0;
        for(int i=0; i<values.length; i++){
            char now = values[i];
            if(now == '(' || now == '['){
                c[now == '(' ? 0 : 1]++;
                q.addLast(now);
            }
            else if(i > 0 && now == ')' && values[i-1] == '('){
                c[0]--;
                q.pollLast();
                // 분배법칙을 활용해서 현재까지 열린 괄호의 수를 먼저 곱해서 더해버린다.
                // 만약 ((가 열려있다면 2를 두번 곱한다.
                // 만약 [[[[가 열려있다면 3을 4번 곱한다.
                answer += 2 * (c[0] > 0 ? Math.pow(2, c[0]) : 1) * (c[1] > 0 ? Math.pow(3, c[1]) : 1);
            }
            else if(i > 0 && now == ']' && values[i-1] == '['){
                c[1]--;
                q.pollLast();
                answer += 3 * (c[0] > 0 ? Math.pow(2, c[0]) : 1) * (c[1] > 0 ? Math.pow(3, c[1]) : 1);
            }
            else if((now == ')' && q.peekLast() == '(') || (now == ']' && q.peekLast() == '[')){
                q.pollLast();
                c[now == ')' ? 0 : 1]--;
            }
        }
        System.out.println(answer);
    }

    public static boolean isOk(Deque<Character> q, char[] values){

        for(int i=0; i<values.length; i++){
            char now = values[i];
            if(now == '(' || now == '['){
                q.addLast(now);
            }
            else if(!q.isEmpty() && ((now == ')' && q.peekLast() == '(') ||
                    (now == ']' && q.peekLast() == '['))){
                q.pollLast();
            }
            // 위의 경우를 제외한 값이 나오면 비정상 입력 ex) ]
            else{
                return false;
            }
        }

        // 위의 로직을 모두 수행하고도 비어있지 않는다면 비정상 입력
        return q.isEmpty();
    }
}
