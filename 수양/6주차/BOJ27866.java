import java.util.*;
import java.lang.*;
import java.io.*;

//  문자와 문자열
// https://www.acmicpc.net/problem/27866
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int i = sc.nextInt();
        System.out.print(text.charAt(i - 1));
    }
}
