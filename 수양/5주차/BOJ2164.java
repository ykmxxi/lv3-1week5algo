import java.util.*;
import java.lang.*;
import java.io.*;

// 카드2
// https://www.acmicpc.net/problem/2164
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = n; i > 0; i--) {
            q.push(i);
        }
        int lastE = 0;
        while (!q.isEmpty()) {
            lastE = q.pop();
            if (!q.isEmpty()) {
                int newOne = q.pop();
                q.addLast(newOne);
            }
        }
        System.out.println(lastE);
    }
}