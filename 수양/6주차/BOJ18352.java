
import java.awt.print.Pageable;
import java.util.*;
import java.lang.*;
import java.io.*;

//  특정 거리의 도시 찾기
// https://www.acmicpc.net/problem/18352
class BOJ18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(f).add(b);
        }
        int answer[] = new int[n + 1];
        boolean visitied[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            answer[i] = 399_999_999;
            visitied[i] = false;
        }
        for (int i = 0; i < arr.get(x).size(); i++) {
            dfs(answer, visitied, arr, arr.get(x).get(i), k, 1);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (answer[i] == k) {
                sb.append(i + "\n");
                cnt++;
            }
        }
        if (cnt == 0) {
            System.out.println("-1");
            return;
        }
        System.out.println(sb);
    }

    public static void dfs(int[] answer, boolean[] visited, List<List<Integer>> arr, int node, int k, int depth) {
        if (depth > k) {
            return;
        }
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        answer[node] = Math.min(answer[node], depth);
        for (int i = 0; i < arr.get(node).size(); i++) {
            dfs(answer, visited, arr, arr.get(node).get(i), k, depth + 1);
        }
    }
}
