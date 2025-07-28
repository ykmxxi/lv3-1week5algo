import java.util.*;
import java.lang.*;
import java.io.*;

//  구간 합 구하기 5
// https://www.acmicpc.net/problem/11660
class BOJ11550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[(n + 1) * (n + 1)];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                if (x == 0) {
                    arr[y * n + x] = Integer.parseInt(st.nextToken());
                } else {
                    arr[y * n + x] = arr[y * n + x - 1] + Integer.parseInt(st.nextToken());
                }
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken()) - 1;
            int startX = Integer.parseInt(st.nextToken()) - 1;
            int endY = Integer.parseInt(st.nextToken()) - 1;
            int endX = Integer.parseInt(st.nextToken()) - 1;
            int sum = 0;
            for (int y = startY; y <= endY; y++) {
                if (startX == 0) {
                    sum += arr[y * n + endX];
                } else {
                    sum += arr[y * n + endX] - arr[y * n + startX - 1];
                }
            }
            System.out.println(sum);
        }
    }
}
