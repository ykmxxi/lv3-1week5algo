//  닉네임에 갓 붙이기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        sc.nextLine();
        while (TC-- > 0) {
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            if (lines.length >= 1) {
                lines[0] = "god";
            }
            for (int i = 0; i < lines.length; ++i) {
                System.out.print(lines[i]);;
            }
            System.out.println();
        }
    }
}
