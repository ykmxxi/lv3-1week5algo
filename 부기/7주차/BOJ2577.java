import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/2577
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int value = 1;
        for(int i=0; i<3; i++){
            value *= Integer.parseInt(br.readLine());
        }

        char[] count = new char[10];
        char[] val = String.valueOf(value).toCharArray();

        for(char v : val){
            count[v - '0']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int c : count){
            sb.append(c).append("\n");
        }

        System.out.println(sb);

    }
}
