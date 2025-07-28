import java.util.*;
import java.io.*;

// 재귀의 귀재
// https://www.acmicpc.net/problem/25501
public class BOJ25501 {

    public static int result;

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            result = 0;
            int getPalindromeNum = isPalindrome(s);
            System.out.println(getPalindromeNum + " " + result);
        }
    }

    static int recursion(String s, int l, int r){
        result++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
