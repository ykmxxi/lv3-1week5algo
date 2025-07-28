import java.util.*;
import java.io.*;

// 평균
// https://www.acmicpc.net/problem/1546
public class BOJ1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        Arrays.sort(arr);
        int max = arr[n - 1];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] / max * 100;
        }
        System.out.println(sum / n);
    }
}