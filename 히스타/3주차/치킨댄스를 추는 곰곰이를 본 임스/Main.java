//  치킨댄스를 추는 곰곰이를 본 임스

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalChicken = sc.nextInt();
        int coke = sc.nextInt();
        int beer = sc.nextInt();

        int eatable = (int) (coke / 2) + beer;
        System.out.println(totalChicken > eatable ? eatable : totalChicken);
    }
}
