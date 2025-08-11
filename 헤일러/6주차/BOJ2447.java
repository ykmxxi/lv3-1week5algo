import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2447
// 별 찍기 - 10
// 카테고리: 분할 정복
public class BOJ2447 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static char[][] board = new char[7000][7000];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int k = calculateK(N);
        DnC(0, 0, N, k);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(board[i][j] == '*' ? board[i][j] : ' ');
            }
            bw.write("\n");
        }
        bw.flush();
    }

    static int calculateK(int N) {
        int k = 0;
        while (N > 0) {
            N /= 3;
            k++;
        }
        return k;
    }

    static void DnC(int r, int c, int size, int level) {
        if (level == 0) {
            board[r][c] = '*';
            return;
        }

        int step = size / 3;
        for (int i = 0; i < 3; i++) {
            int nr = r + step * i;
            for (int j = 0; j < 3; j++) {
                int nc = c + step * j;

                if (i == 1 && j == 1) {
                    continue;
                }
                DnC(nr, nc, size / 3, level - 1);
            }
        }
    }
}
