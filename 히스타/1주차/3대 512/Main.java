//  3대 512

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int curHighest = -1;
        int lowestDiff = Integer.MAX_VALUE;
        while (N-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int total = a + b + c;
            if (total >= 512 && lowestDiff > Math.abs(total - 512)) {
                curHighest = total;
                lowestDiff = Math.abs(total - 512);
            }
        }

        System.out.println(curHighest);
    }
}
