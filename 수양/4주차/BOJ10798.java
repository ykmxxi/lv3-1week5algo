import java.io.*;

// 세로읽기
// https://www.acmicpc.net/problem/10798
public class BOJ10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        int max = 0;

        for (int i = 0; i<5; i++) {
            String s = br.readLine();
            max = Math.max(max, s.length());
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == '\0') continue; 
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb.toString());
    }
}
