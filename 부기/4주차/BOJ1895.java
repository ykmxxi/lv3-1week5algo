import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1895
class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int T = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++){
                answer += mid(i, j, map) >= T ? 1 : 0;
            }
        }

        System.out.println(answer);
    }

    public static int mid(int i, int j, int[][] map){
        List<Integer> list = new ArrayList<>();
        for(int x=i; x<i + 3; x++){
            for(int y=j; y<j + 3; y++){
                list.add(map[x][y]);
            }
        }
        Collections.sort(list);

        return list.get(4);
    }
}
