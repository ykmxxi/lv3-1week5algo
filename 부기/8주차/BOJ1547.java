import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1547
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] map = {1, 2, 3};
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int idxA = 0;
            int idxB = 0;
            for(int j=0; j<3; j++){
                if(map[j] == a){
                    idxA = j;
                }
                if(map[j] == b){
                    idxB = j;
                }
            }

            map[idxA] = b;
            map[idxB] = a;
        }

        System.out.println(map[0]);

    }

    // 1 2 3
    // 3 2 1
    // 2 3 1
    // 2 1 3
    // 3 1 2

    // 1 2 3
    // 3 2 1
    // 3 1 2
    // 2 1 3
    // 2 3 1
}
