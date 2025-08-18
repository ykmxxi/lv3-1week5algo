import java.util.*;
import java.lang.*;
import java.io.*;

// 연결 요소의 개수
// https://www.acmicpc.net/problem/11724
class BOJ11724 {

    static boolean visited[];
    static List<List<Integer>> arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            visited[i] = false;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i] == true) {
                continue;
            }
            answer++;
            dfs(i);
        }
        System.out.println(answer);
    }

    public static void dfs(int node) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i = 0; i < arr.get(node).size(); i++) {
            if (visited[arr.get(node).get(i)] == false) {
                dfs(arr.get(node).get(i));
            }
        }
    }
}
