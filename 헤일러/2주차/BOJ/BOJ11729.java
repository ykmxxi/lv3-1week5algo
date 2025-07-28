import java.io.*;

// https://www.acmicpc.net/problem/11729
// 하노이 탑 이동 순서
// println은 매우 느리다. 출력을 나누어 해야할 때는 무조건 BufferedWriter를 사용할 것.
public class BOJ11729 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int cnt = 0;


    static void dfs(int n, int src, int mid, int dst) throws IOException {
        if(n == 1) {
            bw.write(String.format("%d %d\n", src, dst));
            return;
        }
        dfs(n-1, src, dst, mid);
        bw.write(String.format("%d %d\n", src, dst));
        dfs(n-1, mid, src, dst);

    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        bw.write(String.format("%d\n", (1<<N)-1));

        dfs(N, 1, 2, 3);
        bw.flush();
    }
}