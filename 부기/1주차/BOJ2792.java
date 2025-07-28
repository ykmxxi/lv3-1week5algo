import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2792
class BOJ2792 {
    static List<Long> list = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long max = 0;
        for(int i = 0; i<M ;i++){
            long now = Long.parseLong(br.readLine());
            list.add(now);
            max += now;
        }

        System.out.println(binarySearch(max));
    }

    public static long binarySearch(long max){
        long l = 1;
        long h = max;

        long mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(!check(mid)){
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return l;
    }

    // 1 2 3
    // mid = 2 l=1 h=1 ; l=1 h=0
    // mid = 2 l=1 h=1 ; l=2 h=1
    // mid = 2 l=3 h=3; l=3 h=2

    public static boolean check(long x){

        long p = 0;
        for(int i=0; i<list.size(); i++){
            long current = list.get(i);

            p += current / x + (current % x > 0 ? 1 : 0);
        }

        return p <= N;
    }
}
