//  Goodbye, Code Jam

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int i = 0; i < TC; i++) {
            int x = sc.nextInt();
            System.out.print("Case #" + (i + 1) + ": ");
            if (x > 4500) {
                System.out.println("Round 1");
            } else if (x > 1000) {
                System.out.println("Round 2");
            } else if (x > 25) {
                System.out.println("Round 3");
            } else {
                System.out.println("World Finals");
            }
        }
    }
}
