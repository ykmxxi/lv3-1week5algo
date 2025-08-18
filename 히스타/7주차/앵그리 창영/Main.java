//  앵그리 창영

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int lim = W * W + H * H;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int L = Integer.parseInt(br.readLine());
            sb.append((long)L * L <= lim ? "DA" : "NE").append('\n');
        }
        System.out.print(sb.toString());
    }
}
