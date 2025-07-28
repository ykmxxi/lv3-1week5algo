//  Darius님 한타 안 함?

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] tokens = input.split("/");
        int K = Integer.parseInt(tokens[0]);
        int D = Integer.parseInt(tokens[1]);
        int A = Integer.parseInt(tokens[2]);
        System.out.println((K + A < D || D == 0) ? "hasu" : "gosu");
    }
}
