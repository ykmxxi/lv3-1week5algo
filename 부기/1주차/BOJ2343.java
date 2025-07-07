import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2343
// 모두 녹화할 수 있는 블루레이의 크기를 최소화 -> lower bound
class BOJ2343 {
    static List<Integer> list = new ArrayList<>();
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(binarySearch());
    }

    public static long binarySearch(){
        long l = 1;
        long h = 1_000_000_000;

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

    // 1 2 3
    // 1 mid = 2 l = 1 h = 1; l = 1 h = 0
    // 2 mid = 2 l = 1 h = 1; l = 2 h = 1
    // 3 mid = 2 l = 3 h = 3; l = 3 h = 2
    public static boolean check(long size){

        long c = 1;
        long now = size;
        for(int i=0; i<list.size(); i++){
            long len = list.get(i);
            if(len > size) return false;

            if(now < len){
                c++;
                now = size;
            }
            now -= len;
        }

        return c <= M;
    }
}
