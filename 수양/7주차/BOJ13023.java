
import java.util.*;
import java.lang.*;
import java.io.*;

// ABCDE
// https://www.acmicpc.net/problem/13023
class BOJ13023 {

    static int n;
    static boolean visited[];
    static boolean answer;
    static List<List<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<Integer>());
        }

        // m의 횟수대로 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        // dfs
        for (int i = 0; i < arr.size(); i++) {
            dfs(1, i);
        }

        if (answer == true) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }

    public static void dfs(int depth, int node) {
        if (visited[node] || answer == true) {
            return;
        }
        if (depth >= 5) {
            answer = true;
            return;
        }
        visited[node] = true;
        for (int i = 0; i < arr.get(node).size(); i++) {
            dfs(depth + 1, arr.get(node).get(i));
        }
        visited[node] = false;
    }
}