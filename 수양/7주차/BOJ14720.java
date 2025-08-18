import java.util.*;
import java.lang.*;
import java.io.*;

// 우유 축제
// https://www.acmicpc.net/problem/14720
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int need = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == need) {
                ans++;
                need = (need + 1) % 3;
            }
        }
        System.out.println(ans);
    }
}
