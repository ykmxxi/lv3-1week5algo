import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2805
// M길이 보다 많은 나무를 가져갈 수 있는 최솟값
class Main {
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(binarySearch(list));

    }

    public static int binarySearch(List<Integer> list){
        long l = 1;
        long h = 2_000_000_000;

        long mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(check(list, mid)){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return (int) l-1;
    }

    public static boolean check(List<Integer> list, long now){

        long sum = 0;
        for(int i=0; i<list.size(); i++){
            long tree = list.get(i);
            if(tree > now){
                sum += tree - now;
            }
        }

        return sum >= M;
    }
}
