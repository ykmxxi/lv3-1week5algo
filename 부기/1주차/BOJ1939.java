import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1939
class Main {
    static List<List<int[]>> list = new ArrayList<>();
    static boolean isEnd;
    static int end;
    static int start;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st  = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[]{b, c});
            list.get(b).add(new int[]{a, c});
        }

        st  = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(binarySearch());
    }

    public static int binarySearch(){
        int l = 0;
        int h = 1_000_000_000;

        int mid;
        while (l <= h) {
            mid = (l + h) / 2;

            if(check(mid)){
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

    public static boolean check(int size){
        isEnd = false;
        dfs(new boolean[N + 1], start, size);

        return isEnd;
    }

    public static void dfs(boolean[] visit, int now, int size){
        if(now == end){
            isEnd = true;
        }

        for(int i=0; i<list.get(now).size() && !isEnd; i++){
            int next = list.get(now).get(i)[0];
            if(!visit[next] && list.get(now).get(i)[1] >= size){
                visit[next] = true;
                dfs(visit, list.get(now).get(i)[0], size);
            }
        }

    }

}
