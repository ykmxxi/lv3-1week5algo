import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/17219
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> passwords = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            String site = st.nextToken();
            String password = st.nextToken();

            passwords.put(site, password);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String site = br.readLine();

            sb.append(passwords.get(site)).append("\n");
        }

        System.out.println(sb);
    }
}
