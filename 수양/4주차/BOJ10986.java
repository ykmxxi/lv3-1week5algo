import java.util.*;
import java.lang.*;
import java.io.*;

// 나머지 합
// https://www.acmicpc.net/problem/10986
class BOJ10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];
        long sum[] = new long[k];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            int re = (int) (arr[i] % k);
            if (re == 0) {
                answer++;
            }
            sum[re]++;
        }
        for (int i = 0; i < k; i++) {
            if (sum[i] > 1) {
                answer += (sum[i] * (sum[i] - 1) / 2);
            }
        }
        System.out.println(answer);
    }
}