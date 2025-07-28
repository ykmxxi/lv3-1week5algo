import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1267
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            y += (now / 30 + 1) * 10;
            m += (now / 60 + 1) * 15;
        }

        if(y < m){
            System.out.println("Y " + y);
        }
        else if (y > m){
            System.out.println("M " + m);
        } else {
            System.out.println("Y M " + y);
        }
    }
}
