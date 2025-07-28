import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아이 러브 크로아티아
public class BOJ9517 {

    static final int MOD = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int currentTurn = k - 1;
        int timeLeft = 210;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int timeTaken = Integer.parseInt(st.nextToken());
            String state = st.nextToken(); // T, N, P

            timeLeft -= timeTaken;
            if (timeLeft <= 0) {
                System.out.println(currentTurn + 1);
                return;
            }

            if (state.equals("T")) {
                currentTurn = (currentTurn + 1) % MOD;
            }
        }
    }
}
