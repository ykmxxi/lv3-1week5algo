import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2470 {

    final static int MAXN = 100_000 + 1;
    static boolean[] check = new boolean[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        // 커스텀 정렬 연습
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer s1, Integer s2) {
                return Integer.compare(s1, s2);
            }
        });

        int cand1 = A.get(0), cand2 = A.get(1);
        int ansSum = Math.abs(cand1 + cand2);
        for (int i = 0; i < N; i++) {
            check[i] = true;

            int pivot = A.get(i);
            int lbIdx = bs(A, -pivot);

            for (int j = lbIdx - 2; j <= lbIdx + 2; j++) {
                int pairIdx = Math.min(Math.max(0, j), A.size() - 1);
                if (check[pairIdx]) {
                    continue;
                }
                int curSum = Math.abs(pivot + A.get(pairIdx));
                if (ansSum > curSum) {
                    ansSum = curSum;
                    cand1 = pivot;
                    cand2 = A.get(pairIdx);
                }
            }
            check[i] = false;
        }

        System.out.println(cand1 + " " + cand2);
    }

    // return index of lower bound
    public static int bs(ArrayList<Integer> A, Integer target) {
        int l = 0, r = A.size() - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (A.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
