//  접시 안의 원

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        double answer = T * T / 4;
        System.out.println(Math.round(answer));
    }
}
