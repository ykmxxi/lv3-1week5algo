import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2747
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N <= 1){
            System.out.println(N);
            return;
        }

        int[] f = new int[N+1];
        f[1] = 1;

        for(int i=2; i<=N; i++){
            f[i] = f[i-1] + f[i-2];
        }

        System.out.println(f[N]);
    }
}
