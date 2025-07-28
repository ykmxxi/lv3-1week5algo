//  샤틀버스

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        //
        if (y >= x) {
            System.out.println(y - x);
            return;
        }

        System.out.println(x + y);
    }
}
