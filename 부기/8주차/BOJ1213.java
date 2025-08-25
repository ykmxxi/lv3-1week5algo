import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/1213
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] values = br.readLine().toCharArray();

        int[] count = new int[26];
        for(int i=0; i<values.length; i++){
            count[values[i] - 'A']++;
        }

        int i = 0;
        int c = 0;
        int idx = 0;
        while(i < values.length / 2){
            if(idx >= count.length) break;

            if(count[idx] >= 2){
                values[i] = (char)(idx + 'A');
                values[values.length - 1 - i] = (char)(idx + 'A');
                count[idx] -= 2;
                i++;
            }
            else if(count[idx] == 1){
                c++;
                idx++;
            }
            else {
                idx++;
            }
        }

        if(c >= 2){
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        if(values.length % 2 == 1){
            for(int j=0; j<count.length; j++){
                if(count[j] == 1){
                    values[values.length / 2] = (char)(j + 'A');
                    break;
                }
            }
        }

        System.out.println(new String(values));
    }
}
