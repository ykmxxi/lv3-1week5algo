import java.util.*;
import java.lang.*;
import java.io.*;

//  A+B−C$A + B - C$ 
// https://www.acmicpc.net/problem/31403
class BOJ31403 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(a + b - c);
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(b);
        System.out.println(Integer.parseInt(sb.toString()) - c);
    }
}