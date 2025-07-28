//  삼각 무늬 - 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        while (TC-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println((int) Math.pow((double) A / B, 2));
        }
    }
}
