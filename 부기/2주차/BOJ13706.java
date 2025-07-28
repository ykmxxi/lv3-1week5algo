import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

// https://www.acmicpc.net/problem/13706
class Main {
    static BigInteger one = new BigInteger("1");
    static BigInteger two = new BigInteger("2");
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());

        System.out.println(binarySearch(N));
    }

    public static BigInteger binarySearch(BigInteger N){
        BigInteger l = one;
        BigInteger h = N.divide(two);

        BigInteger mid;

        while (l.compareTo(h) <= 0) {
            mid = l.add(h).divide(two);

            if(mid.pow(2).compareTo(N) <= 0){
                l = mid.add(one);
            } else {
                h = mid.subtract(one);
            }
        }

        return h;
    }
}
