import java.util.*;
import java.lang.*;
import java.io.*;

// N과 M (1)
// https://www.acmicpc.net/problem/15649
class BOJ15649 {

    static boolean visit[];
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visit = new boolean[n + 1];

        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
            visit[i] = true;
            dfs(arr);
            visit[i] = false;
            arr.remove(0);
        }
    }

    public static void dfs(List<Integer> arr) {
        if (arr.size() == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.size(); i++) {
                sb.append(arr.get(i) + " ");
            }
            System.out.println(sb.toString());
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            arr.add(i);
            dfs(arr);
            arr.remove(arr.size() - 1);
            visit[i] = false;
        }
    }
}