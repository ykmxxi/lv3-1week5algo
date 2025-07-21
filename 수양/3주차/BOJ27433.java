import java.io.*;

// 팩토리얼 2
// https://www.acmicpc.net/problem/27433
public class BOJ27433 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));
    }    

    public static long factorial(long n) {
        if (n > 0) {
            return n * factorial(n-1);
        }
        return 1;
    }
}
