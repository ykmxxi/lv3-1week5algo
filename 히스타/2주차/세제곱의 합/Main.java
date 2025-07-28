//  세제곱의 합

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= N; ++i) {
            sum += i;
        }

        System.out.println(sum);
        System.out.println((int) Math.pow(sum, 2));
        System.out.println((int) Math.pow(sum, 2));
    }
}
