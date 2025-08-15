//  시간과 날짜

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] daysInMonth = {
            0, 31, 29, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            String time = (0 <= x && x <= 23 && 0 <= y && y <= 59) ? "Yes" : "No";
            String date = (1 <= x && x <= 12 && 1 <= y && y <= daysInMonth[x]) ? "Yes" : "No";

            System.out.println(time + " " + date);
        }
    }
}
