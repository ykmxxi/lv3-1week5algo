import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/3079
class Main {
    static List<Long> list = new ArrayList<>();
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long max = 0;
        for(int i=0; i<N; i++){
            long now = Long.parseLong(br.readLine());
            list.add(now);
            max = Math.max(now, max);
        }
        Collections.sort(list);

        System.out.println(binarySearch(max));
    }

    public static long binarySearch(long max){
        long l = 1;
        long h = 1_000_000_000L * max;

        long mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(!check(mid)){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return l;
    }

    // 1 2 3 -> 1 1 -> 1 0
    // 1 2 3 -> 1 1 -> 2 1
    // 1 2 3 -> 3 3 -> 3 2

    public static boolean check(long time){

        long sum = 0;
        for(int i=0; i<list.size() && sum < M; i++){
            sum += time / list.get(i);
        }

        return sum >= M;
    }
}
