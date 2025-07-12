import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/4158
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        while(N != 0 || M != 0){
            int answer = 0;

            List<Integer> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                list.add(Integer.parseInt(br.readLine()));
            }

            for(int i=0; i<M; i++){
                int x = Integer.parseInt(br.readLine());
                answer += binarySearch(list, x) ? 1 : 0;
            }

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            System.out.println(answer);
        }
    }

    public static boolean binarySearch(List<Integer> list, int x){
        int l = 0;
        int h = list.size() - 1;

        int mid;
        while (l<=h) {
            mid = (l + h) / 2;

            if(list.get(mid) <= x){
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }

        return list.get(h) == x;
    }

    // 1 2 3
    // l=1 h=1; l=2 h=1
    // l=3 h=3; l=3 h=2
    // l=3 h=3; l=4 h=3
}
