import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/7453
class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] map = new int[4][N];

        long[] ab = new long[N * N];
        long[] cd = new long[N * N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[0][i] = a;
            map[1][i] = b;
            map[2][i] = c;
            map[3][i] = d;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                ab[(i * N) + j] = map[0][i] + map[1][j];
                cd[(i * N) + j] = map[2][i] + map[3][j];
            }
        }
        Arrays.sort(cd);

        long c = 0;
        // 16,000,000 * 24
        for(int i=0; i<ab.length; i++){
            int upper = upperBound(cd, ab[i] * -1);
            int lower = lowerBound(cd, ab[i] * -1);
            c += (upper - lower);
        }

        System.out.println(c);
    }

    public static int upperBound(long[] map, long value){
        int l = 0;
        int h = map.length - 1;

        int mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(map[mid] <= value){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return h;
    }

    // 1 2 3
    // l=1 h=1 l=2 h=1
    // l=3 h=3 l=3 h=2
    // l=3 h=3 l=4 h=3

    public static int lowerBound(long[] map, long value){
        int l = 0;
        int h = map.length - 1;

        int mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(map[mid] >= value){
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return h;
    }

    // 1 2 3
    // l=1 h=1 l=1 h=0
    // l=1 h=1 l=2 h=1
    // l=3 h=3 l=3 h=2

}
