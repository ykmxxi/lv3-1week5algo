import java.util.*;
import java.lang.*;
import java.io.*;

// 절댓값 힙
// https://www.acmicpc.net/problem/11286
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> arr = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) {
                // 양수->a>b
                // 같음->a==b
                // 음수->a<b
                return a > b ? 1 : -1;
            } else {
                return absA - absB;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                if (arr.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(arr.poll() + "\n");
                }
            } else {
                arr.add(a);
            }
        }
        System.out.println(sb.toString());
    }
}
