//  별 찍기 - 9

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int spaceCount = 0;
        int starNum = N * 2 - 1;

        for (int i = 0; i < N; ++i) {
            space(spaceCount);
            for (int j = 0; j < starNum; ++j) {
                System.out.print("*");
            }
            spaceCount++;
            starNum -= 2;
            System.out.println();
        }

        spaceCount--;
        starNum += 2;

        for (int i = 0; i < N - 1; ++i) {
            spaceCount--;
            starNum += 2;
            space(spaceCount);
            for (int j = 0; j < starNum; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void space(int spaceCount) {
        if (spaceCount == 0) {
            return;
        }

        for (int i = 0; i < spaceCount; ++i) {
            System.out.print(" ");
        }
    }
}
