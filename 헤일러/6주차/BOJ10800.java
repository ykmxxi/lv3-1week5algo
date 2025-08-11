import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10800
// 컬러볼
// 카테고리: 정렬, 누적합, 투 포인터
public class BOJ10800 {

    static final int MAXC = 200000;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static long[] ans = new long[MAXC];
    static long[] colorSum = new long[MAXC + 1];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        List<Ball> balls = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            balls.add(new Ball(i, C, S));
        }
        balls.sort((b1, b2) -> b1.size - b2.size);

        long allSum = 0;
        int j = 0;

        for (int i = 0; i < balls.size(); i++) {
            Ball current = balls.get(i);

            while (balls.get(j).size < current.size) {
                Ball prev = balls.get(j);
                allSum += prev.size;
                colorSum[prev.color] += prev.size;
                j++;
            }

            ans[current.idx] = allSum - colorSum[current.color];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static class Ball {
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
}
