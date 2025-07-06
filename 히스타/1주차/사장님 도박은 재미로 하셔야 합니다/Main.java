//  사장님 도박은 재미로 하셔야 합니다

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int input = sc.nextInt();
            if (input == -1) {
                break;
            }

            sum += input;
        }

        System.out.println(sum);
    }
}
