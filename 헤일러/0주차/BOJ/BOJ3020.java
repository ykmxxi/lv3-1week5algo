import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ3020 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로 N, 세로 H
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if ((i & 1) > 0) {
                high.add(x);
            } else {
                low.add(x);
            }
        }
        Collections.sort(low);
        Collections.sort(high);

        int ans = Integer.MAX_VALUE;
        int ansCount = 0;
        for (int h = 1; h <= H; h++) {
            int lowCount = low.size() - lowerBound(low, h);
            int highCount = high.size() - lowerBound(high, H - h + 1);
            int count = lowCount + highCount;
            if (ans > count) {
                ans = count;
                ansCount = 1;
            } else if (ans == count) {
                ansCount++;
            }
        }

        System.out.println(ans + " " + ansCount);
    }

    public static int lowerBound(ArrayList<Integer> A, int target) {
        int l = 0, r = A.size() - 1;
        while (l <= r) {
            int mid = (r + l) / 2;

            if (A.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
