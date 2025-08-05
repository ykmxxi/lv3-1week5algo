import java.util.*;
import java.lang.*;
import java.io.*;

// 좋다
// https://www.acmicpc.net/problem/1253
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long arr[] = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int k = 0; k < n; k++) {
            int i = 0;
            int j = n - 1;
            long comparedN = arr[k];
            while (i < j) {
                if (arr[i] + arr[j] == comparedN) {
                    if (i != k && j != k) {
                        cnt++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                } else if (arr[i] + arr[j] > comparedN) {
                    j--;
                } else if (arr[i] + arr[j] < comparedN) {
                    i++;
                }
            }
        }
        System.out.println(cnt);
    }
}
