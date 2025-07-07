//  상근이의 친구들

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int M = sc.nextInt();
            int F = sc.nextInt();
            if (M + F == 0) {
                break;
            }

            System.out.println(M + F);
        }
    }
}
