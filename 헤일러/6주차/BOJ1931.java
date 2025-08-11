import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1931
// 회의실 배정
// 카테고리: Greedy
public class BOJ1931 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.add(new Node(start, end));
        }

        nodes.sort((n1, n2) -> {
                    if (n1.end != n2.end) {
                        return n1.end - n2.end;
                    }
                    return n1.start - n2.start;
                }
        );
        int ans = 1;
        int currentEnd = nodes.get(0).end;
        for (int i = 1; i < nodes.size(); i++) {
            Node currentNode = nodes.get(i);
            if (currentEnd <= currentNode.start) {
                currentEnd = currentNode.end;
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
