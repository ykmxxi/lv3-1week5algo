import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/9375
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> cloths = new HashMap<>();

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                String cloth = st.nextToken();
                String type = st.nextToken();

                cloths.put(type, cloths.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for(int count : cloths.values()){
                // 의상을 입는 경우의 수 + 의상을 입지 않는 경우의 수
                answer *= (count + 1);
            }

            // 전체 경우의 수 - 아무것도 입지 않은 경우의 수
            sb.append((answer - 1)).append("\n");
        }

        System.out.println(sb);
    }
}
