package BOJ;

import java.util.*;
import java.lang.*;
import java.io.*;

class BOJ9517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> people = new ArrayDeque<>();
        for (int i = k - 1; i < (k + 7); i++) {
            people.add(1 + (i % 8));
        }

        int time = 210;
        Integer person = people.pollFirst();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int timeTaken = Integer.parseInt(st.nextToken());
            String state = st.nextToken();

            time -= timeTaken;

            if (time <= 0) {
                System.out.println(person);
                return;
            }

            if (state.equals("T")) {
                people.addLast(person);
                person = people.pollFirst();
            }
        }
    }
}
