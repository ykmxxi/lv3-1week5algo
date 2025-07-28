import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

// https://www.acmicpc.net/problem/1464
// 뒤집기 3
public class BOJ1464 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        Deque<String> dq = new ArrayDeque<>();
        dq.add(String.valueOf(S.charAt(0)));
        
        int sl = S.length();
        for (int i = 1; i < sl; i++) {

            String s_i = String.valueOf(S.charAt(i));
            if (dq.peekFirst().compareTo(s_i) >= 0) {
                dq.addFirst(s_i);
            } else {
                dq.addLast(s_i);
            }
        }

        bw.write(String.join("", dq));
        bw.flush();
    }
}