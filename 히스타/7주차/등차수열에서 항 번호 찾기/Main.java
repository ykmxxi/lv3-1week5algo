//  등차수열에서 항 번호 찾기

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long d = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long diff = k - a;
        if (diff % d != 0) {
            System.out.print("X");
            return;
        }
        long n = diff / d + 1;
        if (n >= 1)
            System.out.print(n);
        else
            System.out.print("X");
    }
}
