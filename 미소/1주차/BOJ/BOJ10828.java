import java.io.*;
import java.util.*;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            stack(deque, br.readLine());
        }
    }

    public static void stack(Deque<Integer> deque, String command) {
        if (command.equals("pop")) {
            Integer integer = deque.poll();
            if (integer == null) {
                System.out.println(-1);
            } else {
                System.out.println(integer);
            }
        } else if (command.equals("size")) {
            System.out.println(deque.size());
        } else if (command.equals("empty")) {
            if (deque.isEmpty()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (command.equals("top")) {
            Integer integer = deque.pollFirst();
            if (integer != null) {
                System.out.println(integer);
                deque.addFirst(integer);
            } else {
                System.out.println(-1);
            }
        } else {
            StringTokenizer st = new StringTokenizer(command);
            st.nextToken();
            deque.addFirst(Integer.parseInt(st.nextToken()));
        }
    }
}
