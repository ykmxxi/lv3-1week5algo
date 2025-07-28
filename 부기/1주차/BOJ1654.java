import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1654
// 필요한 랜선의 개수 M개를 만드려고한다.
// 이때 M개를 만들 수 있으면서 랜선의 길이가 최대가 되는 지점 즉, upper bound를 찾는 문제이다.
class BOJ1654 {
    static int M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(binarySearch(list));

    }

    public static int binarySearch(List<Integer> list){
        long l = 0;
        long h = Integer.MAX_VALUE;

        long mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(check(list, mid)){
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }

        return (int) l - 1;
    }
    // 공통점 l = 정답 + 1
    // 1 2 3
    // 1이 정답인 경우,
    // mid = 2 -> h = 1, l = 2 h = 1 종료 l = 2
    // 2가 정답인 경우,
    // mid = 2 -> l = 3 h = 3; mid = 3 h = 2 종료 l = 3
    // 3이 정답인 경우
    // mid = 2 -> l = 3 h = 3; mid = 3 l = 4 h = 3 종료 l = 4

    public static boolean check(List<Integer> list, long size){
        int sum = 0;
        for(int now : list){
            sum += now / size;
        }
        return sum >= M;
    }
}
