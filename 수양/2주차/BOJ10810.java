import java.util.Scanner;

// https://www.acmicpc.net/problem/10810
public class BOJ10810 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 바구니의 개수
        int m = sc.nextInt(); // 골을 넣는 방법

        int[] answer = new int[n];

        for (int a = 0; a < m; a++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            for (int l = i - 1; l < j; l++) {
                answer[l] = k;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}