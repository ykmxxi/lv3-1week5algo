import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 문자열 폭발
public class BOJ9935 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bombStr = br.readLine();

        int n = str.length();
        int m = bombStr.length();
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Character> dq2 = new ArrayDeque<>();

        int j;
        for (int i = 0; i < n; i++) {
            j = dq.isEmpty() ? 0 : dq.peekLast();

            char now = str.charAt(i);
            char patternChar = bombStr.charAt(j);
            if (now == patternChar) {
                j++;
            } else {
                if (now == bombStr.charAt(0)) {
                    j = 1;
                } else {
                    j = 0;
                }
            }
            dq.addLast(j);
            dq2.addLast(now);

            if (j == m) {
                for (int cnt = 0; cnt < m; cnt++) {
                    dq.pollLast();
                    dq2.pollLast();
                }
            }
        }

        if (dq.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : dq2) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
