import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1759 {

    private static List<String> MOEUM = List.of("a", "e", "i", "o", "u");
    private static List<String> currentPassword;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        List<String> as = Arrays.asList(br.readLine().split(" "));

        Collections.sort(as);
        dfs(0, 0, 0, new ArrayDeque<>(), L, C, as);
    }

    // C개 중에 L개 추출
    public static void dfs(int pi, int mcnt, int jcnt,
                           ArrayDeque<String> currentPassword,
                           final int L, final int C, final List<String> as) {

        if (currentPassword.size() == L) {
            if (!(mcnt >= 1 && jcnt >= 2)) {
                return;
            }
            String ans = String.join("", currentPassword);
            System.out.println(ans);
            return;
        }
        if (pi == C) {
            return;
        }

        for (int i = pi; i < C; i++) {
            boolean isMoeum = MOEUM.contains(as.get(i));

            currentPassword.addLast(as.get(i));
            dfs(i + 1, isMoeum ? mcnt + 1 : mcnt, isMoeum ? jcnt : jcnt + 1,
                    currentPassword, L, C, as);
            currentPassword.removeLast();
        }
    }
}
