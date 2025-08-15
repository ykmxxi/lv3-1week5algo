//  헛간 청약

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cows = sc.nextInt();
        int size_r = sc.nextInt();
        int size_c = sc.nextInt();
        int space_size = sc.nextInt();

        int maximum_cow_count = (size_r / space_size) * (size_c / space_size);
        System.out.println(maximum_cow_count > cows ? cows : maximum_cow_count);
    }
}
