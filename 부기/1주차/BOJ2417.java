import java.util.*;
import java.lang.*;
import java.io.*;


// https://www.acmicpc.net/problem/2417
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long answer = binarySearch(N);

        System.out.println(answer);
    }

    public static long binarySearch(Long N){
        long l = 0;
        long h = N-1;

        long mid;

        while(l <= h){
            mid = (l + h) / 2;

            if(Math.pow(mid, 2) < N){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
}
