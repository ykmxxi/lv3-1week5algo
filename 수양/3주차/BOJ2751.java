import java.io.*;
import java.util.*;

// 수 정렬하기 2
// https://www.acmicpc.net/problem/2751
public class BOJ2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){
            sb.append(arr[i] + "\n");
        }
        System.out.println(sb.toString());
    }    
}
