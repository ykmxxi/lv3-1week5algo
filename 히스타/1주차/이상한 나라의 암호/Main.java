//  이상한 나라의 암호

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (count++ >= 0) {
            String str = sc.nextLine();
            if (str.equals("Was it a cat I saw?")) {
                return;
            }

            for (int i = 0; i < str.length(); i += count) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }
}
