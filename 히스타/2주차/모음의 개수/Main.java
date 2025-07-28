//  모음의 개수

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<Character> aieou = Set.of('a', 'i', 'e', 'o', 'u');

        int answer = 0;
        for (int i = 0; i < str.length(); ++i) {
            char cur = str.charAt(i);
            if (aieou.contains(cur)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
