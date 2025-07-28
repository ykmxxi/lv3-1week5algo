import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

// 커트라인
// https://www.acmicpc.net/problem/25305
public class BOJ25305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());      
        int arr[] = new int[n];  
        int i = 0;
        while(st.hasMoreTokens()){
            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length - k]);
    }
}
