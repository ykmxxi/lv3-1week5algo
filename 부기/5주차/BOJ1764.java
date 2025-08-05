import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1764
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }


        List<String> answers = new ArrayList<>();
        for(int i=0; i<M; i++){
            String now = br.readLine();
            if(set.contains(now)){
                answers.add(now);
            }
        }

        System.out.println(answers.size());
        Collections.sort(answers);
        StringBuilder sb = new StringBuilder();
        for(String now : answers){
            sb.append(now).append("\n");
        }
        System.out.println(sb);

    }
}
