import java.util.*;
import java.io.*;

// 수 정렬하기
// https://www.acmicpc.net/problem/2750
public class BOJ2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];

        int idx = 0;
        while (n-- > 0) {
            arr[idx] = Integer.parseInt(br.readLine());
            idx++;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}