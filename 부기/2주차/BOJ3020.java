import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/3020
class Main {
    static List<Integer> t = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();
    static int H;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            if(i % 2 == 0) b.add(now);
            else t.add(now);
        }

        Collections.sort(b);
        Collections.sort(t);

        int min = 200_001;
        int c = 0;
        for(int i=1; i<= H; i++){
            int idx1 = binarySearch1(i);
            int idx2 = binarySearch2(i);

            int sum = (b.size() - idx1 - 1) + (t.size() - idx2 - 1);
            if(min == sum){
                c++;
            } else if(min > sum){
                c = 1;
                min = sum;
            }
        }

        System.out.println(min + " " + c);

    }

    // 석순을 피하는 upper bound
    public static int binarySearch1(int now){
        int l = 0;
        int h = b.size()-1;

        int mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(b.get(mid) < now){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return h;
    }

    // 1 2 3 -> l=1 h=1 -> l=2 h=1
    // 1 2 3 -> l=3 h=3 -> l=3 h=2
    // 1 2 3 -> l=3 h=3 -> l=4 h=3

    // 종유석을 피하는 upper bound
    public static int binarySearch2(int now){
        int l = 0;
        int h = t.size()-1;

        int mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(H - t.get(mid) >= now){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return h;
    }

    // 1 2 3 -> l=1 h=1 -> l=2 h=1
    // 1 2 3 ->
    // 1 2 3

}
