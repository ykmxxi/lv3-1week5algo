import java.util.Scanner;

// 팰린드롬인지 확인하기
// https://www.acmicpc.net/problem/10988
public class BOJ10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        sc.close();
        int len = str.length();
        int ans = 1;

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                ans = 0;
            }
        }
        System.out.println(ans);

    }
}
