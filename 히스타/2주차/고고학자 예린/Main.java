//  고고학자 예린

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            System.out.println(performancedDolmen(a, b));
        }
    }

    public static int dolmen(int a, int b) {
        int sum, i, j, k;
        sum = 0;
        for (i = 0; i < a + b; ++i) {
            for (j = 0; j < a + b; ++j) {
                for (k = 0; k < j; ++k) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static long performancedDolmen(int a, int b) {
        long n = (long) a + b;
        return n * n * (n - 1) / 2;
    }
}
